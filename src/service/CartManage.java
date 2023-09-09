package service;

import model.Cart;
import model.CartDetail;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartManage {
    private ProductManage productManage;
    private Scanner scanner;
    private Cart card;
    private List<Cart> bills;
    ReadWriteFile readWriteFile;

    public CartManage(ProductManage productManage) {
        scanner = new Scanner(System.in);
        this.productManage = productManage;
        bills = new ArrayList<>();
        readWriteFile  = new ReadWriteFile();
    }

    public void changeIndex() {
        Cart.INDEX = bills.get(bills.size()-1).getId();
    }

    public void addProductToCart() {
        productManage.display();
        System.out.println("Enter id product you want to buy: ");
        int id = Integer.parseInt(scanner.nextLine());
        while (!productManage.checkExistProduct(id)) {
            System.out.println("Not exist! Enter id product you want to buy: ");
            id = Integer.parseInt(scanner.nextLine());
        }
        Product product = productManage.findOne(id);
        System.out.println("Enter quantity you want to buy: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        while (quantity <= 0 || quantity >= product.getQuantity()) {
            System.out.println("Could not provide the quantity you requested, re-enter");
            quantity = Integer.parseInt(scanner.nextLine());
        }
        if (card == null) {
            card = new Cart();
            CartDetail cartDetail = new CartDetail(product, quantity);
            card.getCartDetails().add(cartDetail);
            card.setTotal(product.getPrice()*quantity);
        } else {
            boolean check = false;
            for (CartDetail cartDetail : card.getCartDetails()) {
                if (cartDetail.getProduct().getId() == product.getId()) {
                    cartDetail.setQuantity(cartDetail.getQuantity() + quantity);
                    check = true;
                }
            }
            if (!check) {
                CartDetail cartDetail = new CartDetail(product, quantity);
                card.getCartDetails().add(cartDetail);
            }

            double money = 0;
            for (CartDetail cartDetail : card.getCartDetails()) {
                money += cartDetail.getProduct().getQuantity()* cartDetail.getProduct().getQuantity();
            }
        }
    }

    public void payment() {
        if (card != null) {
            card.setStatus(true);
            bills.add(card);
            card = null;
        } else {
            System.out.println("Not exist cart!!!");
        }
    }

    public void displayBill() {
        for (Cart cart : bills) {
            System.out.println(cart.getId());
            for (CartDetail cartDetail : cart.getCartDetails()) {
                System.out.println(cartDetail);
            }
            System.out.println("Total money: " + cart.getTotal());
            System.out.println("---------------------------");
        }
    }

    public void disPlay() {
        if (card != null) {
            for (CartDetail cartDetail : card.getCartDetails()) {
                System.out.println(cartDetail);
            }
        } else {
            System.out.println("Not exist product in cart!!!");
        }
    }

//    public List<Cart> getCart() {
//        return 1;
//    }

}
