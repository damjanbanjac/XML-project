package com.agent.agentapp.service.implementation;

import com.agent.agentapp.dto.request.CommentAdCarRequest;
import com.agent.agentapp.dto.response.CommentResponse;
import com.agent.agentapp.entity.*;
import com.agent.agentapp.repository.*;
import com.agent.agentapp.service.ICommentService;
import com.agent.agentapp.utils.CommentRequestState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService implements ICommentService {

    private final AdCarRepository _adCarRepository;

    private final AgentRepository _agentRepository;

    private final IUserRepository _userRepository;

    private final IOrderRepository _orderRepository;

    private final ICommentRepository _commentRepository;

    private final RequestRepository _requestRepository;

    public CommentService(AdCarRepository adCarRepository, AgentRepository agentRepository, IUserRepository userRepository, IOrderRepository orderRepository, ICommentRepository commentRepository, RequestRepository requestRepository) {
        _adCarRepository = adCarRepository;
        _agentRepository = agentRepository;
        _userRepository = userRepository;
        _orderRepository = orderRepository;
        _commentRepository = commentRepository;
        _requestRepository = requestRepository;
    }

    @Override
    public void commentAdCar(CommentAdCarRequest request) throws Exception {
        User user = _userRepository.findOneById(request.getUserId());
        Agent agent = _agentRepository.findOneById(request.getUserId());
        AdCar adCar = _adCarRepository.findOneById(request.getAdCarId());

        if(user != null){
            List<Order> allOrders = _orderRepository.findAll();

            if(allOrders.isEmpty()) {
                throw new Exception("You cannot comment this ad.");
            }
            Order order = null;
            List<Request> allRequests = _requestRepository.findAll();
            for(Request r: allRequests){
                if(r.getStatus().equals("PAID")){
                    for(Order o: r.getOrderList()){
                        if(o.getAdCar_id() == adCar && o.getUser() == user){
                            order = o;
                            break;
                        }
                    }
                }
            }
//            for (Order o: allOrders) {
//                if(o.getAdCar_id() == adCar && o.getRequest().getStatus().equals("PAID") && o.getUser() == user) {
//                    order = o;
//                    break;
//                }
//            }

            if(order == null){
                throw new Exception("You cannot comment this ad.");
            }
            Comment comment = new Comment();
            comment.setAdCar(adCar);
            comment.setUserId(user.getId());
            comment.setComment(request.getComment());
            _commentRepository.save(comment);
            adCar.getComments().add(comment);
            _adCarRepository.save(adCar);
        }else if(agent != null){
//            if(adCar.getAgentAd() != agent){
//                throw new Exception("You cannot comment this ad.");
//            }
            Comment comment = new Comment();
            comment.setAdCar(adCar);
            comment.setUserId(agent.getId());
            comment.setComment(request.getComment());
            _commentRepository.save(comment);
            adCar.getComments().add(comment);
            _adCarRepository.save(adCar);
        }

    }

    @Override
    public List<CommentResponse> getAllCommentsByAdCarId(Long id) {
        List<Comment> allComments = _commentRepository.findAllByAdCar_Id(id);
        List<Comment> comments = new ArrayList<>();
        for(Comment c: allComments){
            if(c.getState().equals(CommentRequestState.APPROVED)){
                comments.add(c);
            }
        }
        List<CommentResponse> responses = new ArrayList<>();
        for(Comment c: comments){
            CommentResponse response = new CommentResponse();
            response.setCommId(c.getId());
            response.setComment(c.getComment());
            responses.add(response);
        }
        return responses;
    }
}
