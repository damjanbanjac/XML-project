package com.agent.agentapp.soup;

import com.agent.agentapp.dto.request.CreateCarBrandRequest;
import com.agent.agentapp.dto.response.CarBrandResponse;
import com.agent.agentapp.entity.CarBrand;
import com.agent.agentapp.repository.ICarBrandRepository;
import com.agent.agentapp.service.implementation.CarBrandService;
import com.xml.AdsApp.wsdl.GetcarBrandRequest;
import com.xml.AdsApp.wsdl.GetcarBrandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.io.IOException;

public class CarBrandClient extends WebServiceGatewaySupport {

    @Autowired
    CarBrandService carBrandService;

    @Autowired
    ICarBrandRepository carBrandRepository;

    public GetcarBrandResponse createCarBrand(CreateCarBrandRequest carBrandRequest)  {

        GetcarBrandRequest request = new GetcarBrandRequest();
        request.setDeleted(false);
        request.setLabel(carBrandRequest.getLabel());
        request.setName(carBrandRequest.getName());



        GetcarBrandResponse response = (GetcarBrandResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8098/ws/ads-service-schema", request,
                        new SoapActionCallback("http://localhost:8098/ws/ads-service-schema/getcarBrandRequest"));

        CarBrand carBrand = new CarBrand();
        carBrand.setDeleted(false);
        carBrand.setName(carBrandRequest.getName());
        carBrand.setLabel(carBrandRequest.getLabel());
        carBrandRepository.save(carBrand);

        return response;
    }

}

