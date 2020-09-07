package com.upgrad.hirewheels.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class FuelType {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="fuel_id")
    private int id;

    @Column(name="fuel_type",nullable = false,unique = true)
    private String type;
}
