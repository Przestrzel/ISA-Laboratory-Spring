package com.example.auilaboratory.team.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(of = "name")
@ToString
public class Team implements Serializable {

    /**
     * Name of the team is unique.
     */
    private String name;

    private double budget;

    private List<Player> players;
}
