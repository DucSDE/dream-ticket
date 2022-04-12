package com.hutech.ticket.controllers;

import com.hutech.ticket.model.Movie;
import com.hutech.ticket.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping(value = { "/", "home", ""})
    public String homePage(Model model) {
    	List<Movie> nowShowings = movieRepository.findAll();
        model.addAttribute("nowShowings", nowShowings);

        return "index";
    }
    
    
}
