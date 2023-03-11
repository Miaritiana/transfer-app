package com.bank.transferapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
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
    private Customer customer;
}
