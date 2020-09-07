package com.upgrad.hirewheels.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
public class Booking {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="booking_id")
    private int id;

    @Column(name ="booking_date", nullable = false)
    private Date bookingDate;

    @Column(name="pickup_date", nullable = false)
    private Date pickUpDate;

    @Column(name="dropoff_date", nullable = false)
    private Date dropOffDate;

    @Column(name="location_id", nullable = false)
    private int locationId;

    @Column(name="vehicle_id", nullable= false)
    private int vehicleId;

    @Column(name="user_id", nullable = false)
    private int userId;

    @Column(precision = 8, scale = 2, nullable = false)
    private Double amount;
}
