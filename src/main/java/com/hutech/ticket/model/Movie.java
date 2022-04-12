package com.hutech.ticket.model;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 500, nullable = false, unique = true)
    private String title;

    @ManyToOne()
    @JoinColumn(name = "director_id")
    private Director director;

    private Date dateStart;

    private Date dateEnd;

    private String image;
    
    private Boolean isShowing;
    
    private Float rating;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
    		  name = "movie_writer", 
    		  joinColumns = @JoinColumn(name = "movie_id"), 
    		  inverseJoinColumns = @JoinColumn(name = "writer_id"))
    private Set<Writer> writers = new HashSet<>();
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
    		  name = "movie_start", 
    		  joinColumns = @JoinColumn(name = "movie_id"), 
    		  inverseJoinColumns = @JoinColumn(name = "star_id"))
    private Set<Star> stars = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
  		  name = "movie_categories", 
  		  joinColumns = @JoinColumn(name = "movie_id"), 
  		  inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<MovieCategory> category = new HashSet<>();

	public Movie() {}

    public Movie(String title, Director director, Date dateStart, Date dateEnd) {
        this.title = title;
        this.director = director;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateStart() {
        return dateStart;
    }
    
    public int getYearStart() {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(this.dateStart);
    	return calendar.get(Calendar.YEAR);
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

	public Boolean getIsShowing() {
		return isShowing;
	}

	public void setIsShowing(Boolean isShowing) {
		this.isShowing = isShowing;
	}

	public float getRating() {
		return rating;
	}
	
	public int getNRating() {
		return Math.round(rating);
	}
	public double getRDRating() {
		return Math.round(this.rating * 2) / 2.0;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public Set<Writer> getWriters() {
		return writers;
	}

	public void setWriters(Set<Writer> writers) {
		this.writers = writers;
	}
	
	public Set<MovieCategory> getCategory() {
		return category;
	}

	public void setCategory(Set<MovieCategory> category) {
		this.category = category;
	}
	
	public Set<Star> getStars() {
		return stars;
	}

	public void setStars(Set<Star> stars) {
		this.stars = stars;
	}
}
