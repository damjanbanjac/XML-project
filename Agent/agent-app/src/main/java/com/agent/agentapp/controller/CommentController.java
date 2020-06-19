package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.CommentAdCarRequest;
import com.agent.agentapp.dto.response.CommentResponse;
import com.agent.agentapp.service.ICommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
