package com.hutech.ticket.controllers;

import com.hutech.ticket.model.Movie;
import com.hutech.ticket.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    public String index(){
        return "index";
    }

    public String createMovie(Movie movie){
        movieRepository.save(movie);
        return "redirect:/index";
    }
}
