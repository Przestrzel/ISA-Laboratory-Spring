package com.example.auilaboratory.team.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name="players")
public class Player implements Serializable {

    @Id
    private final UUID id = UUID.randomUUID();

    @Column(name="full_name")
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
    @ManyToOne
    @JoinColumn(name = "team")
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
                ", team='" + team.getName() + '\'' +'}';
    }
}
