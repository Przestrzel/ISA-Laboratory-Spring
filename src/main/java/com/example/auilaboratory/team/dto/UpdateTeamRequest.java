package com.example.auilaboratory.team.dto;


import com.example.auilaboratory.team.entity.Player;
import com.example.auilaboratory.team.entity.Team;
import lombok.*;

import java.util.function.BiFunction;
    //List of players to update
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateTeamRequest {

    private double budget;

    public static BiFunction<Team, UpdateTeamRequest, Team> dtoToEntityUpdater(){
        return (team, request) -> {
            team.setBudget(request.getBudget());
            return team;
        };
    }
}
