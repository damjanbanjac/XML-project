package com.microservices.search.dto;

import com.microservices.search.model.GearShiftType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GearBoxTypeDTO {

    private long id;

    private String type;

    public GearBoxTypeDTO(GearShiftType gearShiftType) {
        this.id = gearShiftType.getId();
        this.type = gearShiftType.getType();
    }
}