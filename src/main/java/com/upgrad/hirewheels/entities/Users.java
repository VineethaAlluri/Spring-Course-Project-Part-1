package com.upgrad.hirewheels.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="user_id")
    private int id;

    @Column(name ="first_name", nullable = false)
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(nullable = false, columnDefinition = "varchar(50)check (length(password)>5)")
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name="mobile_no", nullable = false, unique = true)
    private int mobileNumber;

    @Column(name="role_id", nullable = false)
    private int roleId;

    @Column(name="wallet_money", precision = 8, scale = 2)
    private Double walletMoney = 10000.00;
}
