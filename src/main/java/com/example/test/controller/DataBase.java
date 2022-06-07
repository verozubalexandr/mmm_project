package com.example.test.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Contributor> contributors;

    public DataBase() {
        contributors = new ArrayList<Contributor>();
    }

    public boolean add(Contributor contributor) {
        return contributors.add(contributor);
    }

    public boolean remove(int index) {
        Contributor contributor = contributors.get(index);
        return contributors.remove(contributor);
    }

    public Contributor getContributor(int index) {
        return contributors.get(index);
    }

    public List<Contributor> getContributors() {
        return contributors;
    }

    public void load() {
        this.clear();

        try {
            Reader reader = Files.newBufferedReader(Paths.get("./src/main/resources/client-db.json"));
            this.contributors = new Gson().fromJson(reader, new TypeToken<List<Contributor>>() {
            }.getType());
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String databaseObjectToJsonString(int index) {
        Gson gson = new Gson();
        return gson.toJson(contributors.get(index));
    }

    public void save() {
        Gson gson = new GsonBuilder().create();
        JsonArray json = gson.toJsonTree(contributors).getAsJsonArray();
        try (FileWriter writer = new FileWriter("src/main/resources/client-db.json", false)) {
            writer.write(json.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String getStringDatabase() throws IOException {
        Path file = Paths.get("./src/main/resources/client-db.json");
        List<String> lines = Files.readAllLines(file);
        String json = "";
        for (int i = 0; i < lines.size(); i++) {
            json += lines.get(i);
        }
        return json;
    }

    private void clear() {
        this.contributors.clear();
    }
}
