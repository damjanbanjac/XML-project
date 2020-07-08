package com.microservices.search.client;


import com.microservices.search.dto.AdCarDTO;
import com.microservices.search.dto.CarBrandDTO;
import com.microservices.search.dto.ProbaDTO;
import com.microservices.search.model.CarBrand;
import com.microservices.search.model.SearchAd;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "ads")
public interface AdsClient {

//    @GetMapping("/agents/{id}/address")
//    String getAgentAddress(@PathVariable("id") UUID id);

      @GetMapping("/ads")
      List<AdCarDTO> getAllAds();

      @GetMapping("/brands")
      List<CarBrandDTO> getAllBrands();

//      @GetMapping("/ads")
//      String getAllAds();

//      @GetMapping("/ads")
//      CarBrand getAllAds();

//      @GetMapping("/ads")
//      ProbaDTO getAllAds();

      @GetMapping("/ads/{id}/user")
      List<AdCarDTO> getAllAdsFromUser(@PathVariable long id);

//    @GetMapping("/agents/{id}")
//    AgentDTO getAgent(@PathVariable("id") UUID id);
//
//    @GetMapping("/simple-users/get/{id}")
//    SimpleUserDTO getSimpleUser(@PathVariable("id") UUID id);
//
//    @GetMapping("/agents/{id}/user")
//    UserMessageDTO getUserFromAgent(@PathVariable("id") UUID id);
//
//    @GetMapping("/auth/users/{id}")
//    UserMessageDTO getUser(@PathVariable("id") UUID id);
//
//    @GetMapping("/simple-users/{id}/agent")
//    SimpleUserAgentIdResponse getAgentIDFromSimpleUser(@PathVariable("id") UUID id);
}