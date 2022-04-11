package com.hutech.ticket.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 1, nullable = false)
    private Character gender;

    private Date dob;

    public Director(){}

    public Director(Long id) {
        this.Id = id;
    }

    public Director(String name) {
        this.name = name;
    }

    public long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
