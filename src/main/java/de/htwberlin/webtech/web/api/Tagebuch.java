package de.htwberlin.webtech.web.api;


import de.htwberlin.webtech.persistence.Rating;

import java.sql.Clob;
import java.util.Date;

public class Tagebuch {



    private Long id;
    private String author;
    private Date datum;
    private String erlebnis;
    //soll angeben ob der tag gut oder schlecht war
    private String rating;



    public Tagebuch(Long id, String author, Date datum, String erlebnis, String rating) {
        this.id = id;
        this.author= author;
        this.datum = datum;
        this.erlebnis = erlebnis;
        this.rating = rating;

    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getErlebnis() {
        return erlebnis;
    }

    public void setErlebnis(String erlebnis) {
        this.erlebnis = erlebnis;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
