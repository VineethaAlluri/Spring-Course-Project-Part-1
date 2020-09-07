package com.upgrad.hirewheels.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class VehicleSubCategory {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="vehicle_subcategory_id")
    private int id;

    @Column(name="vehicle_subcategory_name", nullable = false, unique = true)
    private String name;

    @Column(name="price_per_day",precision = 8,scale = 2, nullable = false)
    private Double pricePerDay;

    @Column(name="vehicle_category_id",nullable = false)
    private int vehicleCategoryId;
}
