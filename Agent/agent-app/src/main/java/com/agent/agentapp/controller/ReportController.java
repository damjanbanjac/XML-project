package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.ReportRequest;
import com.agent.agentapp.dto.response.ReportResponse;
import com.agent.agentapp.service.implementation.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    ReportService reportService;

    @PostMapping
    // @PreAuthorize("hasAuthority('CREATE-REPORT'')")
    // @PreAuthorize("hasAuthority('AGENT')")
    public ReportResponse createReport(@RequestBody ReportRequest reportRequest) {
        return  reportService.createReport(reportRequest);
    }

}