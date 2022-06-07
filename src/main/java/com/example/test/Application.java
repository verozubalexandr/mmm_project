package com.example.test;

import com.example.test.controller.DataBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBase contributors = new DataBase();
        contributors.load();
        SpringApplication.run(Application.class, args);
        System.out.print("App run on http://localhost:8080\n\nTo stop the application type 'stopmmmapp' and press ENTER\n\n");
        String str = "";
        while (!Objects.equals(str.strip(), "stopmmmapp")) {
            str = scanner.nextLine();
        }
        contributors.save();
        System.exit(130);
    }
}


