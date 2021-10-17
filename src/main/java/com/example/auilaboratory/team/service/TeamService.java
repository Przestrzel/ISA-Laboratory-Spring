package com.example.auilaboratory.team.service;

import com.example.auilaboratory.team.entity.Team;
import com.example.auilaboratory.team.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private TeamRepository repository;

    @Autowired
    public TeamService(TeamRepository repository){
        this.repository = repository;
    }

    public Optional<Team> find(String name) {
        return repository.find(name);
    }

    public List<Team> findAll() {
        return repository.findAll();
    }

    public void save(Team team) {
        repository.save(team);
    }

    public void delete(Team e) {
        repository.delete(e);
    }
}

