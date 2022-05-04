package de.htwberlin.webtech.web.api;


import java.sql.Clob;
import java.util.Date;

public class Tagebuch {



    private Long id;
    private String author;
    private Date datum;
    private String erlebnis;
    //soll angeben ob der tag gut oder schlecht war
    private boolean status;



    public Tagebuch(Long id, String author, Date datum, String erlebnis, boolean status) { }

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
