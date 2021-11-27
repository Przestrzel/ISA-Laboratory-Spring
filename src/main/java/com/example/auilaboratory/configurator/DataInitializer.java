package com.example.auilaboratory.configurator;

import com.example.auilaboratory.team.entity.Team;
import com.example.auilaboratory.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private TeamService teamService;

    @Autowired
    public DataInitializer(TeamService teamService){
        this.teamService = teamService;
    }

    @PostConstruct
    private synchronized void init() {
        Team firstTeam = Team.builder()
                .name("First team")
                .budget(74_000_000)
                .build();
        teamService.save(firstTeam);

        Team secondTeam = Team.builder()
                .name("Second team")
                .budget(89_400_000)
                .build();
        teamService.save(secondTeam);
    }
}
