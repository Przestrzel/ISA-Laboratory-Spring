package com.example.auilaboratory.team.dto;

import com.example.auilaboratory.team.entity.Player;
import lombok.*;

import java.util.function.BiFunction;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdatePlayerRequest {
    private String fullName;

    private int age;

    private String position;

    private double value;

    private String nationality;

    //Maybe add team updateable

    public static BiFunction<Player, UpdatePlayerRequest, Player> dtoToEntityUpdater(){
        return (player, request) -> {
            player.setFullName(request.getFullName());
            player.setAge(request.getAge());
            player.setPosition(request.getPosition());
            player.setValue(request.getValue());
            player.setNationality(request.getNationality());
            return player;
        };
    }
}
