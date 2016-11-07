package com.gmail.at.rospopa.pavlo;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        Person personInstance1 = new Person("Pavlo", "Rospopa");
        Gson gson = new Gson();
        String json = gson.toJson(personInstance1);
        Person personInstance2 = gson.fromJson(json, Person.class);

        System.out.println(personInstance1.equals(personInstance2));
    }
}

