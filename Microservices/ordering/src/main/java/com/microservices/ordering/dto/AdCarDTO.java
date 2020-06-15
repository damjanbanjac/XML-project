package com.microservices.ordering.dto;

import com.microservices.ordering.model.AdCar;
import com.microservices.ordering.model.Agent;
import com.microservices.ordering.model.Order;
import com.microservices.ordering.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdCarDTO {

    private Long id;
    private Users userIzdavaoAd;
    private Agent agentIzdaoAd;

    public AdCarDTO(AdCar adCar) {
        this.id=adCar.getId();
        this.userIzdavaoAd=adCar.getUserIzdavaoAd();
        this.agentIzdaoAd=adCar.getAgentIzdaoAd();
    }
}
