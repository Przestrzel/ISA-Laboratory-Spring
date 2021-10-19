package com.example.auilaboratory;

import com.example.auilaboratory.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLine implements CommandLineRunner {

    private TeamService teamService;

    @Autowired
    public CommandLine(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public void run(String... args) throws Exception {
        teamService.findAll().forEach(System.out::println);
    }
}
