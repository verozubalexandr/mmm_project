package com.example.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Удаление объекта с нужным индексом по запросу
 */
@RestController
@RequestMapping("/delete")
public class DeleteController {
    @PostMapping("/deleted")
    public String deleteContributor(@RequestBody String id) throws JsonProcessingException {
        StringIndex obj = new ObjectMapper().readValue(id, StringIndex.class);
        DataBase contributors = new DataBase();
        contributors.load();
        if (obj.getId() >= 0 && obj.getId() < contributors.getContributors().size()) {
            contributors.getContributors().remove(obj.getId());
            contributors.save();
        }
        return id;
    }
}