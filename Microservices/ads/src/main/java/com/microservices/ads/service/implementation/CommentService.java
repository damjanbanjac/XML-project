package com.microservices.ads.service.implementation;

import com.microservices.ads.dto.request.CommentAdCarRequest;
import com.microservices.ads.dto.response.CommentResponse;
import com.microservices.ads.model.AdCar;
import com.microservices.ads.model.Comment;
import com.microservices.ads.model.Order;
import com.microservices.ads.model.User;
import com.microservices.ads.repository.AdCarRepository;
import com.microservices.ads.repository.ICommentRepository;
import com.microservices.ads.repository.IOrderRepository;
import com.microservices.ads.repository.IUserRepository;
import com.microservices.ads.service.ICommentService;
import com.microservices.ads.utils.CommentRequestState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
            if(o.getAdCar_id()==adCar) {
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
            response.setCommId(c.getId());
            response.setComment(c.getComment());
            responses.add(response);
        }
        return responses;
    }
}
