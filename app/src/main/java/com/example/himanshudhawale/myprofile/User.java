package com.example.himanshudhawale.myprofile;

import java.io.Serializable;

public class User implements Serializable {

    String fname, lname, department,studentId;
    int imageno;


    public User(String fname, String lname, String department, String studentId, int imageInteger) {
        this.fname = fname;
        this.lname = lname;
        this.department = department;
        this.studentId = studentId;
        this.imageno = imageInteger;
    }

    @Override
    public String toString() {
        return "User{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", department='" + department + '\'' +
                ", studentId=" + studentId +
                ", imageInteger=" + imageno +
                '}';
    }
}
