package com.hutech.ticket.controllers;

import com.hutech.ticket.model.Movie;
import com.hutech.ticket.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping(value = { "/", "home", ""})
    public String homePage(Model model) {
    	List<Movie> nowShowings = movieRepository.getNowShowings();
    	
        model.addAttribute("nowShowings", nowShowings);

        return "index";
    }
    
    @GetMapping("/forums")
    public String forumsPage() {
        return "forums";
    }
    
    @GetMapping("/news")
    public String newsPage() {
        return "news";
    }
    
    @GetMapping("/promotion")
    public String promotionPage() {
        return "promotion";
    }
    
    @GetMapping("/blog")
    public String blogPage() {
        return "blog";
    }
    
    @GetMapping("/special_cinema")
    public String specialCinemaPage() {
        return "special_cinema";
    }
    
    @GetMapping("/coming_cinema")
    public String incomingCinemaPage() {
        return "incoming_cinema";
    }
    
    @GetMapping("/all_cinema")
    public String allCinemaPage() {
        return "all_cinema";
    }
    
}
