package com.example.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Добавляем объект в базу банных по запросу
 */
@RestController
@RequestMapping("/add")
public class AddConfirmController {
    @PostMapping("/added")
    public String addConfirmContributor(@RequestBody String info) throws JsonProcessingException {
        StringIndexObject obj = new ObjectMapper().readValue(info, StringIndexObject.class);
        DataBase contributors = new DataBase();
        contributors.load();

        contributors.add(new Contributor(obj.getName(), obj.getLastName(), obj.getPatronymic(), obj.getCity(),
                obj.getStreet(), obj.getHouseNumber(), obj.getApartmentNumber(), obj.getDeposit(),
                obj.isAutoProlongation(), obj.getTerm(), obj.getContractNumber()));
        contributors.save();
        return info;
    }
}
