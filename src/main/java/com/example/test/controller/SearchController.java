package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class SearchController {
    @GetMapping(value = "/search")
    public String searchClient(Model model) throws IOException {
        model.addAttribute("stringDb", DataBase.getStringDatabase());
        return "search";
    }
}
