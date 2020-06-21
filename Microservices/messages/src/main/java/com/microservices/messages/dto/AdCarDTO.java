package com.microservices.messages.dto;

import com.microservices.messages.model.AdCar;
import com.microservices.messages.model.Agent;
import com.microservices.messages.model.Order;
import com.microservices.messages.model.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdCarDTO {

    private Long id;
    private User userIzdavaoAd;
    private Agent agentIzdaoAd;

    public AdCarDTO(AdCar adCar) {
        this.id=adCar.getId();
        this.userIzdavaoAd=adCar.getUserIzdavaoAd();
        this.agentIzdaoAd=adCar.getAgentIzdaoAd();
    }
}