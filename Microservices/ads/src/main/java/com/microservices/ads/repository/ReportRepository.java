package com.microservices.ads.repository;

import com.microservices.ads.model.Agent;
import com.microservices.ads.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
