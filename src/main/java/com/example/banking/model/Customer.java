package com.example.banking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Entity(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_customer")
    private int idCustomer;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "name")
    private String Name;
    @Column(name = "phone_number")
    private int phoneNumber;
    @Column(name = "address")
    private String Address;
    @Column(name = "birthday")
    private Date Birthday;
    @Column(name = "nic_number")
    private int nicNumber;
}
