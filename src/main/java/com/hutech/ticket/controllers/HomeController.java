package com.hutech.ticket.controllers;

import com.hutech.ticket.helper.PasswordEncoder;
import com.hutech.ticket.model.Movie;
import com.hutech.ticket.model.User;
import com.hutech.ticket.repository.MovieRepository;
import com.hutech.ticket.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    MovieRepository movieRepository;
    
    @Autowired
    UserRepository userRepository;

    PasswordEncoder encoderHelper = new PasswordEncoder();
    
    @GetMapping(value = { "/", "home", ""})
    public String homePage(Model model, RedirectAttributes ra ) {
    	List<Movie> nowShowings = movieRepository.getNowShowings();
    	
        model.addAttribute("nowShowings", nowShowings);
        model.addAttribute("user", new User());
        model.addAttribute("userLogin", new User());
        model.addAttribute("nav_userLogin", null);
        var loginUser = ra.getFlashAttributes();       
//        if(loginUser != null)
//        	model.addAttribute("nav_userLogin", loginUser);
        return "index";
    }
    
    @PostMapping("/register")
    public String newRegister(User user) {
    	String encodedPassword = encoderHelper.encode(user.getPassword());
    	user.setPassword(encodedPassword);
    	userRepository.save(user);    	
    	return "redirect:";
    }
    
    private Boolean isValidLogin(User user) {
    	User findUser = userRepository.findByUsername(user.getUsername());
    	boolean validPassword = false;
    	if(findUser != null) {
    	validPassword = encoderHelper
						.matches(user.getPassword(), findUser.getPassword());
    	}
    	return validPassword;
    }
    
    @PostMapping("/login")
    public String login(User userLogin, RedirectAttributes ra) {
    	System.out.println("USER before login: " + userLogin.getUsername());
    	System.out.println("PASSWORD before login: " + userLogin.getPassword());
    	if(!isValidLogin(userLogin)) {
    		return "redirect:500" ;
    	}
    	User findUser = userRepository.findByUsername(userLogin.getUsername());
    	ra.addFlashAttribute("LoginUser", findUser);
    	return "redirect:/"; 
    }
    
    @PostMapping("/logout")
    public String logout(User userLogin, RedirectAttributes rm){
    	userLogin = null;
    	rm.addFlashAttribute("LoginUser", userLogin);
        return "redirect:/";
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
