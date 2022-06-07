package com.example.test.controller;

import org.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContributorInfoController {
    @GetMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public String showCustomerInfo(@RequestParam(required = false, defaultValue = "-1") String id, Model model) throws JSONException {
        DataBase contributors = new DataBase();
        contributors.load();
        if ((Integer.parseInt(id) < 0) || (Integer.parseInt(id) >= contributors.getContributors().size())) {
            return "error";
        } else {
            String dbObject = contributors.databaseObjectToJsonString(Integer.parseInt(id));
            model.addAttribute("dbObject", dbObject);
            return "customer";
        }
    }
}
