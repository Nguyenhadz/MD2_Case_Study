package service;

import model.Cart;
import model.CartDetail;
import model.Category;
import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    private String fileName;

    public ReadWriteFile() {}

    public void writeFile(List<Product> products, List<Category> categories) {
        try {
            File fileProduct = new File("src/fileDB/ProductFile");
            BufferedWriter brProduct = new BufferedWriter(new FileWriter(fileProduct));
            for (Product item : products) {
                brProduct.write(item.getId() + "," + item.getName() + "," + item.getPrice() + "," + item.getQuantity() + "," + item.getDescription() + "," + item.getCategory().getId());
                brProduct.newLine();
            }
            brProduct.close();
            File fileCategory = new File("src/fileDB/CategoryFile");
            BufferedWriter brCategory = new BufferedWriter(new FileWriter(fileCategory));
            for (Category item : categories) {
                brCategory.write(item.getId() + "," + item.getName() + "," + item.getDescription());
                brCategory.newLine();
            }
            brCategory.close();
//            File fileBills = new File("src/fileDB/BillsFile");
//            BufferedWriter brBills = new BufferedWriter(new FileWriter(fileBills));
//            for (CartDetail item : cartDetails) {
//                brBills.write(item.getProduct().getId() + "," + item.getQuantity());
//            }
//            brBills.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> readFile(String fileName) {
        List<String[]> list = new ArrayList<>();
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line.split(","));
            }
        } catch (IOException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
        return list;
    }



}
