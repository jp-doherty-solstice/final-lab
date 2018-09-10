package com.doherty.accountservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private long accountId;

    private String firstName;
    private String lastName;
    private String emailAddress;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Address> addresses;

    public Account() { }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}