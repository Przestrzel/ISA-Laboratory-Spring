package com.example.auilaboratory.team.service;

import com.example.auilaboratory.team.entity.Player;
import com.example.auilaboratory.team.entity.Team;
import com.example.auilaboratory.team.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {
    private PlayerRepository repository;

    @Autowired
    public PlayerService(PlayerRepository repository){
        this.repository = repository;
    }

    public Optional<Player> find(UUID id) {
        return repository.findById(id);
    }

    public Optional<Player> find(Team team, UUID id){
        return repository.findByTeamAndId(team, id);
    }

    public List<Player> findAll() {
        return repository.findAll();
    }

    public List<Player> findAll(Team team) {
        return repository.findAllByTeam(team);
    }

    @Transactional
    public Player save(Player player) {
        return repository.save(player);
    }

    @Transactional
    public void delete(Player player) {
        repository.delete(player);
    }

    @Transactional
    public void update(Player player) {
        repository.save(player);
    }
}
