package com.microservices.ads.repository;

import com.microservices.ads.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}

