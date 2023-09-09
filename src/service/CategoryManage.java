package service;

import model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryManage {
    private List<Category> categories;
    private final Scanner scanner;
    Category category;

    public CategoryManage() {
        categories = new ArrayList<>();
        scanner = new Scanner(System.in);
        category = new Category();
    }

    public void changeIndexCategory() {
        Category.INDEX = categories.get(categories.size()-1).getId();
    }

    public void loadListCategory(List<String[]> categoryList) {
        for (String[] strings : categoryList) {
            String name = strings[1];
            String description = strings[2];
            Category category = new Category(name, description);
            categories.add(category);
        }
        if (!categories.isEmpty()) {
            changeIndexCategory();
        }


    }
    public void create() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter description of type: ");
        String description = scanner.nextLine();
        categories.add(new Category(name, description));
    }

    public Category findById() {
        System.out.println("Enter id by want: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    public Category findByOne(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }


    public void update() {
        Category category = findById();
        if (category != null) {
            System.out.println("Enter new name: ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                category.setName(name);
            }
            System.out.println("Enter new description: ");
            String description = scanner.nextLine();
            if (!description.isEmpty()) {
                category.setDescription(description);
            }
        } else {
            System.out.println("Not exist!!!");
        }
    }

    public void display() {
        for (Category category : categories) {
            System.out.println(category);
        }
    }


    public Category findByName(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }

    public List<Category> getCategories() {
        return categories;
    }
}


