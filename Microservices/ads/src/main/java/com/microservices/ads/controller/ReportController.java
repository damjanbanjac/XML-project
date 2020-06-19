package com.microservices.ads.controller;

import com.microservices.ads.dto.request.ReportRequest;
import com.microservices.ads.dto.response.CarBrandResponse;
import com.microservices.ads.dto.response.ReportResponse;
import com.microservices.ads.service.ICarBrandService;
import com.microservices.ads.service.implementation.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    ReportService reportService;



    @PostMapping
    public ReportResponse createReport(@RequestBody ReportRequest reportRequest) {
        return  reportService.createReport(reportRequest);
    }

}