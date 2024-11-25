/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentoop3;

/**
 *
 * @author user
 */
public class Cuisine {
    private String cuisineName;
    private static int quantity;
    private static double PricePerPerson = 50.00;

    public Cuisine(String cuisineName, int quantity) {
        this.cuisineName = cuisineName;
        this.quantity = quantity;
    }
    public Cuisine() {
    }
    

    public double getTotalPrice() {
        return quantity * PricePerPerson;
    }

    //SETTER
    public static void setQuantity(int quantity) {
        Cuisine.quantity = quantity;
    }
    
    
    
    
    // do cuisine thing

    @Override
    public String toString() {
        String strPrice = String.format("%.2f", getTotalPrice());
        return "Cuisine{" + "cuisineName=" + cuisineName + ", quantity=" + quantity + ", totalPrice=RM" + strPrice + '}';
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public int getQuantity() {
        return quantity;
    }
}