package com.sofka.cyclingtour.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Country")
@Table(name = "country")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;
}
