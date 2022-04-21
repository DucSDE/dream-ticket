package com.hutech.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.hutech.ticket.model.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long>{

	@Query(value = "SELECT * FROM moviedb.cinema c WHERE c.city_id = ?1", nativeQuery = true)
	public List<Cinema> findAllCinemasByCityId(@PathVariable Long Id);
}
