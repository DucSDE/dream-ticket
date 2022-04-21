package com.hutech.ticket.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.ticket.model.Cinema;
import com.hutech.ticket.repository.CinemaRepository;

@RestController
@RequestMapping("/api")
public class RestAPIController {

	@Autowired
	CinemaRepository cinemaRepository;
	

	@GetMapping("/cinema/{Id}")
	public List<Cinema> getListCinemaByCity(@PathVariable Long Id) {
		List<Cinema> listCinemas = cinemaRepository.findAllCinemasByCityId(Id);
		return listCinemas;
	}
}
