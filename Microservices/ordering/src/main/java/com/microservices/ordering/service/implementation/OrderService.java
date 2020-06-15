package com.microservices.ordering.service.implementation;

import com.microservices.ordering.dto.AdCarDTO;
import com.microservices.ordering.dto.OrderDTO;
import com.microservices.ordering.model.AdCar;
import com.microservices.ordering.model.Agent;
import com.microservices.ordering.model.Order;
import com.microservices.ordering.model.Users;
import com.microservices.ordering.repository.AdCarRepository;
import com.microservices.ordering.repository.AgentRepository;
import com.microservices.ordering.repository.OrderRepository;
import com.microservices.ordering.repository.UserRepository;
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

    @Autowired
    private AdCarRepository adCarRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AgentRepository agentRepository;

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
        order.setAdCar(adCarRepository.findOneById(request.getAdCar().getId()));
        order.setUserr(userRepository.findOneById(request.getUser().getId()));
        order.setUserIzdavao(userRepository.findOneById(request.getUserIzdao().getId()));
        order.setAgentIzdao(agentRepository.findOneById(request.getAgentIzdao().getId()));

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

    @Override
    public OrderDTO createPotrebno() {

        Users user = new Users();
        userRepository.save(user);
        Users user1 = new Users();
        userRepository.save(user1);
        Agent agent = new Agent();
        agentRepository.save(agent);
        AdCar adCar = new AdCar();
        adCar.setAgentIzdaoAd(agentRepository.findOneById(agent.getId()));
        adCar.setUserIzdavaoAd((null));
        adCarRepository.save(adCar);

        return null;
    }

    @Override
    public List<AdCarDTO> getAllOglasi() {

        List<AdCarDTO> oglasiDTO= new ArrayList<>();
        List<AdCar> oglasi=adCarRepository.findAll();

        for(AdCar oglas: oglasi){
            oglasiDTO.add(new AdCarDTO(oglas));

        }
        
        return oglasiDTO;
    }
}
