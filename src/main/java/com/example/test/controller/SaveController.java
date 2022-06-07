package com.example.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/save")
public class SaveController {
    @PostMapping("/saved")
    public String saveContributor(@RequestBody String info) throws JSONException, JsonProcessingException {
        StringIndexObject obj = new ObjectMapper().readValue(info, StringIndexObject.class);
        DataBase contributors = new DataBase();
        contributors.load();

        if(obj.getId() >= 0 && obj.getId() < contributors.getContributors().size()) {
            contributors.getContributors().get(obj.getId()).setName(obj.getName());
            contributors.getContributors().get(obj.getId()).setLastName(obj.getLastName());
            contributors.getContributors().get(obj.getId()).setPatronymic(obj.getPatronymic());
            contributors.getContributors().get(obj.getId()).setCity(obj.getCity());
            contributors.getContributors().get(obj.getId()).setStreet(obj.getStreet());
            contributors.getContributors().get(obj.getId()).setHouseNumber(obj.getHouseNumber());
            contributors.getContributors().get(obj.getId()).setApartmentNumber(obj.getApartmentNumber());
            contributors.getContributors().get(obj.getId()).setAutoProlongation(obj.isAutoProlongation());
            contributors.getContributors().get(obj.getId()).setDeposit(obj.getDeposit());
            contributors.getContributors().get(obj.getId()).setTerm(obj.getTerm());
            contributors.getContributors().get(obj.getId()).setContractNumber(obj.getContractNumber());
            contributors.save();
        }
        return info;
    }
}
