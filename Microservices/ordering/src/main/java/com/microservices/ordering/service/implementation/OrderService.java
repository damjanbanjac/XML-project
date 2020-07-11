package com.microservices.ordering.service.implementation;

import com.microservices.ordering.client.AdClient;
import com.microservices.ordering.client.AuthClient;
import com.microservices.ordering.dto.AdCarDTO;
import com.microservices.ordering.dto.AdCarResponse;
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

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private AdClient adClient;

    @Override
    public OrderDTO getOrder(long id) {
        return null;
    }

    @Override
    public Set<OrderDTO> getAllOrders() {
        return null;
    }

    @Override
    public OrderDTO createOrder(OrderDTO request, Long id) {
        Order order = new Order();
        System.out.println("Id auta koji mi treba je " + request.getAdCar());
        System.out.println(request.getAdCar());
        order.setAvailableFrom(request.getAvailableFrom());
        order.setAvailableTo(request.getAvailableTo());
        order.setRequired(false);
        AdCarResponse adResp = adClient.getAd(request.getAdCar());
        order.setAdCar(adResp.getId());
        order.setUserr(id);
        order.setUserIzdavao(adResp.getUserAd());
        System.out.println("Agentov id je " + adResp.getAgentAd());
        System.out.println("User izdao id je " + adResp.getUserAd());
        System.out.println("Pravi user id " + id);
        System.out.println("Datumi validnosti od" + adResp.getAvailableFrom());
        System.out.println("Datumi validnosti do" + adResp.getAvailableTo());
        order.setAgentIzdao(adResp.getAgentAd());

        orderRepositiory.save(order);

        OrderDTO orderDTO = new OrderDTO(order);

        return orderDTO;


    }

    @Autowired
    AuthClient authClient;

    @Override
    public List<OrderDTO> getAllOrdersForUser(Long id) {
//        String string = authClient.getLoggedUser();
        List<OrderDTO> ordersOfUser= new ArrayList<>();
        List<Order> orders= orderRepositiory.findAll();

        for(Order order: orders){
            if(order.getRequired()==false) {
                if (order.getUserr().equals(id)) {
                    ordersOfUser.add(new OrderDTO(order));
                }
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
        adCar.setUserIzdavaoAd((userRepository.findOneById(user1.getId())));
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

    @Override
    public List<OrderDTO> getAllOrdersByCustomer(Long id) throws ParseException {
        List<Order> allOrders = orderRepositiory.findAll();
        List<OrderDTO> orderDTOS = new ArrayList<>();

        for(Order o: allOrders){
            if(id == o.getUserr()){
                Date date =new SimpleDateFormat("yyyy-MM-dd").parse(o.getAvailableTo());
                Date now = new Date();
                if(now.after(date)){
                    OrderDTO orderDTO = new OrderDTO();
                    orderDTO.setAdCar(o.getAdCar());
                    orderDTOS.add(orderDTO);
                }
            }
        }
        return orderDTOS;
    }

    public List<OrderDTO> getAllOrderForReport(long id) throws ParseException {

        List<Order> orders = orderRepositiory.findAll();
        List<OrderDTO> orderResponses = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(date + " valjda trenutno");

        for(Order order : orders) {
            Date date1 =new SimpleDateFormat("yyyy-MM-dd").parse(order.getAvailableTo());
            if(  date1.before(date)  && order.isDeleted() == false && order.getAgentIzdao() == id ) {
                System.out.println("usao u order");
               // System.out.println(order.getAdCar_id());
                OrderDTO orderResponse = new OrderDTO(order);

                orderResponses.add(orderResponse);
            }
        }

        return  orderResponses;
    }

    @Override
    public List<OrderDTO> getAllOrderForReportUser(Long id) throws ParseException {
        List<Order> orders = orderRepositiory.findAll();
        List<OrderDTO> orderResponses = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(date + " valjda trenutno");

        for(Order order : orders) {
            Date date1 =new SimpleDateFormat("yyyy-MM-dd").parse(order.getAvailableTo());
            if(  date1.before(date)  && order.isDeleted() == false && order.getUserIzdavao() == id ) {
                System.out.println("usao u order");
                // System.out.println(order.getAdCar_id());
                OrderDTO orderResponse = new OrderDTO(order);

                orderResponses.add(orderResponse);
            }
        }

        return  orderResponses;
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepositiory.findOneById(id);
        order.setDeleted(true);
        orderRepositiory.save(order);
    }

}
