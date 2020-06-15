package com.agent.agentapp.service;

import com.agent.agentapp.dto.request.GradeAdCarRequest;
import com.agent.agentapp.dto.response.AvgGradeResponse;
import com.agent.agentapp.dto.response.GradeResponse;

import java.util.List;

public interface IGradeService {

    void gradeOrder(GradeAdCarRequest request) throws Exception;

    List<GradeResponse> getAllGradesByAdCar(long id);

    AvgGradeResponse getAvgGradeResponse(long id);
}
