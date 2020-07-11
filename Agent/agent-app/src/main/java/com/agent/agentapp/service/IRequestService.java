package com.agent.agentapp.service;

import com.agent.agentapp.dto.request.OrderDTO;
import com.agent.agentapp.dto.request.RequestDTO;

import java.text.ParseException;
import java.util.List;

public interface IRequestService {

    List<OrderDTO> createRquestForUser(Boolean bundle, Long id, OrderDTO order);

    RequestDTO presonallyRequest(OrderDTO order) throws ParseException;

    List<RequestDTO> agentRequests(Long agentId);

    RequestDTO acceptRequest(Long idRequest);

    List<RequestDTO> userRequests(Long idUser);

    RequestDTO paidRequest(Long idRequest);

    RequestDTO declineRequest(Long idRequest);
}
