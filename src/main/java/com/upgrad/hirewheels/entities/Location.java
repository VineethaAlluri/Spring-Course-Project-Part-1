package com.upgrad.hirewheels.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Location {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="location_id")
    private int id;

    @Column(name="location_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, columnDefinition = "char(6)check (length(pincode)=5)")
    private String pincode;

    @Column(name ="city_id", nullable = false)
    private int cityId;
}
