package com.upgrad.hirewheels.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class VehicleCategory {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="vehicle_category_id")
    private int id;

    @Column(name="vehicle_category_name", nullable = false, unique = true)
    private String name;


}
