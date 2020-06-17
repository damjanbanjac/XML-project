package com.microservices.search.service;

import com.microservices.search.dto.GearBoxTypeDTO;

import java.util.List;

public interface IGearShiftTypeService {

    GearBoxTypeDTO getGearShiftType(long id);

    List<GearBoxTypeDTO> getAllGearShiftTypes();

    GearBoxTypeDTO createGearShiftType(GearBoxTypeDTO gearBoxTypeDTO);

    void deleteGearShiftType(long id);
}
