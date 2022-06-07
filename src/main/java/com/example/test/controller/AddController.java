package com.example.test.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * По запросу "/add" возвращаем страницу для добавления нового объекта в бд
 */
@Controller
public class AddController {
    @GetMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String addContributor() {
        return "add";
    }
}
