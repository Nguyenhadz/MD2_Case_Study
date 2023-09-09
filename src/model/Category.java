package model;

import java.io.Serializable;

public class Category implements Serializable {
    private static long serialUID = 123456789;
    public static int INDEX = 0;
    private int id;
    private String name;
    private String description;

    public Category(){}

    public Category(String name, String description) {
        this.id = ++INDEX;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
