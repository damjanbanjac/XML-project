package com.microservices.ads.service;

import com.microservices.ads.dto.request.GradeAdCarRequest;
import com.microservices.ads.dto.response.AvgGradeResponse;
import com.microservices.ads.dto.response.GradeResponse;

import java.util.List;

public interface IGradeService {

    void gradeOrder(GradeAdCarRequest request) throws Exception;

    List<GradeResponse> getAllGradesByAdCar(long id);

    AvgGradeResponse getAvgGradeResponse(long id);
}
