package com.example.auilaboratory.team.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Player implements Serializable {

    /**
     * Full name is unique in my system. *Change to UUID*
     */
    private String fullName;

    private int age;

    /**
     * Height in meters
     */
    private double height;

    /**
     * Weight in kilograms
     */
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
