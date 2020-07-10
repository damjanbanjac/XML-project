package com.agent.agentapp.service.implementation;

import com.agent.agentapp.dto.request.OrderDTO;
import com.agent.agentapp.dto.request.ReportRequest;
import com.agent.agentapp.dto.response.AdCarResponse;
import com.agent.agentapp.dto.response.OrderResponse;
import com.agent.agentapp.dto.response.ReportResponse;
import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.entity.Order;
import com.agent.agentapp.entity.Report;
import com.agent.agentapp.repository.*;
import com.agent.agentapp.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class OrderService implements IOrderService {

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    AdCarRepository adCarRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    AgentRepository agentRepository;

    public List<OrderResponse> getAllOrderForReport() {

        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        for(Order order : orders) {
            System.out.println(order.getAdCar_id().getKmTraveled());
            if(order.isUsingTimeUp() == true && order.isDeleted() == false) {
                System.out.println("usao u order");
                System.out.println(order.getAdCar_id());
                OrderResponse orderResponse = new OrderResponse(order);

                orderResponses.add(orderResponse);
            }
        }

        return  orderResponses;
    }

    @Override
    public OrderDTO createOrder(OrderDTO request, Long id) throws ParseException {
        Order order = new Order();

        System.out.println(request.getAdCar().getId());
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse(request.getAvailableFrom());
        Date date1 = format.parse(request.getAvailableTo());
        order.setAvailableFrom(date);
        order.setAvailableTo(date1);
        order.setRequired(false);
        //order.setRequired(false);
        order.setAdCar_id(adCarRepository.findOneById(request.getAdCar().getId()));
        Long a= new Long(200);
        order.setUser(userRepository.findOneById(id));
        //order.setRequest(null);
        //order.setUserIzdavao(userRepository.findOneById(request.getAdCar().getUserAd().getId()));
        order.setAgentIzdao(agentRepository.findOneById(a));

        orderRepository.save(order);

        OrderDTO orderDTO = new OrderDTO(order);

        return orderDTO;
    }

    @Override
    public List<OrderDTO> getAllOrdersForUser(Long id) {
        List<OrderDTO> ordersOfUser= new ArrayList<>();
        List<Order> orders= orderRepository.findAll();

        for(Order order: orders){
            //if(!order.getRequired()) {
                if (order.getUser().getId().equals(id)) {
                    ordersOfUser.add(new OrderDTO(order));
                }
            //}
        }

        return ordersOfUser;
    }
}