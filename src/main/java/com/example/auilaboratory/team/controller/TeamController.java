package com.example.auilaboratory.team.controller;

import com.example.auilaboratory.team.dto.*;
import com.example.auilaboratory.team.entity.Team;
import com.example.auilaboratory.team.service.PlayerService;
import com.example.auilaboratory.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping("api/teams")
public class TeamController {
    private PlayerService playerService;
    private TeamService teamService;

    @Autowired
    public TeamController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<Void> createTeam(@RequestBody CreateTeamRequest request, UriComponentsBuilder builder) {
        Team team = CreateTeamRequest
                .dtoToEntityMapper()
                .apply(request);
        team = teamService.save(team);

        return ResponseEntity.created(builder.pathSegment("api", "teams", "{name}")
                .buildAndExpand(team.getName()).toUri()).build();
    }

    @DeleteMapping("{name}")
    public ResponseEntity<Void> deleteTeam(@PathVariable("name") String name){
        Optional<Team> team = teamService.find(name);
        if(team.isPresent()){
            teamService.delete(team.get());
            return ResponseEntity.accepted().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
