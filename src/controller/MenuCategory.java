package controller;

import service.CategoryManage;

import java.util.Scanner;

public class MenuCategory {
    public void menuCategory(Scanner scanner, CategoryManage categoryManage) {
        int choice;
        do {
            System.out.println("MENU");
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Display all");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    categoryManage.create();
                    break;
                case 2:
                    categoryManage.update();
                    break;
                case 3:
                    categoryManage.display();
                    break;
            }
        } while (choice != 0);
    }
}
