package com.hutech.ticket.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class MovieCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(length = 1200)
    private String description;


    @ManyToMany(mappedBy = "category")
    private Set<Movie> movies = new HashSet<>();	
    
	public MovieCategory(){}

    public MovieCategory(Long id){
        this.Id = id;
    }

    public MovieCategory(String name) {
        this.name = name;
    }

    public MovieCategory(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Set<Movie> getMovies() {
		return movies;
	}
}
