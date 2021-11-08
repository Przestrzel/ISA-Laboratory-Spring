package com.example.auilaboratory.team.repository;

import com.example.auilaboratory.team.entity.Player;
import com.example.auilaboratory.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

    Optional<Player> findById(UUID id);

    Optional<Player> findByTeamAndId(Team team, UUID id);

    List<Player> findAllByTeam(Team team);

}