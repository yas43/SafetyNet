package com.ykeshtdar.safetyNet.dto;

// this class corresponding to "http://localhost:8080/phoneAlert?firestation=<firestation_number>"

public class NumerosTelephoneParCaserne {

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "NumérosTéléphoneParCaserne{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
