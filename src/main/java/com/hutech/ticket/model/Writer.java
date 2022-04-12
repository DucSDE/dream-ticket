package com.hutech.ticket.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Writer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(length = 120, nullable = false)
    private String name;

    @Column(nullable = false)
    private Date dob;
    
    @ManyToMany(mappedBy = "writers")
    private Set<Movie> movies = new HashSet<>();	

	public Writer() {
		
	}
	
	public Writer(String name, Date dob) {
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
