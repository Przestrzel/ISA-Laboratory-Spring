package com.example.auilaboratory.team.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Player implements Serializable {

    /**
     * Full name is unique in my system.
     */
    private String fullName;

    private int age;

    private double height;

    private double weight;

    /**
     * Position on which player do play. for example: Striker, Goalkeeper;
     */
    private String position;

    private double value;

    private String nationality;

    /**
     * Team that player belongs to
     */
    private Team team;
}
