package de.htwberlin.webtech.persistence;



import javax.persistence.*;
import java.util.Date;

@Entity(name= "Tagebuch")
public class TagebuchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "author")
    private String author;

    @Column(name = "Datum", nullable = false)
    private Date datum;

    @Column(name = "erlebnis", nullable = false)
    private String erlebnis;

    @Column(name = "status")
    private boolean status;

    public TagebuchEntity(String author, Date datum, String erlebnis, boolean status) {
        this.author = author;
        this.datum = datum;
        this.erlebnis = erlebnis;
        this.status = status;
    }



    public TagebuchEntity() { }

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
