package com.microservices.ordering.service.implementation;


import com.microservices.ordering.dto.OrderDTO;
import com.microservices.ordering.dto.RequestDTO;
import com.microservices.ordering.model.Order;
import com.microservices.ordering.model.Request;
import com.microservices.ordering.model.Users;
import com.microservices.ordering.repository.*;
import com.microservices.ordering.service.IRequestService;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

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
    private UserRepository userRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public RequestDTO getRequest(long id) {
        return null;
    }

    @Override
    public Set<RequestDTO> getAllRequests() {
        return null;
    }

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
    public List<OrderDTO> createRquestForUser(Boolean bundle, OrderDTO order) {


        //Long agentIzdaoId = order.getAdCar().getAgentIzdaoAd().getId();
        //Long userIzdaoId = order.getAdCar().getUserIzdavaoAd().getId();
        int brojIstihAgenata = 1;
        List<Order> orders= orderRepositiory.findAll();
        List<Order> bundleOrders= new ArrayList<>();
        //System.out.println("AGENT ID JEEEEEE"+agentIzdaoId);
        System.out.println("Bunleeeee"+bundle);
        Users userProvera = userRepository.findOneById(1);

        Calendar calendar= Calendar.getInstance();

        calendar.add(Calendar.HOUR_OF_DAY, +24);

        if(bundle==true){
            /*for(Order ord:orders){
                if(ord.getUserr().getId().equals(userProvera.getId())){
                    System.out.println("User ID jeeeee"+ord.getUserr().getId());
                    if(order.getAdCar().getAgentIzdaoAd().getId()!=null) {
                        System.out.println("Opet agenttttt"+order.getAdCar().getAgentIzdaoAd().getId());
                        if (ord.getAgentIzdao().getId().equals(agentIzdaoId)) {
                            System.out.println("Agent provera jednakosti"+ord.getAgentIzdao().getId());
                            Order orderTrue = orderRepositiory.findOneById(ord.getId());
                            orderTrue.setRequired(true);
                            orderRepositiory.save(orderTrue);
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
            }*/
            Request newRequest= new Request();
            newRequest.setBundle(bundle);
            newRequest.setStatus("PENDING");
            newRequest.setAcceptDate(calendar.getTime());
            newRequest.setOrderList(bundleOrders);

            requestRepository.save(newRequest);
            RequestDTO requestDTO = new RequestDTO(newRequest);

            List<OrderDTO> ordersOfUser= new ArrayList<>();
            List<Order> orderss= orderRepositiory.findAll();

            for(Order o: orderss){
                if(o.getRequired()==false) {
                    if (o.getUserr().getId().equals(1)) {
                        ordersOfUser.add(new OrderDTO(o));
                    }
                }
            }

            return ordersOfUser;

        } else{

                Request newRequest= new Request();
                newRequest.setBundle(bundle);
                newRequest.setStatus("PENDING");
                newRequest.setAcceptDate(calendar.getTime());
                Order orderFalse = orderRepositiory.findOneById(order.getId());
                orderFalse.setRequired(true);
                orderRepositiory.save(orderFalse);
                bundleOrders.add(orderFalse);
                newRequest.setOrderList(bundleOrders);
                requestRepository.save(newRequest);
                RequestDTO requestDTO = new RequestDTO(newRequest);


            List<OrderDTO> ordersOfUser= new ArrayList<>();
            List<Order> orderss= orderRepositiory.findAll();

            for(Order o: orderss){
                if(o.getRequired()==false) {
                    if (o.getUserr().getId().equals(1)) {
                        ordersOfUser.add(new OrderDTO(o));
                    }
                }
            }

            return ordersOfUser;


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
        //order1.setAdCar(adCarRepository.findOneById(order.getAdCar()));
        order1.setRequired(true);
        order1.setUserr(userRepository.findOneById(2));
        //order1.setUserIzdavao(userRepository.findOneById(order.getAdCar().getUserIzdavaoAd().getId()));
        //order1.setAgentIzdao(agentRepository.findOneById(order.getAdCar().getAgentIzdaoAd().getId()));


        orderRepositiory.save(order1);

        List<Request> requests= requestRepository.findAll();
        List<Order> bundleOrders= new ArrayList<>();

        Request newRequest= new Request();
        newRequest.setBundle(false);
        newRequest.setStatus("PAID");
        bundleOrders.add(order1);
        newRequest.setOrderList(bundleOrders);
        requestRepository.save(newRequest);

        for (Request req:requests){
            for(int i=0; i<req.getOrderList().size(); i++) {
                /*if (req.getOrderList().get(i).getAdCar().getId().equals(order.getAdCar().getId())){
                    Request request1= requestRepository.getOne(req.getId());
                    request1.setStatus("CACELED");
                    requestRepository.save(request1);
                }*/
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
                    /*if (!req.getId().equals(request.getId()) && req.getOrderList().get(i).getAdCar().getId().equals(request.getOrderList().get(j).getAdCar().getId())) {
                        Request request1= requestRepository.getOne(req.getId());
                        request1.setStatus("CANCELED");
                        requestRepository.save(request1);
                    }*/

                }
            }
        }

        RequestDTO requestDTO= new RequestDTO(request);

        return requestDTO;
    }


}
