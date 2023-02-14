package com.bank.transferapi.model;

import jakarta.persistence.*;
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
@Entity(name = "transaction")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaction")
    private long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "description")
    private String Description;
    @ManyToOne
    @JoinColumn(name = "customer")
    @Column(name = "customer")
    private Customer customer;
}
