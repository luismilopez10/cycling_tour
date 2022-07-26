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

    private String name;

    private String cyclistCode;

    private String country;

    private Long teamId;
}
