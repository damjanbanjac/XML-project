package com.microservices.ordering.service.implementation;


import com.microservices.ordering.dto.OrderDTO;
import com.microservices.ordering.dto.RequestDTO;
import com.microservices.ordering.model.Order;
import com.microservices.ordering.model.Request;
import com.microservices.ordering.repository.OrderRepository;
import com.microservices.ordering.repository.RequestRepository;
import com.microservices.ordering.service.IRequestService;
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
    public RequestDTO createRquestForUser(RequestDTO request, OrderDTO order) {


        Long agentIzdaoId = order.getAgentIzdao().getId();
        Long userIzdaoId = order.getUserIzdao().getId();
        int brojIstihAgenata = 1;
        List<Order> orders= orderRepositiory.findAll();
        List<Order> bundleOrders= new ArrayList<>();

        if(request.getBundle()==true){
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
            newRequest.setBundle(request.getBundle());
            newRequest.setStatus("SACEKAJTE");
            newRequest.setOrderList(bundleOrders);

            requestRepository.save(newRequest);
            RequestDTO requestDTO = new RequestDTO(newRequest);

            return requestDTO;

        } else{
            Request newRequest= new Request();
            newRequest.setBundle(request.getBundle());
            newRequest.setStatus("SACEKAJTE");
            bundleOrders.add(orderRepositiory.findOneById(order.getId()));
            RequestDTO requestDTO = new RequestDTO(newRequest);

            return requestDTO;

        }
    }
}
