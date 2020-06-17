package com.agent.agentapp.service;

import com.agent.agentapp.dto.request.CommentAdCarRequest;
import com.agent.agentapp.dto.response.CommentResponse;
import com.agent.agentapp.entity.Comment;

import java.util.List;

public interface ICommentService {

    void commentAdCar(CommentAdCarRequest request) throws Exception;

    List<CommentResponse> getAllCommentsByAdCarId(Long id);
}
