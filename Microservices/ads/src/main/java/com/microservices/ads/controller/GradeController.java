package com.microservices.ads.controller;

import com.microservices.ads.dto.request.GradeAdCarRequest;
import com.microservices.ads.dto.response.AvgGradeResponse;
import com.microservices.ads.dto.response.GradeResponse;
import com.microservices.ads.service.IGradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/grades")
public class GradeController {

    private final IGradeService gradeService;

    public GradeController(IGradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping
    public void gradeAdCar(@RequestBody GradeAdCarRequest request) throws Exception {
        gradeService.gradeOrder(request);
    }

    @GetMapping("/{id}/ad-car")
    public List<GradeResponse> getAllGradesByAdCar(@PathVariable Long id) {
        return gradeService.getAllGradesByAdCar(id);
    }

    @GetMapping("avg-grade/{id}/ad-car")
    public AvgGradeResponse getAvgGradeResponse(@PathVariable Long id) {
        return gradeService.getAvgGradeResponse(id);
    }
}
