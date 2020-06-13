package com.microservices.ordering.service.implementation;


import com.microservices.ordering.dto.OrderDTO;
import com.microservices.ordering.dto.RequestDTO;
import com.microservices.ordering.model.Order;
import com.microservices.ordering.model.Request;
import com.microservices.ordering.repository.*;
import com.microservices.ordering.service.IRequestService;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public RequestDTO createRquestForUser(Boolean bundle, OrderDTO order) {


        Long agentIzdaoId = order.getAgentIzdao().getId();
        Long userIzdaoId = order.getUserIzdao().getId();
        int brojIstihAgenata = 1;
        List<Order> orders= orderRepositiory.findAll();
        List<Order> bundleOrders= new ArrayList<>();

        if(bundle==true){
            for(Order ord:orders){
                if(ord.getUserr().getId().equals(order.getUser().getId())){
                    if(order.getAgentIzdao().getId()!=null) {
                        if (ord.getAgentIzdao().getId().equals(agentIzdaoId)) {
                            bundleOrders.add(ord);
                        }
                    }
                    else{
                        if(ord.getUserIzdavao().getId().equals(userIzdaoId)){
                            bundleOrders.add(ord);
                        }
                    }

                }
            }
            Request newRequest= new Request();
            newRequest.setBundle(bundle);
            newRequest.setStatus("PENDING");
            newRequest.setOrderList(bundleOrders);

            requestRepository.save(newRequest);
            RequestDTO requestDTO = new RequestDTO(newRequest);

            return requestDTO;

        } else{
            Request newRequest= new Request();
            newRequest.setBundle(bundle);
            newRequest.setStatus("PENDING");
            Order orderFalse = orderRepositiory.findOneById(order.getId());
            bundleOrders.add(orderFalse);
            newRequest.setOrderList(bundleOrders);
            requestRepository.save(newRequest);
            RequestDTO requestDTO = new RequestDTO(newRequest);

            return requestDTO;

        }
    }



    @Override
    public RequestDTO presonallyRequest(OrderDTO order) {

        Order order1 = new Order();

        order1.setAvailableFrom(order.getAvailableFrom());
        order1.setAvailableTo(order.getAvailableTo());
        order1.setAdCar(adCarRepository.findOneById(order.getAdCar().getId()));
        order1.setUserr(userRepository.findOneById(order.getUser().getId()));
        order1.setUserIzdavao(userRepository.findOneById(order.getUserIzdao().getId()));
        order1.setAgentIzdao(agentRepository.findOneById(order.getAgentIzdao().getId()));

        orderRepositiory.save(order1);

        List<Request> requests= requestRepository.findAll();
        List<Order> bundleOrders= new ArrayList<>();

        Request newRequest= new Request();
        newRequest.setBundle(false);
        newRequest.setStatus("RESERVED");
        bundleOrders.add(order1);
        newRequest.setOrderList(bundleOrders);

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

        for(Request req:requests){
            for(int i=0; i<req.getOrderList().size(); i++){
                if(req.getOrderList().get(i).getAgentIzdao().getId().equals(agentId)){
                    requestsDTO.add(new RequestDTO(req));
                }
            }
        }
        return requestsDTO;
    }

    @Override
    public RequestDTO acceptRequest(Long idRequest) {

        Request request = requestRepository.findOneById(idRequest);
        request.setStatus("RESERVED");
        requestRepository.save(request);

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
