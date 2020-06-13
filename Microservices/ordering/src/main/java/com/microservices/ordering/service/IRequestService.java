package com.microservices.ordering.service;

import com.microservices.ordering.dto.OrderDTO;
import com.microservices.ordering.dto.RequestDTO;

import java.util.List;
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

    List<RequestDTO> agentRequests(Long agentId);

    RequestDTO acceptRequest(Long idRequest);

    List<RequestDTO> userRequests(Long idUser);

    RequestDTO paidRequest(Long idRequest);

    RequestDTO declineRequest(Long idRequest);
}
