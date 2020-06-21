package com.agent.agentapp.service.implementation;

import com.agent.agentapp.dto.request.ReportRequest;
import com.agent.agentapp.dto.response.ReportResponse;
import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.entity.Order;
import com.agent.agentapp.entity.Report;
import com.agent.agentapp.repository.AdCarRepository;
import com.agent.agentapp.repository.IOrderRepository;
import com.agent.agentapp.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    AdCarRepository adCarRepository;

    public ReportResponse createReport(ReportRequest reportRequest) {

        Report report =new Report();
      //  report.setAdCar(reportRequest.getOrder().getAdCar_id());
        report.setOrder(reportRequest.getOrder());
        Order order = orderRepository.findOneById(reportRequest.getOrder().getId());
      //  System.out.println(reportRequest.getOrder().getAdCar_id().getId());
        AdCar adCar = adCarRepository.findOneById(order.getAdCar_id().getId());
        adCar.setKmTraveled(adCar.getKmTraveled() + reportRequest.getKm());
        adCarRepository.save(adCar);
        report.setKm(reportRequest.getKm());
        report.setText(reportRequest.getText());
        reportRepository.save(report);
        //Order o =orderRepository.findOneById(reportRequest.getOrder().getId());
        order.setDeleted(true);
        orderRepository.save(order);
        ReportResponse reportResponse = new ReportResponse(report);
        return  reportResponse;

    }
}
