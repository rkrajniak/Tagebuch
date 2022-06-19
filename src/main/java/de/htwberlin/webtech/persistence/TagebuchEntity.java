package de.htwberlin.webtech.persistence;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity(name= "Tagebuch")
public class TagebuchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "author",nullable = false)
    private String author;

    @Column(name = "datum",nullable = false)
    private Date datum;

    //lob datentyp benutzen

    @Column(name = "erlebnis", nullable = false)
    private String erlebnis;

    @Column(name = "rating")
    @Enumerated(value = EnumType.STRING)
    private Rating rating;

    public TagebuchEntity(String author, Date datum, String erlebnis, Rating rating) {
        this.author = author;
        this.datum = datum;
        this.erlebnis = erlebnis;
        this.rating = rating;
    }

    public TagebuchEntity() {

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }


    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getErlebnis() {return erlebnis;}

    public void setErlebnis(String erlebnis) {
        this.erlebnis = erlebnis;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
