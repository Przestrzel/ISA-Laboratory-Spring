package com.example.auilaboratory.team.dto;

import com.example.auilaboratory.team.entity.Player;
import com.example.auilaboratory.team.entity.Team;
import lombok.*;

import java.util.function.Function;
import java.util.function.Supplier;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreatePlayerRequest {
    private String fullName;

    private int age;

    private double height;

    private double weight;

    private String position;

    private double value;

    private String nationality;

    private String teamName;

    public static Function<CreatePlayerRequest, Player> dtoToEntityMapper(Function<String, Team> teamFunction){
        return request -> Player.builder()
                .fullName(request.getFullName())
                .age(request.getAge())
                .height(request.getHeight())
                .weight(request.getWeight())
                .position(request.getPosition())
                .value(request.getValue())
                .nationality(request.getNationality())
                .team(teamFunction.apply(request.getTeamName()))
                .build();
    }
}
