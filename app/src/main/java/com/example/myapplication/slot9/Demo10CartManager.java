package com.example.myapplication.slot9;

import java.util.ArrayList;
import java.util.List;

public class Demo10CartManager {
    private static Demo10CartManager instance;
    private List<Product91> cartItems;
    Demo10CartManager(){
        cartItems = new ArrayList<>();
    }

    public static synchronized Demo10CartManager getInstance(){
        if(instance==null){
            instance=new Demo10CartManager();
        }
        return instance;
    }
    public void addProductToCart(Product91 product){
        cartItems.add(product);
    }
    public List<Product91> getCartItem(){
        return cartItems;
    }
}
