package com.example.auilaboratory.team.dto;

import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetTeamsResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Team {
        private String name;
    }

    @Singular
    private List<Team> teams;

    public static Function<Collection<com.example.auilaboratory.team.entity.Team>, GetTeamsResponse> entityToDtoMapper(){
        return teams -> {
            GetTeamsResponseBuilder response = GetTeamsResponse.builder();
            teams.stream()
                    .map(team -> GetTeamsResponse.Team.builder()
                            .name(team.getName())
                            .build())
                    .forEach(response::team);
            return response.build();
        };
    }
}
