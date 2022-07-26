package com.sofka.cyclingtour.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Cyclist")
@Table(name = "cyclist")
@Data
public class Cyclist {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 3, nullable = false, unique = true)
    private String cyclistCode;

//    @ManyToOne
//    @JoinColumn(name = "country", nullable = false)
//    private Country country;
    @Column(length = 1, nullable = false)
    private Long countryId;

    @Column(length = 1, nullable = false)
    private Long teamId;
}
