package com.agent.agentapp.service.implementation;

import com.agent.agentapp.dto.request.CommentAdCarRequest;
import com.agent.agentapp.dto.response.CommentResponse;
import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.entity.Comment;
import com.agent.agentapp.entity.Order;
import com.agent.agentapp.entity.User;
import com.agent.agentapp.repository.AdCarRepository;
import com.agent.agentapp.repository.ICommentRepository;
import com.agent.agentapp.repository.IOrderRepository;
import com.agent.agentapp.repository.IUserRepository;
import com.agent.agentapp.service.ICommentService;
import com.agent.agentapp.utils.CommentRequestState;

import java.util.ArrayList;
import java.util.List;

public class CommentService implements ICommentService {

    private final AdCarRepository _adCarRepository;

    private final IUserRepository _userRepository;

    private final IOrderRepository _orderRepository;

    private final ICommentRepository _commentRepository;

    public CommentService(AdCarRepository adCarRepository, IUserRepository userRepository, IOrderRepository orderRepository, ICommentRepository commentRepository) {
        _adCarRepository = adCarRepository;
        _userRepository = userRepository;
        _orderRepository = orderRepository;
        _commentRepository = commentRepository;
    }


    @Override
    public void commentAdCar(CommentAdCarRequest request) throws Exception {
        User user = _userRepository.findOneById(request.getUserId());
        AdCar adCar = _adCarRepository.findOneById(request.getAdCarId());

        List<Order> allOrders = _orderRepository.findAllByUser_IdAndUsingTimeUp(user.getId(), true);

        if(allOrders.isEmpty()) {
            throw new Exception("You cannot comment this ad.");
        }
        Order order = null;
        for (Order o: allOrders) {
            if(o.getAdCar()==adCar) {
                order = o;
                break;
            }
        }
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
            response.setComment(c.getComment());
            responses.add(response);
        }
        return responses;
    }
}
