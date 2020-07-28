package com.whoami.mobilprogramlama;

import java.util.ArrayList;

public class Person {

    private String ID;
    private String Password;
    private Integer imgID;

    public Person(String ID, String password, Integer imgID) {
        this.ID = ID;
        Password = password;
        this.imgID = imgID;
    }

    public Person() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getImgID() {
        return imgID;
    }

    public void setImgID(Integer imgID) {
        this.imgID = imgID;
    }

    public static ArrayList<Person> getData(){
        ArrayList<Person> people = new ArrayList<Person>();
        int imgs[] = {R.drawable.usericon,R.drawable.usericon2,R.drawable.usericon3};
        String usernames[] = {"admin","admin1","admin2"};
        String passwords[] = {"admin","admin1","admin2"};

        for(int i=0; i<imgs.length ; i++){
            Person tmp = new Person();
            tmp.setID(usernames[i]);
            tmp.setImgID(imgs[i]);
            tmp.setPassword(passwords[i]);
            people.add(tmp);
        }
        return people;
    }
}
