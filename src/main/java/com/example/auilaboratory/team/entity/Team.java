package com.example.auilaboratory.team.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(of = "name")
@Entity
@Table(name = "teams")
public class Team implements Serializable {

    /**
     * Name of the team is unique.
     */
    @Id
    private String name;

    private double budget;

    @Override
    public String toString() {
        return '\n' + "Team: " + name + " | budget: " + budget;
    }
}
