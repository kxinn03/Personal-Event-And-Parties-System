/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentoop3;
/**
 *
 * @author user
 */
public class CuisineType {

    private String cuisine;

    public CuisineType(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getCuisine() {
        return cuisine;
    }

    @Override
    public String toString() {
        return "CuisineType{" + "cuisine=" + cuisine + '}';
    }

}
