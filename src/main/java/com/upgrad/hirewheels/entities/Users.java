package com.upgrad.hirewheels.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
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
    private String mobileNumber;

    @Column(name="role_id", nullable = false)
    private int roleId;

    @Column(name="wallet_money", precision = 8, scale = 2)
    private Double walletMoney = 10000.00;

    public Users(String firstName,String lastName,String password,String email,
                 String mobileNumber, int roleId, double walletMoney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.roleId = roleId;
        this.walletMoney = walletMoney;
    }
    public Users() {

    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", roleId=" + roleId +
                ", walletMoney=" + walletMoney +
                '}';
    }
}
