package com.ykeshtdar.safetyNet.dto;


import org.springframework.stereotype.*;

import java.util.*;
@Component
public class NumerosTelephoneParCaserne {

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumerosTelephoneParCaserne that = (NumerosTelephoneParCaserne) o;
        return Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    @Override
    public String toString() {
        return "NumérosTéléphoneParCaserne{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
