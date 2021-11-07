package com.example.auilaboratory.team.dto;


import com.example.auilaboratory.team.entity.Team;
import lombok.*;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetTeamResponse {

    private String name;

//    private double budget;

    public static Function<Team, GetTeamResponse> entityToDtoMapper() {
        return team -> GetTeamResponse.builder()
                .name(team.getName())
                .build();
    }
}
