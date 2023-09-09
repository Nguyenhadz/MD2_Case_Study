package controller;

import service.CategoryManage;
import service.ProductManage;

import java.util.Scanner;

public class MenuProduct {
    public void menuProduct(Scanner scanner, ProductManage productManage, CategoryManage categoryManage) {
        int choice;
        do {
            System.out.println("MENU");
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Display all");
            System.out.println("5. Display by category");
            System.out.println("6. Display by name");
            System.out.println("7. Sort by price asc");
            System.out.println("8. Sort by price desc");
            System.out.println("9. Display by price range");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManage.creat();
                    break;
                case 2:
                    productManage.update();
                    break;
                case 3:
                    productManage.delete();
                    break;
                case 4:
                    productManage.display();
                    break;
                case 5:
                    productManage.displayByCategory(categoryManage);
                    break;
                case 6:
                    productManage.displayByName();
                    break;
                case 7:
                    productManage.sortPriceAsc();
                    break;
                case 8:
                    productManage.sortPriceDesc();
                    break;
                case 9:
                    productManage.displayByPriceRange();
                    break;
            }
        } while (choice != 0);
    }

}
