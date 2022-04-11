package com.hutech.ticket.model;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private MovieCategory category;

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

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public MovieCategory getCategory() {
        return category;
    }

    public void setCategory(MovieCategory category) {
        this.category = category;
    }
}
