package com.microservices.ads.service.implementation;

import com.microservices.ads.client.OrderClient;
import com.microservices.ads.dto.request.GradeAdCarRequest;
import com.microservices.ads.dto.response.AvgGradeResponse;
import com.microservices.ads.dto.response.GradeResponse;
import com.microservices.ads.dto.response.OrderDTO;
import com.microservices.ads.model.AdCar;
import com.microservices.ads.model.Grade;
import com.microservices.ads.repository.AdCarRepository;
import com.microservices.ads.repository.IGradeRepository;
import com.microservices.ads.repository.IOrderRepository;
import com.microservices.ads.repository.IUserRepository;
import com.microservices.ads.service.IGradeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService implements IGradeService {

    private final IGradeRepository gradeRepository;

    private final OrderClient _orderClient;

    private final AdCarRepository adCarRepository;

    private final IUserRepository userRepository;

    public GradeService(IGradeRepository gradeRepository, OrderClient orderClient, AdCarRepository adCarRepository, IUserRepository userRepository) {
        this.gradeRepository = gradeRepository;
        _orderClient = orderClient;
        this.adCarRepository = adCarRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void gradeOrder(GradeAdCarRequest request) throws Exception {
        AdCar adCar = adCarRepository.findOneById(request.getAdCarId());

        List<OrderDTO> orderDTOS = _orderClient.getAllOrdersByCustomer(request.getUserId());

        boolean flag = true;
        for(OrderDTO o: orderDTOS){
            if(o.getAdCar() == adCar.getId()){
                flag = false;
                break;
            }
        }

        if(flag){
            throw new Exception("You cannot comment this ad.");
        }

        for (Grade g: adCar.getGrades()) {
            if(g.getUserId() == request.getUserId()) {
                throw new Exception("You have already graded this ad.");
            }
        }

        Grade grade = new Grade();
        grade.setAdCar(adCar);
        grade.setDeleted(false);
        grade.setGrade(request.getGrade());
        grade.setUserId(request.getUserId());
        gradeRepository.save(grade);
        adCar.getGrades().add(grade);
        adCarRepository.save(adCar);
    }

    @Override
    public List<GradeResponse> getAllGradesByAdCar(long id) {
        List<Grade> grades = gradeRepository.findAllByAdCar_Id(id);
        List<GradeResponse> gradeResponses = new ArrayList<>();

        for(Grade g: grades) {
            GradeResponse gradeResponse = new GradeResponse();
            gradeResponse.setGrade(g.getGrade());
            gradeResponse.setUserEmail(userRepository.findOneById(g.getUserId()).getEmail());
            gradeResponses.add(gradeResponse);
        }

        return gradeResponses;
    }

    @Override
    public AvgGradeResponse getAvgGradeResponse(long id) {
        AdCar adCar = adCarRepository.findOneById(id);
        AvgGradeResponse avgGradeResponse = new AvgGradeResponse();
        float suma = 0;
        float brojac = 0;
        for(Grade g: adCar.getGrades()) {
            suma += g.getGrade();
            brojac++;
        }
        if(brojac == 0){
            brojac = 1; //da ne bi doslo do deljenja s nulom
        }
        float avg = suma/brojac;
        avgGradeResponse.setAvgGrade(avg);
        return avgGradeResponse;
    }
}
