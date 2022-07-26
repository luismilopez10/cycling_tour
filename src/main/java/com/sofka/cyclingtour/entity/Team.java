package com.sofka.cyclingtour.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Team")
@Table(name = "team")
@Data
public class Team {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String teamCode;

    private String country;

    @OneToMany(mappedBy = "teamId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cyclist> cyclistsList = new ArrayList<>();

    public Team addCyclist(Cyclist cyclist){
        this.cyclistsList.add(cyclist);
        return this;
    }
}
