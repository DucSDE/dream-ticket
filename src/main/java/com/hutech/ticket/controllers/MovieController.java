package com.hutech.ticket.controllers;

import com.hutech.ticket.model.Movie;
import com.hutech.ticket.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MovieController {

    @Autowired
    MovieRepository movieRepository;
    
    @GetMapping("/movies/{Id}")
    public String detailMovie(@PathVariable Long Id, Model model) {
    	Movie detailMovie = movieRepository.findById(Id).get();
    	model.addAttribute("detailMovie", detailMovie);
    	
    	return "movie";
    }
    
    
    @GetMapping("/movies/new")
    public String createMovie(){
    	
        return "movie_form";
    }
}
