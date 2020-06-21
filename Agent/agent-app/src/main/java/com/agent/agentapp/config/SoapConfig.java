package com.agent.agentapp.config;

import com.agent.agentapp.soup.CarBrandClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.xml.AdsApp.wsdl");
        return marshaller;
    }


    @Bean
    public CarBrandClient adClient(Jaxb2Marshaller marshaller) {
        CarBrandClient client = new CarBrandClient();
        client.setDefaultUri("http://localhost:8098/ads-service-schema/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }


}
