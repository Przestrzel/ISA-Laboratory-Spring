package com.example.auilaboratory.team.service;

import com.example.auilaboratory.team.entity.Team;
import com.example.auilaboratory.team.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return repository.findByName(name);
    }

    public List<Team> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Team save(Team team) {
        return repository.save(team);
    }

    @Transactional
    public void delete(Team team) {
        repository.delete(team);
    }

    @Transactional
    public void update(Team team) {
        repository.save(team);
    }
}

