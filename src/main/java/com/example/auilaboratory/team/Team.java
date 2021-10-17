package com.example.auilaboratory.team;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Team implements Serializable {
    private String name;

    private double budget;

    private List<Player> players;
}
