/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.assignmentoop3;

/**
 *
 * @author user
 */
public class VenueType {
    private String theme;

    public VenueType(String theme) {
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return "VenueType{" + "theme=" + theme + '}';
    } 
}
