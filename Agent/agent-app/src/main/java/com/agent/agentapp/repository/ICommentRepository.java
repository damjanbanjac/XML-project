package com.agent.agentapp.repository;

import com.agent.agentapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {

    Comment findOneById(Long id);

    List<Comment> findAllByAdCar_Id(Long id);

}
