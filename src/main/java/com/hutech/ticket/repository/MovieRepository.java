package com.hutech.ticket.repository;

import com.hutech.ticket.model.Movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(value = "SELECT * FROM movie m where m.is_showing = 1", nativeQuery = true)
	public List<Movie> getNowShowings (); 
	
	@Query(value = "SELECT * FROM movie m where m.is_showing = 0", nativeQuery = true)
	public List<Movie> getIncomings (); 
}
