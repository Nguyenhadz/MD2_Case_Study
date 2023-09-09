package service;

import model.Category;
import model.Product;

import java.util.*;

public class ProductManage {
    private List<Product> products;
    private final CategoryManage categoryManage;
    private final Scanner scanner;
    List<Category> categories;


    public ProductManage(CategoryManage categoryManage) {
        products = new ArrayList<>();
        scanner = new Scanner(System.in);
        categories = new ArrayList<>();
        this.categoryManage =categoryManage;
    }

    public void changeIndexProduct() {
        Product.INDEX = products.get(products.size() -1).getId();
    }

    public void loadListProduct(List<String[]> productList, CategoryManage categoryManage) {
        for (String[] string : productList) {
            String name = string[1];
            double price = Double.parseDouble(string[2]);
            int quantity = Integer.parseInt(string[3]);
            String description = string[4];
            int id = Integer.parseInt(string[5]);
            Category category = categoryManage.findByOne(id);
            Product product = new Product(name, price, quantity, description, category);
            products.add(product);
        }
        if (!products.isEmpty()) {
            changeIndexProduct();
        }

    }
    public void creat() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        categoryManage.display();
        Category category = categoryManage.findById();
        while (category == null) {
            category = categoryManage.findById();
        }
        products.add(new Product(name, price, quantity, description, category));
    }

    public Product findById() {
        System.out.println("Enter id you want: ");
        int id = Integer.parseInt((scanner.nextLine()));
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product findOne(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void update() {
        display();
        Product product = findById();
        if (product != null) {
            System.out.println("Enter new name: ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                product.setName(name);
            }
            System.out.println("Enter new price: ");
            String stringPrice = scanner.nextLine();
            double price;
            if (stringPrice.isEmpty()) {
                price = product.getPrice();
            } else {
                price = Double.parseDouble(stringPrice);
            }
            product.setPrice(price);
            System.out.println("Enter new quantity: ");
            String stringQuantity = scanner.nextLine();
            int quantity;
            if (stringQuantity.isEmpty()) {
                quantity = product.getQuantity();
            } else {
                quantity = Integer.parseInt(stringQuantity);
            }
            product.setQuantity(quantity);
            System.out.println("Enter new description: ");
            String description = scanner.nextLine();
            if (!description.isEmpty()) {
                product.setDescription(description);
            }
            categoryManage.display();
            System.out.println("Enter new id category: ");
            String stringId = scanner.nextLine();
            int id;
            if (stringId.isEmpty()) {
                id = product.getCategory().getId();
            } else {
                id = Integer.parseInt(stringId);
            }
            Category category = categoryManage.findByOne(id);
            while (category == null) {
                System.out.println("Enter new id category: ");
                category = categoryManage.findById();
            }
            product.setCategory(category);
            System.out.println("Edit successfully!!!");
        } else {
            System.out.println("Not exist!!!");
        }
    }

    public void delete() {
        display();
        Product product = findById();
        if (product != null) {
            products.remove(product);
        } else {
            System.out.println("Not exist!!!");
        }
    }

    public void display() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void displayByName() {
        System.out.println("Enter name you want: ");
        String nameS = scanner.nextLine();
        boolean check = false;
        for (Product product : products) {
            if (product.getName().contains(nameS)) {
                System.out.println(product);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Not exist!!!");
        }
    }

    public List<Product> sortPriceAsc() {
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        return products;
    }

    public void sortPriceDesc() {
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o2.getPrice() - o1.getPrice());
            }
        });
    }

    public void displayByCategory(CategoryManage categoryManage) {
        categoryManage.display();
        Category category = categoryManage.findById();
        while (category == null) {
            category = categoryManage.findById();
        }
        boolean check = false;
        for (Product product : products) {
            if (product.getCategory().getId() == category.getId()) {
                System.out.println(product);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Not exist!!!");
        }
    }

    public void displayByPriceRange(){
        System.out.println("Enter price min: ");
        // chưa xử lý giá trị enter
        double priceMin = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter price max: ");
        double priceMax = Double.parseDouble(scanner.nextLine());
        boolean check = false;
        for (Product product : sortPriceAsc()) {
            if (product.getPrice() >= priceMin && product.getPrice() <= priceMax) {
                System.out.println(product);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Not exist!!!");
        }
    }

    public boolean checkExistProduct(int id) {
        boolean check = false;
        for (Product product : products) {
            if (product.getId() == id) {
                check = true;
                break;
            }
        }
        return check;
    }

    public List<Product> getProducts() {
        return products;
    }

}
