package com.agent.agentapp.dto.request;

import lombok.Data;

@Data
public class CommentAdCarRequest {

    private String comment;

    private Long userId;

    private Long adCarId;
}
