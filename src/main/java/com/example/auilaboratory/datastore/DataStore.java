package com.example.auilaboratory.datastore;

import com.example.auilaboratory.serialization.Cloning;
import com.example.auilaboratory.team.Player;
import com.example.auilaboratory.team.Team;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.*;

@Log
@Component
public class DataStore {
    private final Set<Player> players = new HashSet<>();
    private final Set<Team> teams = new HashSet<>();

    public synchronized List<Player> findAllPlayers() {
        return new ArrayList<>(players);
    }

    public synchronized Optional<Player> findPlayer(String fullName) {
        return players.stream()
                .filter(profession -> profession.getFullName().equals(fullName))
                .findFirst()
                .map(Cloning::clone);
    }


    public synchronized List<Team> findAllTeams() {
        return new ArrayList<>(teams);
    }

    public synchronized  Optional<Team> findTeam(String name) {
        return teams.stream()
                .filter(team -> team.getName().equals(name))
                .findFirst()
                .map(Cloning::clone);
    }
}
