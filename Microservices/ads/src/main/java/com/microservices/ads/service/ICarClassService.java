package com.microservices.ads.service;



import com.microservices.ads.dto.response.CarClassResponse;

import java.util.List;

public interface ICarClassService {

    CarClassResponse getCarClass(long id);

    List<CarClassResponse> getAllCarClass();



    void deleteCarClass(long id);
}
