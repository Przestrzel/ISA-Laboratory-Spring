package com.example.auilaboratory.team.repository;

import com.example.auilaboratory.datastore.DataStore;
import com.example.auilaboratory.repository.Repository;
import com.example.auilaboratory.team.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TeamRepository implements Repository<Team, String> {
    private DataStore dataStore;

    @Autowired
    public TeamRepository(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public Optional<Team> find(String name) {
        return dataStore.findTeam(name);
    }

    @Override
    public List<Team> findAllObjects() {
        return dataStore.findAllTeams();
    }

    @Override
    public void save(Team team) {
        dataStore.createTeam(team);
    }

    @Override
    public void delete(Team e) {
        dataStore.deleteTeam(e);
    }
}
