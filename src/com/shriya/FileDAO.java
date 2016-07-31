/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shriya;

import com.shriya.entity.FileHandling;
import com.shriya.entity.dao.ProductDAO;
import com.shriya.entity.dao.impl.ProductDAOImpl;
import java.util.Scanner;

/**
 *
 * @author shneha
 */
public class FileDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductDAO productDAO =new  ProductDAOImpl();
        Scanner input=new Scanner(System.in);
        FileOperations fileOp=new FileOperations();
               FileHandling fileHandling=new FileHandling(input,fileOp);

     
         ProductController pc= new ProductController(input,productDAO,fileHandling);
        
         pc.process();
        
        
        
    }
    
}
