package com.example.auilaboratory.team;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Player implements Serializable {

    private String fullName;

    private int age;

    private double height;

    private double weight;

    /**
     * Position on which player do play. for example: Striker, Goalkeeper;
     * */
    private String position;

    private double value;

    private String nationality;

    /**
     * Team that player belongs to
     */
    private Team team;
}
