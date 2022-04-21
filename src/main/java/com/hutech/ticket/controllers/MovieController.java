package com.hutech.ticket.controllers;

import com.hutech.ticket.model.Movie;
import com.hutech.ticket.model.User;
import com.hutech.ticket.repository.MovieRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MovieController {

    @Autowired
    MovieRepository movieRepository;
    
    @GetMapping("/all")
    public String getALlMovie(Model model) {
    	List<Movie> allMovies = movieRepository.findAll();
    	model.addAttribute("allMovies", allMovies);
    	model.addAttribute("user", new User());
        model.addAttribute("userLogin", new User());
    	return "all_movie";
    }
    
    @GetMapping("/now_showings")
    public String getNowShowingsMovie(Model model) {
    	List<Movie> nowShowings = movieRepository.findAll();
    	model.addAttribute("nowShowings", nowShowings);
    	model.addAttribute("user", new User());
        model.addAttribute("userLogin", new User());
    	return "all_movie";
    }
    
    @GetMapping("/incomings")
    public String getIncomingMovie(Model model) {
    	List<Movie> inComings = movieRepository.getIncomings();
    	model.addAttribute("inComings", inComings);
    	model.addAttribute("user", new User());
        model.addAttribute("userLogin", new User());
    	return "all_movie";
    }
    
    @GetMapping("/movies/{Id}")
    public String detailMovie(@PathVariable Long Id, Model model) {
    	
//    	Select * from movie where movie.id = Id 
    	Movie detailMovie = movieRepository.findById(Id).get();
    	model.addAttribute("detailMovie", detailMovie);
    	int yearRelease =  detailMovie.getYearStart();
    	float ratting = detailMovie.getRating();
    	
    	model.addAttribute("yearRelease", yearRelease);
    	model.addAttribute("ratting", ratting);
    	model.addAttribute("user", new User());
        model.addAttribute("userLogin", new User());
    	
    	return "movie_detail";
    }
    
    
    @GetMapping("/movies/new")
    public String createMovie(){
    	
        return "movie_form";
    }
    
    
    
}
