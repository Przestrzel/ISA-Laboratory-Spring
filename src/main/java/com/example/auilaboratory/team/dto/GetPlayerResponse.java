package com.example.auilaboratory.team.dto;

import com.example.auilaboratory.team.entity.Player;
import lombok.*;


import java.util.UUID;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetPlayerResponse {
    private UUID id;

    private String fullName;

    private int age;

    private double height;

    private double weight;

    private String position;

    private double value;

    private String nationality;

    private String teamName;

    public static Function<Player, GetPlayerResponse> entityToDtoMapper(){
        return player -> GetPlayerResponse.builder()
                .id(player.getId())
                .fullName(player.getFullName())
                .age(player.getAge())
                .height(player.getHeight())
                .weight(player.getWeight())
                .position(player.getPosition())
                .value(player.getValue())
                .nationality(player.getNationality())
                .teamName(player.getTeam().getName())
                .build();
    }
}
