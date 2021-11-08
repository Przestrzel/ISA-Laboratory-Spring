package com.example.auilaboratory.team.controller;

import com.example.auilaboratory.team.dto.CreatePlayerRequest;
import com.example.auilaboratory.team.dto.GetPlayerResponse;
import com.example.auilaboratory.team.dto.GetPlayersResponse;
import com.example.auilaboratory.team.dto.UpdatePlayerRequest;
import com.example.auilaboratory.team.entity.Player;
import com.example.auilaboratory.team.service.PlayerService;
import com.example.auilaboratory.team.service.TeamService;
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
@RequestMapping("api/players")
public class PlayerController {

    private PlayerService playerService;
    private TeamService teamService;

    @Autowired
    public PlayerController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<GetPlayersResponse> getPlayers() {
        List<Player> allPlayers = playerService.findAll();
        Function<Collection<Player>, GetPlayersResponse> mapper = GetPlayersResponse.entityToDtoMapper();
        GetPlayersResponse response = mapper.apply(allPlayers);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<GetPlayerResponse> getPlayer(@PathVariable("id") UUID id){
        return playerService.find(id)
                .map(value -> ResponseEntity.ok(GetPlayerResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createCharacter(@RequestBody CreatePlayerRequest request, UriComponentsBuilder builder){
        Player player = CreatePlayerRequest
                .dtoToEntityMapper(teamName -> teamService.find(teamName).orElseThrow())
                .apply(request);
        player = playerService.save(player);

        return ResponseEntity.created(builder.pathSegment("api", "players", "{id}")
                .buildAndExpand(player.getId()).toUri()).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable("id") UUID id){
        Optional<Player> player = playerService.find(id);
        if(player.isPresent()) {
            playerService.delete(player.get());
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updatePlayer(@RequestBody UpdatePlayerRequest request, @PathVariable("id") UUID id){
        Optional<Player> player = playerService.find(id);
        if(player.isPresent()){
            UpdatePlayerRequest.dtoToEntityUpdater().apply(player.get(), request);
            playerService.update(player.get());
            //Add function in dtoToEnetityUpdater to update team
            return ResponseEntity.accepted().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }

}
