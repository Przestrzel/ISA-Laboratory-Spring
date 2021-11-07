package com.example.auilaboratory.configurator;

import com.example.auilaboratory.team.entity.Player;
import com.example.auilaboratory.team.entity.Team;
import com.example.auilaboratory.team.service.PlayerService;
import com.example.auilaboratory.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {
    private TeamService teamService;
    private PlayerService playerService;

    @Autowired
    public DataInitializer(TeamService teamService, PlayerService playerService){
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @PostConstruct
    private synchronized void init() {
        Player adam = Player.builder()
                .fullName("Adam Adam")
                .age(22)
                .height(1.8)
                .weight(78)
                .position("Striker")
                .value(200_000)
                .nationality("Poland")
                .build();

        Player maciej = Player.builder()
                .fullName("Maciej Maciej")
                .age(24)
                .height(1.82)
                .weight(84)
                .position("Midfielder")
                .value(380_000)
                .nationality("Poland")
                .build();

        Player andreas = Player.builder()
                .fullName("Andreas Andreas")
                .age(28)
                .height(1.89)
                .weight(88)
                .position("Defender")
                .value(180_000)
                .nationality("Brazil")
                .build();

        Player uria = Player.builder()
                .fullName("Uria Uria")
                .age(34)
                .height(1.96)
                .weight(88)
                .position("Goalkeeper")
                .value(120_000)
                .nationality("Russia")
                .build();

        List<Player> firstTeamPlayers = new ArrayList<>();
        firstTeamPlayers.add(adam);
        firstTeamPlayers.add(maciej);
        firstTeamPlayers.add(andreas);
        firstTeamPlayers.add(uria);

        Player lukasz = Player.builder()
                .fullName("Lukasz Lukasz")
                .age(21)
                .height(1.79)
                .weight(75)
                .position("Midfielder")
                .value(350_000)
                .nationality("Poland")
                .build();

        Player bagi = Player.builder()
                .fullName("Bagi Bagi")
                .age(23)
                .height(1.64)
                .weight(68)
                .position("Striker")
                .value(245_000)
                .nationality("Romania")
                .build();

        Player victor = Player.builder()
                .fullName("Victor Victor")
                .age(25)
                .height(1.86)
                .weight(82)
                .position("Defender")
                .value(700_000)
                .nationality("Sweden")
                .build();

        Player david = Player.builder()
                .fullName("David David")
                .age(29)
                .height(1.91)
                .weight(86)
                .position("Goalkeeper")
                .value(1_200_000)
                .nationality("Spain")
                .build();

        List<Player> secondTeamPlayers = new ArrayList<>();
        secondTeamPlayers.add(lukasz);
        secondTeamPlayers.add(bagi);
        secondTeamPlayers.add(victor);
        secondTeamPlayers.add(david);

        Team firstTeam = Team.builder().name("First team").budget(74_000_000).players(firstTeamPlayers).build();
        teamService.save(firstTeam);
        Team secondTeam = Team.builder().name("Second team").budget(89_400_000).players(secondTeamPlayers).build();
        teamService.save(secondTeam);

        firstTeamPlayers.stream().forEach(player -> player.setTeam(firstTeam));
        secondTeamPlayers.stream().forEach(player -> player.setTeam(secondTeam));

        firstTeamPlayers.stream().forEach(player -> playerService.save(player));
        secondTeamPlayers.stream().forEach(player -> playerService.save(player));
    }
}
