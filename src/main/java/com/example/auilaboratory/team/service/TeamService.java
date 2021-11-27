package com.example.auilaboratory.team.service;

import com.example.auilaboratory.team.entity.Team;
import com.example.auilaboratory.team.event.repository.TeamEventRepository;
import com.example.auilaboratory.team.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private TeamRepository repository;

    private TeamEventRepository teamEventRepository;

    @Autowired
    public TeamService(TeamRepository repository, TeamEventRepository teamEventRepository){
        this.repository = repository;
        this.teamEventRepository = teamEventRepository;
    }

    public Optional<Team> find(String name) {
        return repository.findByName(name);
    }

    public List<Team> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void save(Team team) {
        repository.save(team);
        teamEventRepository.create(team);
    }

    @Transactional
    public void delete(Team team) {
        repository.delete(team);
        teamEventRepository.delete(team);
    }

    @Transactional
    public void update(Team team) {
        repository.save(team);
    }
}

