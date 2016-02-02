//File Piza
//Assignment #: 3
//Name: Michael Pedersen, Gabriel Lima,praveenkumar Sangalad

package com.github.baocin.inclass03_pizzastore;

import java.util.ArrayList;

/**
 * Created by aoi on 2/1/16.
 */
public class Pizza {

    public ArrayList<String> toppings;

    private double basePrice;
    private double toppingsPrice;
    private boolean isDelivery;
    private double deliveryPrice;
    private int toppingsCount;

    private double totalPrice;

    Pizza () {

        toppings        = new ArrayList<String>();

        basePrice       = 6.5;
        deliveryPrice   = 4.0;

        isDelivery      = false;
        toppingsPrice   = 0;
        totalPrice      = 0;
        toppingsCount   = 0;
    }

    public ArrayList<String> getToppings () {
        return toppings;
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public void clearToppings() {
        toppings.clear();
    }
    public double getBasePrice() {
        return basePrice;
    }

    public double getToppingsPrice() {
        toppingsPrice = getToppingsCount() * 1.5;
        return toppingsPrice;
    }

    public boolean isDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(boolean isDelivery) {
        this.isDelivery = isDelivery;
    }

    public double getTotalPrice() {

        if (isDelivery()){
            totalPrice = getToppingsPrice() + getBasePrice() + deliveryPrice;
        }
        else {
            totalPrice = getToppingsPrice() + getBasePrice();
        }

        return totalPrice;
    }

    public int getToppingsCount() {
        toppingsCount = toppings.size();
        return toppingsCount;
    }
}
