package com.agent.agentapp.repository;

import com.agent.agentapp.entity.Authority;
import com.agent.agentapp.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findByName(String name);
}
