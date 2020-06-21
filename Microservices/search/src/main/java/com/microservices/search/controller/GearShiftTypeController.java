package com.microservices.search.controller;

import com.microservices.search.dto.FuelTypeDTO;
import com.microservices.search.dto.GearBoxTypeDTO;
import com.microservices.search.model.GearShiftType;
import com.microservices.search.service.IGearShiftTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/gearshift-types")
public class GearShiftTypeController {

    private final IGearShiftTypeService _gearShiftTypeService;

    public GearShiftTypeController(IGearShiftTypeService gearShiftTypeService) {
        _gearShiftTypeService = gearShiftTypeService;
    }

    @GetMapping("/{id}/gearshift-type")
    public GearBoxTypeDTO getTypeOfGearshift(@PathVariable Long id) {
        return _gearShiftTypeService.getGearShiftType(id);
    }

    @GetMapping
    public List<GearBoxTypeDTO> getAllTypesOfGearshift() {
        return _gearShiftTypeService.getAllGearShiftTypes();
    }

    @PostMapping(value = "/gearshift-type")
    public ResponseEntity<GearBoxTypeDTO> createCarModel(@RequestBody GearBoxTypeDTO gearBoxTypeDTO) throws Exception {

        GearBoxTypeDTO gearboxtypedto = new GearBoxTypeDTO();
        gearboxtypedto = _gearShiftTypeService.createGearShiftType(gearBoxTypeDTO);

        return new ResponseEntity<GearBoxTypeDTO>(gearboxtypedto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/gearshift-type")
    public void deleteTypeOfGearshift(@PathVariable Long id) {
        _gearShiftTypeService.deleteGearShiftType(id);
    }
}