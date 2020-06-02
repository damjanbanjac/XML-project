package com.microservices.ads.service;

import com.microservices.ads.dto.request.CommentRequest;
import com.microservices.ads.dto.response.CommentResponse;


import java.util.Set;

public interface ICommentService {

    CommentResponse getComment(long id);

    Set<CommentResponse> getAllComments();

    CommentResponse createComement(CommentRequest request);

    CommentResponse updateComment(CommentRequest request, long id);

    void deleteComment(long id);

    boolean acceptComment(long id);

}
