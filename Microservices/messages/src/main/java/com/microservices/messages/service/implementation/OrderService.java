package com.microservices.messages.service.implementation;

import com.microservices.messages.dto.AdCarDTO;
import com.microservices.messages.dto.OrderDTO;
import com.microservices.messages.model.AdCar;
import com.microservices.messages.model.Agent;
import com.microservices.messages.model.Order;
import com.microservices.messages.model.User;
import com.microservices.messages.repository.AdCarRepository;
import com.microservices.messages.repository.IAgentRepository;
import com.microservices.messages.repository.OrderRepository;
import com.microservices.messages.repository.IUserRepository;
import com.microservices.messages.service.IOrderService;
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
    private IUserRepository userRepository;

    @Autowired
    private IAgentRepository agentRepository;

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

        System.out.println(request.getAdCar().getId());
        order.setAvailableFrom(request.getAvailableFrom());
        order.setAvailableTo(request.getAvailableTo());
        order.setAdCar(adCarRepository.findOneById(request.getAdCar().getId()));
        order.setUserr(userRepository.findById(1));
        order.setUserIzdavao(userRepository.findById((long)request.getAdCar().getUserIzdavaoAd().getId()));
        order.setAgentIzdao(agentRepository.findById((long)request.getAdCar().getAgentIzdaoAd().getId()));

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

        User user = new User();
        userRepository.save(user);
        User user1 = new User();
        userRepository.save(user1);
        Agent agent = new Agent();
        agentRepository.save(agent);
        AdCar adCar = new AdCar();
        adCar.setAgentIzdaoAd(agentRepository.findById((long)agent.getId()));
        adCar.setUserIzdavaoAd((userRepository.findById((long)user1.getId())));
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

    @Override
    public List<AdCarDTO> getAgentsAds(Long agentId) {

        List<AdCar> ads= adCarRepository.findAll();
        List<AdCarDTO> adsDTO= new ArrayList<>();

        for(AdCar ad:ads){
            if(ad.getAgentIzdaoAd().getId().equals(agentId)){
                adsDTO.add(new AdCarDTO(ad));
            }
        }
        return adsDTO;
    }

    @Override
    public List<AdCarDTO> getAd(AdCarDTO adCar) {

        AdCar adCar1=adCarRepository.findOneById(adCar.getId());
        AdCarDTO adCarDTO=new AdCarDTO(adCar1);
        List<AdCarDTO> adsDTOlist= new ArrayList<>();
        adsDTOlist.add(adCarDTO);
        return adsDTOlist;
    }
}