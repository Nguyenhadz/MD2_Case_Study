package controller;

import model.Product;
import service.CartManage;
import service.CategoryManage;
import service.ProductManage;
import service.ReadWriteFile;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private CategoryManage categoryManage;
    private ProductManage productManage;
    private CartManage cartManage;
    private MenuCategory menuCategory;
    private MenuProduct menuProduct;
    private MenuCart menuCart;
    private  ReadWriteFile readWriteFile;


    public Menu() {
        scanner = new Scanner(System.in);
        categoryManage = new CategoryManage();
        productManage = new ProductManage(categoryManage);
        cartManage = new CartManage(productManage);
        menuCategory = new MenuCategory();
        menuProduct = new MenuProduct();
        menuCart = new MenuCart();
        readWriteFile = new ReadWriteFile();
        categoryManage.loadListCategory(readWriteFile.readFile("src/fileDB/CategoryFile"));
        productManage.loadListProduct(readWriteFile.readFile("src/fileDB/ProductFile"), categoryManage);

    }


    public void menu() {
        int choice;

        do {
            System.out.println("MENU");
            System.out.println("1. Menu product");
            System.out.println("2. Menu category");
            System.out.println("3. Menu cart");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuProduct.menuProduct(scanner, productManage, categoryManage);
                    break;
                case 2:
                    menuCategory.menuCategory(scanner, categoryManage);
                    break;
                case 3:
                    menuCart.menuCart(scanner, cartManage);
                    break;
                case 0:
                    readWriteFile.writeFile(productManage.getProducts(), categoryManage.getCategories());
                    System.exit(0);
            }
        } while (true);
    }
}
