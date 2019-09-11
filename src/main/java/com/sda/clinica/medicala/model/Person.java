package com.sda.clinica.medicala.model;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected long CNP;

    protected Person (String firstName, String lastName, long CPN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CNP = CPN;
    }

    protected Person() {
    }

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

    public long getCNP() {
        return CNP;
    }

    public void setCNP(long CNP) {
        this.CNP = CNP;
    }
}
