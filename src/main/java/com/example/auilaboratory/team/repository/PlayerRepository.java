package com.example.auilaboratory.team.repository;

import com.example.auilaboratory.datastore.DataStore;
import com.example.auilaboratory.repository.Repository;
import com.example.auilaboratory.team.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class PlayerRepository implements Repository<Player, String> {
    private DataStore dataStore;

    @Autowired
    public PlayerRepository(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public Optional<Player> find(String fullName) {
        return dataStore.findPlayer(fullName);
    }

    @Override
    public List<Player> findAll() {
        return dataStore.findAllPlayers();
    }

    @Override
    public void save(Player player) {
        dataStore.createPlayer(player);
    }

    @Override
    public void delete(Player e) {
        dataStore.deletePlayer(e);
    }
}