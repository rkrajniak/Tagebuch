package de.htwberlin.webtech.web.api;

public class Person {
    private long id;
    private String firstName;
    private String lastname;
    private boolean vaccinated;

    public Person(long id, String firstName, String lastname, boolean vaccinated) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.vaccinated = vaccinated;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
}
