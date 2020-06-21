package com.microservices.search.service.implementation;

import com.microservices.search.dto.GearBoxTypeDTO;
import com.microservices.search.model.GearShiftType;
import com.microservices.search.repository.IGearShiftTypeRepository;
import com.microservices.search.service.IGearShiftTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GearShiftTypeService implements IGearShiftTypeService {

    private final IGearShiftTypeRepository _gearShiftTypeRepository;

    public GearShiftTypeService(IGearShiftTypeRepository gearShiftTypeRepository) {
        _gearShiftTypeRepository = gearShiftTypeRepository;
    }

    @Override
    public GearBoxTypeDTO getGearShiftType(long id) {
        GearShiftType typeOfGearshift = _gearShiftTypeRepository.findOneById(id);

        GearBoxTypeDTO typeOfGearshiftResponse = new GearBoxTypeDTO();
        typeOfGearshiftResponse.setId(typeOfGearshift.getId());
        typeOfGearshiftResponse.setType(typeOfGearshiftResponse.getType());

        return typeOfGearshiftResponse;
    }

    @Override
    public List<GearBoxTypeDTO> getAllGearShiftTypes() {
        List<GearShiftType> typeOfGearshifts = _gearShiftTypeRepository.findAllByDeleted(false);

        List<GearBoxTypeDTO> typeOfGearshiftResponses = new ArrayList<>();

        for(GearShiftType typeOfGearshift: typeOfGearshifts) {
            GearBoxTypeDTO typeOfGearshiftResponse = new GearBoxTypeDTO();
            typeOfGearshiftResponse.setId(typeOfGearshift.getId());
            typeOfGearshiftResponse.setType(typeOfGearshift.getType());
            typeOfGearshiftResponses.add(typeOfGearshiftResponse);
        }

        return typeOfGearshiftResponses;
    }

       @Override
       public GearBoxTypeDTO createGearShiftType(GearBoxTypeDTO request) {
           GearShiftType typeOfGearshift = new GearShiftType();
           typeOfGearshift.setType(request.getType());
           typeOfGearshift.setDeleted(false);
           _gearShiftTypeRepository.save(typeOfGearshift);
           GearBoxTypeDTO typeOfGearshiftResponse = new GearBoxTypeDTO(typeOfGearshift);
           return typeOfGearshiftResponse;
       }
       /*
       @Override
       public TypeOfGearshiftResponse updateTypeOfGearshift(UpdateTypeOfGearshiftRequest request, long id) {
           TypeOfGearshift typeOfGearshift = _typeOfGearshiftRepository.findOneById(id);
           typeOfGearshift.setType(request.getType());
           _typeOfGearshiftRepository.save(typeOfGearshift);
           TypeOfGearshiftResponse typeOfGearshiftResponse = new TypeOfGearshiftResponse();
           typeOfGearshiftResponse.setId(typeOfGearshift.getId());
           typeOfGearshiftResponse.setType(typeOfGearshift.getType());
           return typeOfGearshiftResponse;
       }
   */
    @Override
    public void deleteGearShiftType(long id) {
        GearShiftType typeOfGearshift = _gearShiftTypeRepository.findOneById(id);
        typeOfGearshift.setDeleted(true);

        _gearShiftTypeRepository.save(typeOfGearshift);
    }
}
