package com.example.myappstudentmanagement.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Student implements Serializable {
    private int mssv;
    private String fullname;
    private String dob;
    private String email;
    private String address;

    public Student(int mssv, String fullname, String dob, String email, String address) {
        this.mssv = mssv;
        this.fullname = fullname;
        this.dob = dob;
        this.email = email;
        this.address = address;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @NonNull
    @Override
    public String toString() {
        return "Student {" +
                "mssv: " + mssv +
                "full name: " + fullname +
                "date of birth: " + dob +
                "email: " + email +
                "address: " + address
                + "}";
    }
}
