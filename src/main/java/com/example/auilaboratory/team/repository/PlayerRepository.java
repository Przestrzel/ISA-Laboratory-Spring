package com.example.auilaboratory.team.repository;

import com.example.auilaboratory.team.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

    Optional<Player> findByFullName(String fullName);

}