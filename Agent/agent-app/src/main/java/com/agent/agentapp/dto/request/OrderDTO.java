package com.agent.agentapp.dto.request;

import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.entity.Order;
import lombok.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDTO {

    private Long id;
    private String availableFrom;
    private String availableTo;

    private AdCar adCar;

    public OrderDTO(Order order) {
        this.id=order.getId();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(order.getAvailableFrom());
        String strDate2 = dateFormat.format(order.getAvailableTo());
        this.availableFrom = strDate;
        this.availableTo = strDate2;
        this.adCar=order.getAdCar_id();
    }
}
