package com.example.auilaboratory.team.service;

import com.example.auilaboratory.team.entity.Player;
import com.example.auilaboratory.team.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private PlayerRepository repository;

    @Autowired
    public PlayerService(PlayerRepository repository){
        this.repository = repository;
    }

    public Optional<Player> find(String fullName) {
        return repository.find(fullName);
    }

    public List<Player> findAll() {
        return repository.findAll();
    }

    public void save(Player player) {
        repository.save(player);
    }

    public void delete(Player e) {
        repository.delete(e);
    }
}
