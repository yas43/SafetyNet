package com.ykeshtdar.safetyNet.dto;

//this class corresponding to "http://localhost:8080/communityEmail?city=<city>"

public class CommunityEmail {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CommunityEmail{" +
                "email='" + email + '\'' +
                '}';
    }
}
