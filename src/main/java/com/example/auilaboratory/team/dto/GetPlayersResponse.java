package com.example.auilaboratory.team.dto;

import com.example.auilaboratory.team.entity.Player;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetPlayersResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Player {
        private UUID id;

        private String fullName;
    }

    @Singular
    private List<Player> players;

    public static Function<Collection<com.example.auilaboratory.team.entity.Player>, GetPlayersResponse> entityToDtoMapper(){
        return players -> {
            GetPlayersResponseBuilder response = GetPlayersResponse.builder();
            players.stream()
                    .map(player -> Player.builder()
                            .id(player.getId())
                            .fullName(player.getFullName())
                            .build())
                    .forEach(response::player);
            return response.build();
        };
    }
}
