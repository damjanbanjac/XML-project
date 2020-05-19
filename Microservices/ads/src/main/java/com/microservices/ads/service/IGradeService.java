package com.microservices.ads.service;


import com.microservices.ads.dto.request.GradeRequest;
import com.microservices.ads.dto.response.GradeResponse;

import java.util.Set;

public interface IGradeService {

    GradeResponse getGrade(long id);

    Set<GradeResponse> getAllGrades();

    GradeResponse createGrade(GradeRequest request);

    GradeResponse updateGrade(GradeRequest request, long id);

    void deleteGrade(long id);
}
