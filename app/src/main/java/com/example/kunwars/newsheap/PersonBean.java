package com.example.kunwars.newsheap;

import java.io.Serializable;

/**
 * Created by Kunwar's on 28-Dec-16.
 */

public class PersonBean  implements Serializable {

    int id;
    String fName, lName, date, email, gender;


    public PersonBean() {
        id= 0;
        fName = "";
        lName = "";
        date = "";
        email = "";
        gender = "";
    }

    public PersonBean(int id, String fName, String lName, String date, String email, String gender) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.date = date;
        this.email = email;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    @Override
    public String toString() {
        return "PersonBean{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", date='" + date + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
    public boolean validatePerson(){
        return !(fName.isEmpty() && lName.isEmpty() && email.isEmpty() && date.isEmpty() && gender.isEmpty());
    }
}
