package com.microservices.messages.service.implementation;

import com.microservices.messages.dto.OrderDTO;
import com.microservices.messages.dto.RequestDTO;
import com.microservices.messages.dto.UserDTO;
import com.microservices.messages.model.Order;
import com.microservices.messages.model.Request;
import com.microservices.messages.model.User;
import com.microservices.messages.repository.*;
import com.microservices.messages.service.IRequestService;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RequestService implements IRequestService {

    @Autowired
    private OrderRepository orderRepositiory;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private AdCarRepository adCarRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IAgentRepository agentRepository;

    @Override
    public RequestDTO getRequest(long id) {
        return null;
    }

    @Override
    public List<RequestDTO> getAllRequests() {
            List<Request> requestList = requestRepository.findAll();
            return requestList.stream().map(patient -> mapToResponse(patient)).collect(Collectors.toList());
    }

    private RequestDTO mapToResponse(Request request) {
        RequestDTO response = new RequestDTO();
        response.setId(request.getId());
        response.setStatus(request.getStatus());
        response.setBundle(request.getBundle());
        response.setOrderList(request.getOrderList());
        return response;
    }



//    @Override
//    public List<UserDTO> getAllUsers() {
//        List<User> userList = userRepository.findAll();
//        return userList.stream().map(patient -> mapToResponse(patient)).collect(Collectors.toList());
//    }
//
//    private UserDTO mapToResponse(User user) {
//        UserDTO response = new UserDTO();
//        response.setId(user.getId());
//        response.setName(user.getName());
//        response.setEmail(user.getEmail());
//        return response;
//    }

    @Override
    public void cancelRequest(long id) {

    }

    @Override
    public void cancelRequestFromAgent(long id, long idAgent) {

    }

    @Override
    public void acceptRequestFromAgent(long id, long idAgent) {

    }

    @Override
    public RequestDTO createRquestForUser(Boolean bundle, OrderDTO order) {


        Long agentIzdaoId = order.getAdCar().getAgentIzdaoAd().getId();
        Long userIzdaoId = order.getAdCar().getUserIzdavaoAd().getId();
        int brojIstihAgenata = 1;
        List<Order> orders= orderRepositiory.findAll();
        List<Order> bundleOrders= new ArrayList<>();
        System.out.println("AGENT ID JEEEEEE"+agentIzdaoId);
        System.out.println("Bunleeeee"+bundle);
        User userProvera = userRepository.findById(1);

        Calendar calendar= Calendar.getInstance();

        calendar.add(Calendar.HOUR_OF_DAY, +24);

        if(bundle==true){
            for(Order ord:orders){
                if(ord.getUserr().getId().equals(userProvera.getId())){
                    System.out.println("User ID jeeeee"+ord.getUserr().getId());
                    if(order.getAdCar().getAgentIzdaoAd().getId()!=null) {
                        System.out.println("Opet agenttttt"+order.getAdCar().getAgentIzdaoAd().getId());
                        if (ord.getAgentIzdao().getId().equals(agentIzdaoId)) {
                            System.out.println("Agent provera jednakosti"+ord.getAgentIzdao().getId());
                            Order orderTrue = orderRepositiory.findOneById(ord.getId());
                            bundleOrders.add(orderTrue);
                        }
                    }
                    else{
                        if(ord.getUserIzdavao().getId().equals(userIzdaoId)){
                            Order orderTrue = orderRepositiory.findOneById(ord.getId());
                            bundleOrders.add(orderTrue);
                        }
                    }

                }
            }
            Request newRequest= new Request();
            newRequest.setBundle(bundle);
            newRequest.setStatus("PENDING");
            newRequest.setPaymentDate(calendar.getTime());
            newRequest.setOrderList(bundleOrders);

            requestRepository.save(newRequest);
            RequestDTO requestDTO = new RequestDTO(newRequest);

            return requestDTO;

        } else{

            Request newRequest= new Request();
            newRequest.setBundle(bundle);
            newRequest.setStatus("PENDING");
            newRequest.setPaymentDate(calendar.getTime());
            Order orderFalse = orderRepositiory.findOneById(order.getId());
            bundleOrders.add(orderFalse);
            newRequest.setOrderList(bundleOrders);
            requestRepository.save(newRequest);
            RequestDTO requestDTO = new RequestDTO(newRequest);


            return requestDTO;


        }
    }

    @Scheduled(fixedRate = 1000)
    public void sistemskoOdbijanje24h(){

        List<Request> requests= requestRepository.findAll();
        Calendar calendar= Calendar.getInstance();

        for(Request r:requests){
            if(r.getStatus().equals("PENDING")){
                if(calendar.getTime().after(r.getPaymentDate())){
                    Request request = requestRepository.findOneById(r.getId());
                    request.setStatus("CANCELED");
                    requestRepository.save(request);
                }
            }
        }
    }


    @Override
    public RequestDTO presonallyRequest(OrderDTO order) {

        Order order1 = new Order();

        order1.setAvailableFrom(order.getAvailableFrom());
        order1.setAvailableTo(order.getAvailableTo());
        order1.setAdCar(adCarRepository.findOneById(order.getAdCar().getId()));
        order1.setUserr(userRepository.findById(1));
        order1.setUserIzdavao(userRepository.findById((long)order.getAdCar().getUserIzdavaoAd().getId()));
        order1.setAgentIzdao(agentRepository.findById((long)order.getAdCar().getAgentIzdaoAd().getId()));


        orderRepositiory.save(order1);

        List<Request> requests= requestRepository.findAll();
        List<Order> bundleOrders= new ArrayList<>();

        Request newRequest= new Request();
        newRequest.setBundle(false);
        newRequest.setStatus("RESERVED");
        bundleOrders.add(order1);
        newRequest.setOrderList(bundleOrders);
        requestRepository.save(newRequest);

        for (Request req:requests){
            for(int i=0; i<req.getOrderList().size(); i++) {
                if (req.getOrderList().get(i).getAdCar().getId().equals(order.getAdCar().getId())){
                    Request request1= requestRepository.getOne(req.getId());
                    request1.setStatus("CACELED");
                    requestRepository.save(request1);
                }
            }
        }


        RequestDTO requestDTO = new RequestDTO(newRequest);
        return  requestDTO;
    }

    @Override
    public List<RequestDTO> agentRequests(Long agentId) {

        List<Request> requests = requestRepository.findAll();
        List<RequestDTO> requestsDTO= new ArrayList<>();
        System.out.println("Agent iddddddddddd"+agentId);
        for(Request req:requests){
            if(req.getStatus().equals("PENDING")) {
                for (int i = 0; i < req.getOrderList().size(); i++) {
                    System.out.println("Agent u petljiiiii" + req.getOrderList().get(i).getAgentIzdao().getId());
                    if (req.getOrderList().get(i).getAgentIzdao().getId().equals(agentId)) {
                        requestsDTO.add(new RequestDTO(req));
                    }
                    break;
                }
            }
        }
        return requestsDTO;
    }

    @Override
    public RequestDTO acceptRequest(Long idRequest) {

        Request request = requestRepository.findOneById(idRequest);

        Calendar calendar= Calendar.getInstance();

        calendar.add(Calendar.HOUR_OF_DAY, +12);

        request.setStatus("RESERVED");
        request.setPaymentDate(calendar.getTime());
        requestRepository.save(request);

        RequestDTO requestDTO= new RequestDTO(request);

        return requestDTO;
    }

    @Scheduled(fixedRate = 1000)
    public void sistemskoOdbijanje(){

        List<Request> requests= requestRepository.findAll();
        Calendar calendar= Calendar.getInstance();

        for(Request r:requests){
            if(r.getStatus().equals("RESERVED")){
                if(calendar.getTime().after(r.getPaymentDate())){
                    Request request = requestRepository.findOneById(r.getId());
                    request.setStatus("CANCELED");
                    requestRepository.save(request);
                }
            }
        }
    }

    @Override
    public RequestDTO declineRequest(Long idRequest) {

        Request request = requestRepository.findOneById(idRequest);
        request.setStatus("CANCELED");
        requestRepository.save(request);

        RequestDTO requestDTO= new RequestDTO(request);

        return requestDTO;
    }

    @Override
    public List<RequestDTO> userRequests(Long idUser) {

        List<Request> requets =requestRepository.findAll();
        List<RequestDTO> requestsDTO= new ArrayList<>();

        for(Request req: requets) {
            for (int i = 0; i < req.getOrderList().size(); i++) {
                if (req.getOrderList().get(i).getUserr().getId().equals(idUser)) {
                    if (req.getStatus().equals("RESERVED")) {
                        requestsDTO.add(new RequestDTO(req));
                    }
                    break;
                }
            }
        }
        return requestsDTO;
    }

    @Override
    public RequestDTO paidRequest(Long idRequest) {

        Request request = requestRepository.findOneById(idRequest);
        request.setStatus("PAID");
        requestRepository.save(request);

        List<Request> requests = requestRepository.findAll();

        for(Request req:requests){
            for (int i = 0; i < req.getOrderList().size(); i++) {
                for (int j=0; j < request.getOrderList().size(); j++){
                    if (!req.getId().equals(request.getId()) && req.getOrderList().get(i).getAdCar().getId().equals(request.getOrderList().get(j).getAdCar().getId())) {
                        Request request1= requestRepository.getOne(req.getId());
                        request1.setStatus("CANCELED");
                        requestRepository.save(request1);
                    }

                }
            }
        }

        RequestDTO requestDTO= new RequestDTO(request);

        return requestDTO;
    }


}