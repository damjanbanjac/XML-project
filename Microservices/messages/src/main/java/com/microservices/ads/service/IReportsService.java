package com.microservices.ads.service;

import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.request.ReportRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.dto.response.ReportResponse;

import java.util.Set;

public interface IReportsService {

    ReportResponse getReport(long id);

    Set<ReportResponse> getAllReports();

    ReportResponse createReport(ReportRequest request);

    ReportRequest updateReport(ReportRequest request, long id);

    void deleteReport(long id);

}
