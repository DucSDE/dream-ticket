package com.hutech.ticket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hutech.ticket.model.Cinema;
import com.hutech.ticket.model.City;
import com.hutech.ticket.model.Movie;
import com.hutech.ticket.model.User;
import com.hutech.ticket.repository.CinemaRepository;
import com.hutech.ticket.repository.CityRepository;
import com.hutech.ticket.repository.MovieRepository;

@Controller
public class BookingController {
	
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	CityRepository cityRepository;
	@Autowired
	CinemaRepository cinemaRepository;
	
	@GetMapping("/booking/{Id}")
	public String bookingPage(@PathVariable Long Id, Model model) {
		Movie detailMovie = movieRepository.findById(Id).get();
		List<City> cities = cityRepository.findAll();
		List<Cinema> cinemas = cinemaRepository.findAll();
		model.addAttribute("detailMovie", detailMovie);
		model.addAttribute("cities", cities);
		model.addAttribute("cinemas", cinemas);
		model.addAttribute("user", new User());
        model.addAttribute("userLogin", new User());
		
		return "booking";
	}
	
	@GetMapping("/ticket/{Id}/{city_id}/{day}/{type}/{time_id}")
	public String orderTicket(@PathVariable Long Id,
								@PathVariable Long city_id,
								@PathVariable Long day,
								@PathVariable Long type,
								@PathVariable Long time_id,
								Model model)
	{
		Movie detailMovie = movieRepository.findById(Id).get();
		model.addAttribute("detailMovie", detailMovie);
		model.addAttribute("user", new User());
        model.addAttribute("userLogin", new User());
        
		return "ticket";
	}
	
}
