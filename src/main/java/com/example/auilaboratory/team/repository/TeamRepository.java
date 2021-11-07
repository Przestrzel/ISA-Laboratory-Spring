package com.example.auilaboratory.team.repository;

import com.example.auilaboratory.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface TeamRepository extends JpaRepository<Team, String> {

    Optional<Team> findByName(String name);

    List<Team> findAll();
}
