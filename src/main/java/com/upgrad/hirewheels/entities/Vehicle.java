package com.upgrad.hirewheels.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Vehicle {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="vehicle_id")
    private int id;

    @Column(name ="vehicle_model", nullable = false)
    private String vehicleModel;

    @Column(name="vehicle_number", nullable = false)
    private String vehicleNumber;

    @Column(name="vehicle_subcategory_id")
    private int vehicleSubCategoryId;

    @Column(nullable = false)
    private String color;

    @Column(name="location_id", nullable = false)
    private int locationId;

    @Column(name="fuel_type_id", nullable = false)
    private int fuelTypeId;

    @Column(name="availability_status", nullable = false)
    private int availabilityStatus;

    @Column(name = "vehicle_image_url", nullable = false)
    private String vehicleImageUrl;
}
