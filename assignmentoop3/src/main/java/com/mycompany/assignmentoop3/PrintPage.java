/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentoop3;

/**
 *
 * @author user
 */

public class PrintPage {
     
   public static void monitoringOption(){
       System.out.printf("%40s %-10s\n","","1. Add Venue");
                             System.out.printf("%40s %-10s\n","","2. Edit Venue");
                             System.out.printf("%40s %-10s\n","","3. Delete Venue");
                             System.out.printf("%40s %-10s\n","","4. Quit");
                             System.out.println();
   }
   public static void printEquals(){
     System.out.printf("%70s %50s\n","","===========================================================");
   }
    public static void printEqualsLong(){
     System.out.printf("%70s %50s\n","","===================================================================================");
   }
   public static void printDash(){
     System.out.printf("%70s %50s\n","","----------------------------------------------------------------------");

   }
}