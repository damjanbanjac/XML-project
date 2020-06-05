package com.microservices.ads.repository;

import com.microservices.ads.model.CarModel;
import com.microservices.ads.model.UserAd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAdRepository extends JpaRepository<UserAd, Long> {
}
