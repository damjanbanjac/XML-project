package com.microservices.ordering.service;

import com.microservices.ordering.dto.OrderDTO;
import com.microservices.ordering.dto.RequestDTO;

import java.util.Set;

public interface IRequestService {

    RequestDTO getRequest(long id);

    Set<RequestDTO> getAllRequests();

    //RequestDTO createRequest(RequestDTO request);

    void cancelRequest(long id);

    void cancelRequestFromAgent(long id, long idAgent);

    void acceptRequestFromAgent(long id, long idAgent);

    RequestDTO createRquestForUser(Boolean bundle, OrderDTO order);

    RequestDTO presonallyRequest(OrderDTO order);
}
