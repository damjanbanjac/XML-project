package com.microservices.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@RestController
@EnableFeignClients
@EnableEurekaClient

public class SearchApplication {

	public static void main(String[] args) {


//		System.out.println("dsa");
//		Date date = new Date();
//		System.out.println(date.toString());
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd-MM-yyyy");
//		System.out.println(sdf.format(date));
//
//		try{
//			Thread.sleep(5000 );
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		Date date2 = new Date();
//		System.out.println(date2.toString());
//		System.out.println(sdf.format(date2));
//
//		String dat = new String("13:32 30-3-2015");
//		System.out.println(dat);
		//Date datDate = sdf.parse(dat);
		//System.out.println(sdf.format(dat));

		//int vecimanji = date.compareTo(date2);
		//vecimanji = date2.compareTo(date);
		//System.out.println(vecimanji);



		SpringApplication.run(SearchApplication.class, args);
	}

}
