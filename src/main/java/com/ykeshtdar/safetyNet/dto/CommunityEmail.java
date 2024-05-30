package com.ykeshtdar.safetyNet.dto;


import org.springframework.stereotype.*;

import java.util.*;
@Component
public class CommunityEmail {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommunityEmail that = (CommunityEmail) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "CommunityEmail{" +
                "email='" + email + '\'' +
                '}';
    }

}
