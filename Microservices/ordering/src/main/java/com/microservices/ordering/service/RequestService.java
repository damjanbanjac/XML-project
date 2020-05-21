package com.microservices.ordering.service;

import com.microservices.ordering.dto.RequestDTO;

import java.util.Set;

public interface RequestService {

    RequestDTO getRequest(long id);

    Set<RequestDTO> getAllRequests();

    RequestDTO createRequest(RequestDTO request);

    void cancelRequest(long id);

    void cancelRequestFromAgent(long id, long idAgent);

    void acceptRequestFromAgent(long id, long idAgent);
}
