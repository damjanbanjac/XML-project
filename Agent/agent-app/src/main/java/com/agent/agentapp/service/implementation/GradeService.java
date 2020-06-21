package com.agent.agentapp.service.implementation;

import com.agent.agentapp.dto.request.GradeAdCarRequest;
import com.agent.agentapp.dto.response.AvgGradeResponse;
import com.agent.agentapp.dto.response.GradeResponse;
import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.entity.Grade;
import com.agent.agentapp.entity.Order;
import com.agent.agentapp.entity.User;
import com.agent.agentapp.repository.AdCarRepository;
import com.agent.agentapp.repository.IGradeRepository;
import com.agent.agentapp.repository.IOrderRepository;
import com.agent.agentapp.repository.IUserRepository;
import com.agent.agentapp.service.IGradeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService implements IGradeService {

    private final IGradeRepository gradeRepository;

    private final IOrderRepository orderRepository;

    private final AdCarRepository adCarRepository;

    private final IUserRepository userRepository;

    public GradeService(IGradeRepository gradeRepository, IOrderRepository orderRepository, AdCarRepository adCarRepository, IUserRepository userRepository) {
        this.gradeRepository = gradeRepository;
        this.orderRepository = orderRepository;
        this.adCarRepository = adCarRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void gradeOrder(GradeAdCarRequest request) throws Exception {
        AdCar adCar = adCarRepository.findOneById(request.getAdCarId());
//        User user = userRepository.findOneById(request.getUserId());

//        Order order = null;
//        for (Order o: adCar.getOrders()) {
//            if(o.getUser() == user && o.isUsingTimeUp()) {
//                order = o;
//                break;
//            }
//        }
//
//        if(order == null){
//            throw new Exception("You cannot grade this ad.");
//        }
//
//        for (Grade g: adCar.getGrades()) {
//            if(g.getUserId() == user.getId()) {
//                throw new Exception("You have already graded this ad.");
//            }
//        }

        Grade grade = new Grade();
        grade.setAdCar(adCar);
        grade.setDeleted(false);
        grade.setGrade(request.getGrade());
//        grade.setUserId(user.getId());
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
