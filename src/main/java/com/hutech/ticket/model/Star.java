package com.hutech.ticket.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 120, nullable = false)
    private String name;

    private Date dob;

    @ManyToMany(mappedBy = "stars")
    private Set<Movie> movies = new HashSet<>();
    
    public Star() {}
    
	public Star(String name, Date dob) {
		super();
		this.name = name;
		this.dob = dob;
	}

	public Long getId() {
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public Set<Movie> getMovies() {
		return movies;
	}
}
