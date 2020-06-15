package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.GradeAdCarRequest;
import com.agent.agentapp.dto.response.AvgGradeResponse;
import com.agent.agentapp.dto.response.GradeResponse;
import com.agent.agentapp.service.IGradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
