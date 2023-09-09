package controller;

import service.CartManage;

import java.util.Scanner;

public class MenuCart {
    public void menuCart(Scanner scanner, CartManage cartManage) {
        int choice;
        do {
            System.out.println("MENU:");
            System.out.println("1. Add product to cart.");
            System.out.println("2. Display cart.");
            System.out.println("3. Display bills.");
            System.out.println("4. Payment.");
            System.out.println("0. Exist.");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    cartManage.addProductToCart();
                    break;
                case 2:
                    cartManage.disPlay();
                    break;
                case 3:
//
                case 4:
                    cartManage.payment();
            }
        } while (choice != 0);
    }
}
