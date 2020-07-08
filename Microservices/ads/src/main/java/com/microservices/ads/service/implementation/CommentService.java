package com.microservices.ads.service.implementation;

import com.microservices.ads.client.AuthClient;
import com.microservices.ads.client.OrderClient;
import com.microservices.ads.dto.feignDTOs.UserDTO;
import com.microservices.ads.dto.request.CommentAdCarRequest;
import com.microservices.ads.dto.response.CommentResponse;
import com.microservices.ads.dto.response.OrderDTO;
import com.microservices.ads.model.AdCar;
import com.microservices.ads.model.Comment;
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

    private final AuthClient _authClient;

    private final OrderClient _orderClient;

    public CommentService(AdCarRepository adCarRepository, IUserRepository userRepository, IOrderRepository orderRepository, ICommentRepository commentRepository, AuthClient authClient, OrderClient orderClient) {
        _adCarRepository = adCarRepository;
        _userRepository = userRepository;
        _orderRepository = orderRepository;
        _commentRepository = commentRepository;
        _authClient = authClient;
        _orderClient = orderClient;
    }


    @Override
    public void commentAdCar(CommentAdCarRequest request) throws Exception {
        AdCar adCar = _adCarRepository.findOneById(request.getAdCarId());
//
//        List<AdCar> adCars = _adCarRepository.findAllByAgentAd(request.getUserId());
//        if(!adCars.contains(adCar)){
//            throw new Exception("You cannot comment this ad.");
//        }

        Comment comment = new Comment();
        comment.setAdCar(adCar);
        comment.setUserId(request.getUserId());
        comment.setComment(request.getComment());
        _commentRepository.save(comment);
        adCar.getComments().add(comment);
        _adCarRepository.save(adCar);
    }

    @Override
    public void commentAdCarByCustomer(CommentAdCarRequest request) throws Exception {
        AdCar adCar = _adCarRepository.findOneById(request.getAdCarId());

        List<OrderDTO> orderDTOS = _orderClient.getAllOrdersByCustomer(request.getUserId());

        boolean flag = true;
        for(OrderDTO o: orderDTOS){
            if(o.getAdCar() == adCar.getId()){
                flag = false;
                break;
            }
        }

        if(flag){
            throw new Exception("You cannot comment this ad.");
        }

        Comment comment = new Comment();
        comment.setAdCar(adCar);
        comment.setUserId(request.getUserId());
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
            UserDTO userDTO = _authClient.getUserDetails(c.getUserId());
            System.out.println(userDTO.getEmail());
            CommentResponse response = new CommentResponse();
            response.setCommId(c.getId());
            response.setComment(c.getComment());
            response.setEmail(userDTO.getEmail());
            response.setName(userDTO.getName());
            response.setSurname(userDTO.getSurname());
            responses.add(response);
        }
        return responses;
    }
}
