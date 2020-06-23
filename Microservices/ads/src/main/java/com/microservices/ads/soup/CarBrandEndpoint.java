//package com.microservices.ads.soup;
//
//import com.microservices.ads.dto.response.CarBrandResponse;
//import com.microservices.ads.model.CarBrand;
//import com.microservices.ads.repository.ICarBrandRepository;
//import com.microservices.ads.service.implementation.CarBrandService;
//import localhost._8098.ads_service_schema.GetcarBrandRequest;
//import localhost._8098.ads_service_schema.GetcarBrandResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;
//import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
//import org.springframework.ws.server.endpoint.annotation.RequestPayload;
//import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//
//import java.io.IOException;
//import java.text.ParseException;
//
//@Endpoint
//public class CarBrandEndpoint {
//
//    private static final String NAMESPACE_URI = "http://localhost:8098/ads-service-schema";
//
//    @Autowired
//    private ICarBrandRepository carBrandRepository;
//
//
//
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getcarBrandRequest")
//    @ResponsePayload
//    public GetcarBrandResponse createBrand(@RequestPayload GetcarBrandRequest request) throws ParseException, IOException {
//        System.out.println("SOAP - Create Advertisement");
//        GetcarBrandResponse response = new GetcarBrandResponse();
//     //   CarBrandResponse carBrandResponse = new CarBrandResponse();
//
//
//        CarBrand c = new CarBrand();
//
//        c.setLabel(request.getLabel());
//        c.setName(request.getName());
//        c.setDeleted(false);
//
//
//
//        carBrandRepository.save(c);
//
//        CarBrandResponse carBrandResponse = new CarBrandResponse(c);
//
//        return response;
//    }
//}
