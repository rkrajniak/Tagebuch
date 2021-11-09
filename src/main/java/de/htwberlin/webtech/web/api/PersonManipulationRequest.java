package de.htwberlin.webtech.web.api;

public class PersonManipulationRequest {

    private String firstName;
    private String lastname;
    private boolean vaccinated;

    public PersonManipulationRequest(String firstName, String lastname, boolean vaccinated) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.vaccinated = vaccinated;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
}
