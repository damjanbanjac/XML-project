package com.microservices.ads.service;




import com.microservices.ads.dto.response.CarBrandResponse;

import java.util.List;

public interface ICarBrandService {

    CarBrandResponse getCarBrand(long id);

    List<CarBrandResponse> getAllCarBrands();



    void deleteCarBrand(long id);
}
