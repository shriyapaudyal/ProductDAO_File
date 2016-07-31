/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shriya.entity.dao.impl;

import com.shriya.entity.Product;
import com.shriya.entity.dao.ProductDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shneha
 */
public class ProductDAOImpl implements ProductDAO {

    private List<Product> productList = new ArrayList<>();

    @Override
    public boolean insert(Product c) {
        return productList.add(c);
    }

    @Override
    public boolean delete(int id) {

        Product c = getById(id);

        if (c != null) {
            return productList.remove(c);
        }

        return false;
    }

    @Override
    public Product getById(int id) {
        for (Product c : productList) {

            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

}
