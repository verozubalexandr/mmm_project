package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * По запросу "/admin" возвращаем главную страницу управления базой данных
 */
@Controller
public class AdminIndexController {
    @RequestMapping(value = "/admin")
    public String greetingController() {
        return "index";
    }
}