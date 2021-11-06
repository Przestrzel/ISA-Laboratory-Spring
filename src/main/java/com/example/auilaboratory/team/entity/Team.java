package com.example.auilaboratory.team.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(of = "name")
@Entity
@Table(name="teams")
public class Team implements Serializable {

    /**
     * Name of the team is unique.
     */
    @Id
    private String name;

    private double budget;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players;

    @Override
    public String toString() {
        return '\n' + "Team: " + name + " | budget: " + budget;
    }
}
