package com.microservices.ordering.service.implementation;

import com.microservices.ordering.dto.OrderDTO;
import com.microservices.ordering.model.Order;
import com.microservices.ordering.repository.OrderRepository;
import com.microservices.ordering.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepositiory;


    @Override
    public OrderDTO getOrder(long id) {
        return null;
    }

    @Override
    public Set<OrderDTO> getAllOrders() {
        return null;
    }

    @Override
    public OrderDTO createOrder(OrderDTO request) {
        Order order = new Order();

        order.setAvailableFrom(request.getAvailableFrom());
        order.setAvailableTo(request.getAvailableTo());
        order.setAdCar(request.getAdCar());
        order.setUserr(request.getUser());
        order.setUserIzdavao(request.getUserIzdao());
        order.setAgentIzdao(request.getAgentIzdao());

        orderRepositiory.save(order);

        OrderDTO orderDTO = new OrderDTO(order);

        return orderDTO;


    }

    @Override
    public List<OrderDTO> getAllOrdersForUser(Long id) {

        List<OrderDTO> ordersOfUser= new ArrayList<>();
        List<Order> orders= orderRepositiory.findAll();

        for(Order order: orders){
            if(order.getUserr().getId().equals(id)){
                ordersOfUser.add(new OrderDTO(order));
            }
        }

        return ordersOfUser;
    }
}
