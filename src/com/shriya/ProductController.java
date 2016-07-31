/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shriya;

import com.shriya.entity.FileHandling;
import com.shriya.entity.Product;
import com.shriya.entity.dao.ProductDAO;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shneha
 */
public class ProductController {

    private Scanner input;
    ProductDAO ProductDAO;
 FileHandling FileHandling ;

    public ProductController(Scanner input, ProductDAO ProductDAO, FileHandling FileHandling) {
        this.input = input;
        this.ProductDAO = ProductDAO;
        this.FileHandling = FileHandling;
    }

    

    private void menu() {
        System.out.println("1.Add product:");

        System.out.println("2.Delete product:");
        System.out.println("3.Get by id:");
        System.out.println("4.Dispaly All product:");
        System.out.println("5.file handling:");
            System.out.println("6.write to file:");
        System.out.println("7.Exit:");
        System.out.println("enter your choice[1-6]:");
    }

    public void add() {

        System.out.println("Add a product:");
        Product c = new Product();
        System.out.println("Enter ID:");
        c.setId(input.nextInt());
        System.out.println("Enter  Product Name:");
        c.setName(input.next());
        System.out.println("Enter  Product price :");
        c.setPrice(input.nextDouble());
        System.out.println("Enter Description:");
        c.setDescription(input.next());
        System.out.println("Enter Status:");
        c.setStatus(input.nextBoolean());
        ProductDAO.insert(c);

    }

    public void delete() {

        System.out.println("Deleting product:");
        System.out.println("Enter ID:");
        int a = input.nextInt();

        ProductDAO.getAll().forEach(c -> {
            if (c != null && c.getId() == a) {
                ProductDAO.delete(a);
            }
        });

    }

    public void getById() {

        System.out.println("search product");
        System.out.println("Enter ID:");
        int a = input.nextInt();

        ProductDAO.getAll().forEach(c -> {
            if (c != null && c.getId() == a) {
                System.out.println("ID:" + c.getId());
                System.out.println("Product Name:" + c.getName());

                System.out.println("Description:" + c.getDescription());
                System.out.println("Status:" + c.isStatus());
                System.out.println("Product Price:" + c.getPrice());

            }
        });

    }

    public void showall() {

        ProductDAO.getAll().forEach(c -> {

            System.out.println("ID:" + c.getId());
            System.out.println("Product Name:" + c.getName());

            System.out.println("Description:" + c.getDescription());
            System.out.println("Status:" + c.isStatus());
            System.out.println("Product Price:" + c.getPrice());

        });

    }
    public void writeToFile() throws IOException{
        FileWriter writer = new FileWriter("c:/users/Shneha/desktop/first.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            ProductDAO.getAll().forEach(c -> {
                try {
                    bufferedWriter.write(c.getId()+" "+c.getName()+" "+c.getDescription()+" "+c.getPrice()+" "+c.isStatus());
                    bufferedWriter.newLine();
                    
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                
                
                
            });
        }
        System.out.println("Write successful.");
    }
   

    public void process() throws IOException {

        while (true) {
            menu();
            switch (input.nextInt()) {

                case 1:
                    add();

                    break;

                case 2:
                    delete();

                    break;

                case 3:

                    getById();

                    break;

                case 4:
                    showall();
                    break;
                case 5:
                   FileHandling.operation();
                    break;
                case 6:
                    writeToFile();
                    break;
                case 7:

                    System.out.println("Do You want to continue[y/n]:");
                    if (input.next().equalsIgnoreCase("n")) {
                        System.exit(0);
                    }

            }

        }
    }

}
