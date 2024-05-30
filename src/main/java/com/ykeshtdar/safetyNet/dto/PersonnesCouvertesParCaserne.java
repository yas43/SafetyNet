package com.ykeshtdar.safetyNet.dto;
import org.springframework.stereotype.*;


// this class corresponding to "http://localhost:8080/firestation?stationNumber=<station_number>"
@Component
public class PersonnesCouvertesParCaserne {

    private String firstName;
    private String lastName;
    private String adresse;
    private String phone;
    private boolean isAdults;
    private boolean isKids;
    private int totalNumberOfAdults;
    private int totalNumberOfKids;

    @Override
    public String toString() {
        return "PersonnesCouvertesParCaserne{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adresse='" + adresse + '\'' +
                ", phone='" + phone + '\'' +
                ", isAdults=" + isAdults +
                ", isKids=" + isKids +
                ", totalNumberOfAdults=" + totalNumberOfAdults +
                ", totalNumberOfKids=" + totalNumberOfKids +
                '}';
    }



    public int getTotalNumberOfAdults() {
        return totalNumberOfAdults;
    }

    public int getTotalNumberOfKids() {
        return totalNumberOfKids;
    }

    public void setTotalNumberOfAdults(int totalNumberOfAdults) {
        this.totalNumberOfAdults = totalNumberOfAdults;
    }

    public void setTotalNumberOfKids(int totalNumberOfKids) {
        this.totalNumberOfKids = totalNumberOfKids;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isAdults() {
        return isAdults;
    }

    public boolean isKids() {
        return isKids;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAdults(boolean adults) {
        isAdults = adults;
    }

    public void setKids(boolean kids) {
        isKids = kids;
    }


}
