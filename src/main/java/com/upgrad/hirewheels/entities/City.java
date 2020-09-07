package com.upgrad.hirewheels.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class City {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="city_id")
    private int id;

    @Column(name="city_name", nullable = false)
    private String name;
}
