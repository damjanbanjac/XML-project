package com.microservices.ads.service.implementation;


import com.microservices.ads.dto.request.ReportRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.dto.response.ReportResponse;
import com.microservices.ads.model.AdCar;
import com.microservices.ads.model.Report;
import com.microservices.ads.repository.AdCarRepository;
import com.microservices.ads.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    AdCarRepository adCarRepository;

    public ReportResponse createReport(ReportRequest reportRequest) {

        Report report =new Report();
        report.setAdCar(reportRequest.getAdCar());
        AdCar adCar = adCarRepository.findOneById(reportRequest.getAdCar().getId());
        adCar.setKmTraveled(adCar.getKmTraveled() + reportRequest.getKm());
        adCarRepository.save(adCar);
        report.setKm(reportRequest.getKm());
        report.setText(reportRequest.getText());
        reportRepository.save(report);
        ReportResponse reportResponse = new ReportResponse(report);
        return  reportResponse;

    }
}
