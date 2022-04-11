package com.hutech.ticket.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Start {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 120, nullable = false)
    private String name;

    @Column(nullable = false)
    private Date dob;



}
