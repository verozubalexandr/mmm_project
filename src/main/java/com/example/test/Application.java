package com.example.test;

import com.example.test.controller.DataBase;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws JSONException {
        DataBase contributors = new DataBase();
        contributors.load();

        SpringApplication.run(Application.class, args);
        contributors.save();
    }
}


