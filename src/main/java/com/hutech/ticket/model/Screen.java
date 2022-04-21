package com.hutech.ticket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Screen {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long Id;
	
	private String name;
	
	@ManyToOne()
	@JoinColumn(name = "cinema_id")
	private Cinema cinemas;
	
	public Screen() {}

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

	public Cinema getScreens() {
		return cinemas;
	}

	public void setScreens(Cinema cinemas) {
		this.cinemas = cinemas;
	}
	
	
	
}
