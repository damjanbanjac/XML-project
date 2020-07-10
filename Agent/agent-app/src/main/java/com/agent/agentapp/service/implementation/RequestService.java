package com.agent.agentapp.service.implementation;

import com.agent.agentapp.dto.request.OrderDTO;
import com.agent.agentapp.dto.request.RequestDTO;
import com.agent.agentapp.entity.Order;
import com.agent.agentapp.entity.Request;
import com.agent.agentapp.entity.User;
import com.agent.agentapp.repository.*;
import com.agent.agentapp.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RequestService implements IRequestService {

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    AdCarRepository adCarRepository;

    @Autowired
    AgentRepository agentRepository;

    @Override
    public List<OrderDTO> createRquestForUser(Boolean bundle, Long id, OrderDTO order) {
        Long agentIzdaoId = order.getAdCar().getAgentAd().getId();
        //Long userIzdaoId = order.getAdCar().getUserAd().getId();
        int brojIstihAgenata = 1;
        List<Order> orders= orderRepository.findAll();
        List<Order> bundleOrders= new ArrayList<>();
        System.out.println("AGENT ID JEEEEEE"+agentIzdaoId);
        System.out.println("Bunleeeee"+bundle);
        User userProvera = userRepository.findOneById(id);

        Calendar calendar= Calendar.getInstance();

        calendar.add(Calendar.HOUR_OF_DAY, +24);

        if(bundle==true){
            for(Order ord:orders){
                if(ord.getUser().getId().equals(userProvera.getId())){
                    System.out.println("User ID jeeeee"+ord.getUser().getId());
                    if(order.getAdCar().getAgentAd().getId()!=null) {
                        System.out.println("Opet agenttttt"+order.getAdCar().getAgentAd().getId());
                        if (ord.getAgentIzdao().getId().equals(agentIzdaoId)) {
                            System.out.println("Agent provera jednakosti"+ord.getAgentIzdao().getId());
                            Order orderTrue = orderRepository.findOneById(ord.getId());
                            orderTrue.setRequired(true);
                            orderRepository.save(orderTrue);
                            bundleOrders.add(orderTrue);
                        }
                    }/*
                    else{
                        if(ord.getUserIzdavao().getId().equals(userIzdaoId)){
                            Order orderTrue = orderRepository.findOneById(ord.getId());
                            bundleOrders.add(orderTrue);
                        }
                    }*/

                }
            }
            Request newRequest= new Request();
            newRequest.setBundle(bundle);
            newRequest.setStatus("PENDING");
            newRequest.setAcceptDate(calendar.getTime());
            newRequest.setOrderList(bundleOrders);

            requestRepository.save(newRequest);
            RequestDTO requestDTO = new RequestDTO(newRequest);

            List<OrderDTO> ordersOfUser= new ArrayList<>();
            List<Order> orderss= orderRepository.findAll();

            for(Order o: orderss){
                if(o.getRequired()==false) {
                    if (o.getUser().getId().equals(1)) {
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
            Order orderFalse = orderRepository.findOneById(order.getId());
            orderFalse.setRequired(true);
            orderRepository.save(orderFalse);
            bundleOrders.add(orderFalse);
            newRequest.setOrderList(bundleOrders);
            requestRepository.save(newRequest);
            RequestDTO requestDTO = new RequestDTO(newRequest);


            List<OrderDTO> ordersOfUser= new ArrayList<>();
            List<Order> orderss= orderRepository.findAll();

            for(Order o: orderss){
                if(o.getRequired()==false) {
                    if (o.getUser().getId().equals(1)) {
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
    public RequestDTO presonallyRequest(OrderDTO order) throws ParseException {
        Order order1 = new Order();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse(order.getAvailableFrom());
        Date date1 = format.parse(order.getAvailableTo());

        order1.setAvailableFrom(date);
        order1.setAvailableTo(date1);
        order1.setAdCar_id(adCarRepository.findOneById(order.getAdCar().getId()));
        order1.setRequired(true);
        //Long l= new Long(1);
        //order1.setUser(userRepository.findOneById(l));
        //order1.setUserIzdavao(userRepository.findOneById(order.getAdCar().getUserAd().getId()));
        order1.setAgentIzdao(agentRepository.findOneById(order.getAdCar().getAgentAd().getId()));


        orderRepository.save(order1);

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
                if (req.getOrderList().get(i).getAdCar_id().getId().equals(order.getAdCar().getId())){
                    Request request1= requestRepository.getOne(req.getId());
                    request1.setStatus("CANCELED");
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
    public List<RequestDTO> userRequests(Long idUser) {
        List<Request> requets =requestRepository.findAll();
        List<RequestDTO> requestsDTO= new ArrayList<>();

        for(Request req: requets) {
            for (int i = 0; i < req.getOrderList().size(); i++) {
                if (req.getOrderList().get(i).getUser().getId().equals(idUser)) {
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
                    if (!req.getId().equals(request.getId()) && req.getOrderList().get(i).getAdCar_id().getId().equals(request.getOrderList().get(j).getAdCar_id().getId())) {
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

    @Override
    public RequestDTO declineRequest(Long idRequest) {
        Request request = requestRepository.findOneById(idRequest);
        request.setStatus("CANCELED");
        requestRepository.save(request);

        RequestDTO requestDTO= new RequestDTO(request);

        return requestDTO;
    }
}
