package com.microservices.ads;

import com.microservices.ads.model.AdCar;
import com.microservices.ads.repository.AdCarRepository;
import com.microservices.ads.service.IAdCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AdsApplication {

//	@Autowired
//	AdCarRepository adCarRepository;

	public static void main(String[] args) {
		SpringApplication.run(AdsApplication.class, args);

//		List<AdCar> cars = adCarRepository.findAll();
//
//		AdCar car = adCarRepository
	}

}
