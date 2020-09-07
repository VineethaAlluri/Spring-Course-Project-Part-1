package com.upgrad.hirewheels.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="role_id")
    private int id;

    @Column(name ="role_name", nullable = false, unique = true)
    private String name;
}
