package com.microservices.ads.controller;

import com.microservices.ads.dto.request.CommentAdCarRequest;
import com.microservices.ads.dto.response.CommentResponse;
import com.microservices.ads.service.ICommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/comments")
public class CommentController {

    private final ICommentService commentService;

    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public void comment(@RequestBody CommentAdCarRequest request) throws Exception {
        commentService.commentAdCar(request);
    }

    @GetMapping("/{id}/ad-car")
    List<CommentResponse> getAllComments(@PathVariable Long id) {
        return commentService.getAllCommentsByAdCarId(id);
    }
}
