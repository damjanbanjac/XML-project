package com.microservices.ordering.service;

import com.microservices.ordering.dto.OrderDTO;
import com.microservices.ordering.dto.RequestDTO;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

public interface IRequestService {

    RequestDTO getRequest(long id);

    Set<RequestDTO> getAllRequests();

    //RequestDTO createRequest(RequestDTO request);

    void cancelRequest(long id);

    void cancelRequestFromAgent(long id, long idAgent);

    void acceptRequestFromAgent(long id, long idAgent);

    List<OrderDTO> createRquestForUser(Boolean bundle,Long id, OrderDTO order);

    RequestDTO presonallyRequest(OrderDTO order) throws ParseException;

    List<RequestDTO> agentRequests(Long agentId);

    List<RequestDTO> userRequestsAgent(Long userId);

    RequestDTO acceptRequest(Long idRequest);

    List<RequestDTO> userRequests(Long idUser);

    List<RequestDTO> userRequestsHistory(Long idUser);

    RequestDTO paidRequest(Long idRequest) throws ParseException;

    RequestDTO cancleRequest(Long idRequest);

    RequestDTO declineRequest(Long idRequest);
}
