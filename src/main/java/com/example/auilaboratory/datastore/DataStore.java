package com.example.auilaboratory.datastore;

import com.example.auilaboratory.serialization.Cloning;
import com.example.auilaboratory.team.entity.Player;
import com.example.auilaboratory.team.entity.Team;
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

    public synchronized void createPlayer(Player p) {
        findPlayer(p.getFullName()).ifPresentOrElse(
                present -> {
                    throw new IllegalArgumentException(
                            "The player " + p.getFullName() + " is already in database"
                    );
                },
                () -> players.add(Cloning.clone(p))
        );
    }

    public synchronized void deletePlayer(Player p){
        findPlayer(p.getFullName()).ifPresentOrElse(
                present -> players.remove(present),
                () -> {
                    throw new IllegalArgumentException(
                            "The player " + p.getFullName() + " is not in database"
                    );
                }
        );
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

    public synchronized void createTeam(Team t) {
        findTeam(t.getName()).ifPresentOrElse(
                present -> {
                    throw new IllegalArgumentException(
                            "The team " + t.getName() + " is already in database"
                    );
                },
                () -> teams.add(Cloning.clone(t))
        );
    }
    public synchronized void deleteTeam(Team t) {
        findTeam(t.getName()).ifPresentOrElse(
                present -> teams.remove(present),
                () -> {
                    throw new IllegalArgumentException(
                            "The team " + t.getName() + " is not in database"
                    );
                }
        );
    }
}
