package com.example.auilaboratory.team.controller;

import com.example.auilaboratory.team.dto.*;
import com.example.auilaboratory.team.entity.Player;
import com.example.auilaboratory.team.entity.Team;
import com.example.auilaboratory.team.service.PlayerService;
import com.example.auilaboratory.team.service.TeamService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@RestController
@RequestMapping("api/teams/{name}/players")
public class TeamPlayerController {
    private PlayerService playerService;
    private TeamService teamService;

    @Autowired
    public TeamPlayerController(PlayerService playerService, TeamService teamService){
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<GetPlayersResponse> getPlayers(@PathVariable("name") String name){
        Optional<Team> team = teamService.find(name);
        return team.map(value -> ResponseEntity.ok(GetPlayersResponse.entityToDtoMapper().apply(playerService.findAll(value))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<GetPlayerResponse> getPlayer(@PathVariable("name") String name,
                                                        @PathVariable("id") UUID id) {
        Optional<Team> team = teamService.find(name);
        if(team.isPresent()){
            return playerService.find(team.get(), id)
                    .map(value -> ResponseEntity.ok(GetPlayerResponse.entityToDtoMapper().apply(value)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createPlayer(@PathVariable("name") String name,
                                             @RequestBody CreatePlayerRequest request,
                                             UriComponentsBuilder builder){
        Optional<Team> team = teamService.find(name);
        if(team.isPresent()){
            Player player = CreatePlayerRequest
                    .dtoToEntityMapper(teamName -> teamService.find(teamName).orElseThrow())
                    .apply(request);
            playerService.save(player);
            return ResponseEntity.created(builder.pathSegment("api", "teams", "{name}", "players", "{id}")
                    .buildAndExpand(team.get().getName(), player.getId()).toUri()).build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable("name") String name,
                                            @PathVariable("id") UUID id){
        Optional<Team> team = teamService.find(name);
        if(!team.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Optional<Player> player = playerService.find(team.get(), id);
        if(player.isPresent()){
            playerService.delete(player.get());
            return ResponseEntity.accepted().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updatePlayer(@PathVariable("name") String name,
                                             @PathVariable("id") UUID id,
                                             @RequestBody UpdatePlayerRequest request){
        Optional<Team> team = teamService.find(name);
        if(!team.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Optional<Player> player = playerService.find(team.get(), id);
        if(player.isPresent()){
            UpdatePlayerRequest.dtoToEntityUpdater().apply(player.get(), request);
            playerService.update(player.get());
            return ResponseEntity.accepted().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
