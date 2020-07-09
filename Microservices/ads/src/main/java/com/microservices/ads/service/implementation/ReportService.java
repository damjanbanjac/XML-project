package com.microservices.ads.service.implementation;


import com.microservices.ads.client.OrderClient;
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

    @Autowired
    OrderClient orderClient;

    public ReportResponse createReport(ReportRequest reportRequest) {

        Report report =new Report();
        //  report.setAdCar(reportRequest.getOrder().getAdCar_id());
        report.setOrders(reportRequest.getOrder().getId());
        //Order order = orderRepository.findOneById(reportRequest.getOrder().getId());
        //  System.out.println(reportRequest.getOrder().getAdCar_id().getId());

        System.out.println("adCar id " + reportRequest.getOrder().getAdCar());
        AdCar adCar = adCarRepository.findOneById(reportRequest.getOrder().getAdCar());
        System.out.println("id" + adCar.getId());
        System.out.println("adCar km " + adCar.getKmTraveled());
        System.out.println("report km" + reportRequest.getKm());
        adCar.setKmTraveled(adCar.getKmTraveled() + reportRequest.getKm());
        adCarRepository.save(adCar);
        report.setKm(reportRequest.getKm());
        report.setText(reportRequest.getText());

        reportRepository.save(report);

        orderClient.deleteOrder(reportRequest.getOrder().getId());
        //Order o =orderRepository.findOneById(reportRequest.getOrder().getId());
       // order.setDeleted(true);

        ReportResponse reportResponse = new ReportResponse(report);
        return  reportResponse;

    }
}
