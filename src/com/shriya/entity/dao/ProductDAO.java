/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shriya.entity.dao;

import com.shriya.entity.Product;
import java.util.List;

/**
 *
 * @author shneha
 */
public interface ProductDAO {
     boolean insert(Product c);
    
     boolean delete(int id);
   Product getById(int id);
 List<Product>getAll();
    
    
    
    
}
