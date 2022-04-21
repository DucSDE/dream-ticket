package com.hutech.ticket.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cinema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(length = 150, nullable = false, unique = true)
	private String name;
	
	@Column(length = 255)
	private String adress;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@OneToMany(mappedBy = "cinemas")
    private Set<Screen> screens = new HashSet<>();
	
	public Cinema() {
	}

	public Cinema(String name, String adress) {
		super();
		this.name = name;
		this.adress = adress;
	}

	public Cinema(Long id, String name, String adress) {
		super();
		Id = id;
		this.name = name;
		this.adress = adress;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
}
