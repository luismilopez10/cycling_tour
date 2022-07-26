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

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 3, nullable = false, unique = true)
    private String teamCode;

//    @ManyToOne
//    @JoinColumn(name = "country", nullable = false)
//    private Country country;
    @Column(length = 1, nullable = false)
    private Long countryId;

    @OneToMany(mappedBy = "teamId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cyclist> cyclistsList = new ArrayList<>();

    public Team addCyclist(Cyclist cyclist){
        this.cyclistsList.add(cyclist);
        return this;
    }
}
