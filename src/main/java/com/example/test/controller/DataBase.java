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

    /**
     * Добавление элемента в конец бд
     *
     * @param contributor {Contributor}  — новый объект
     * @Returns {boolean}
     */
    public boolean add(Contributor contributor) {
        return contributors.add(contributor);
    }

    /**
     * Удаляем элемент из базы данных по индексу
     *
     * @param index {int}  — индекс элемента в бд
     * @Returns {boolean}
     */
    public boolean remove(int index) {
        Contributor contributor = contributors.get(index);
        return contributors.remove(contributor);
    }

    /**
     * Получаем элемент своего класса из базы данных по индексу
     *
     * @param index {int}  — индекс элемента в бд
     * @Returns {Contributor}
     */
    public Contributor getContributor(int index) {
        return contributors.get(index);
    }

    /**
     * Возвращаем бд в виде списка объектов
     *
     * @Returns {List<Contributor>}
     */
    public List<Contributor> getContributors() {
        return contributors;
    }

    /**
     * Выгружаем базу данных из вешнего файла
     */
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

    /**
     * Возвращаем элемент бд по указанному индеку в виде строки json
     *
     * @param index {int}  — индекс элемента в бд
     * @Returns {String}
     */
    public String databaseObjectToJsonString(int index) {
        Gson gson = new Gson();
        return gson.toJson(contributors.get(index));
    }

    /**
     * Загружаеем базу данных во внешний файл
     */
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

    /**
     * Возвращаем всю базу данных в виде строки json
     */
    public static String getStringDatabase() throws IOException {
        Path file = Paths.get("./src/main/resources/client-db.json");
        List<String> lines = Files.readAllLines(file);
        String json = "";
        for (int i = 0; i < lines.size(); i++) {
            json += lines.get(i);
        }
        return json;
    }

    /**
     * Очищаем список объектов
     */
    private void clear() {
        this.contributors.clear();
    }
}
