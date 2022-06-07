package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

/**
 * Возвращаем страницу поиска, вместе с бд в строковом виде
 */
@Controller
public class SearchController {
    @GetMapping(value = "/search")
    public String searchClient(Model model) throws IOException {
        model.addAttribute("stringDb", DataBase.getStringDatabase());
        return "search";
    }
}
