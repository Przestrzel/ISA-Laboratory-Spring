package com.example.auilaboratory.team.dto;

import com.example.auilaboratory.team.entity.Player;
import com.example.auilaboratory.team.entity.Team;
import lombok.*;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateTeamRequest {
    private String name;

    public static Function<CreateTeamRequest, Team> dtoToEntityMapper(){
        return request -> Team.builder()
                .name(request.getName())
                .build();
    }
}
