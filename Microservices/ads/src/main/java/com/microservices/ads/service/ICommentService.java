package com.microservices.ads.service;

import com.microservices.ads.dto.request.CommentAdCarRequest;
import com.microservices.ads.dto.response.CommentResponse;

import java.util.List;

public interface ICommentService {

    void commentAdCar(CommentAdCarRequest request) throws Exception;

    void commentAdCarByCustomer(CommentAdCarRequest request) throws Exception;

    List<CommentResponse> getAllCommentsByAdCarId(Long id);
}
