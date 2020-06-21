package com.agent.agentapp.repository;

import com.agent.agentapp.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}