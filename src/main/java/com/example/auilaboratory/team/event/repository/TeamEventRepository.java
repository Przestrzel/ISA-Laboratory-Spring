package com.example.auilaboratory.team.event.repository;

import com.example.auilaboratory.team.event.dto.CreateTeamRequest;
import com.example.auilaboratory.team.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class TeamEventRepository {

    private RestTemplate restTemplate;

    @Autowired
    public TeamEventRepository(@Value("${players.url}")String baseUrl){
        restTemplate = new RestTemplateBuilder()
                .rootUri(baseUrl)
                .build();
    }

    public void delete(Team team){
        restTemplate.delete("/teams/{name}", team.getName());
    }

    public void create(Team team) {
        restTemplate.postForLocation("/teams", CreateTeamRequest.entityToDtoMapper().apply(team));
    }
}
