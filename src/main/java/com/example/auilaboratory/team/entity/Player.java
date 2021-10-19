package com.example.auilaboratory.team.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Player implements Serializable {

    private final UUID id = UUID.randomUUID();

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

    @Override
    public String toString() {
        return '\n' + "Player {" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", position='" + position + '\'' +
                ", value=" + value +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
