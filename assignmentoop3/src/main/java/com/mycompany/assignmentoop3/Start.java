/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.assignmentoop3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */


public class Start {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int choice;
      List<Booking> booking = new ArrayList();
      List<Payment> payments = new ArrayList();
      List<Venue> venues = new ArrayList();
      Payment payment = new Payment();
      ForImplementTitle insertTitle = new ForImplementTitle();
      Venue[] venueArr = new Venue[venues.size()];
      
       
       do{  
            insertTitle.SetTitle();  //implements
            System.out.printf("%40s %-10s\n","","1. Login");
            System.out.printf("%40s %-10s\n","","2. Register as a member");
            System.out.printf("%40s %-10s\n","","3. Register as an admin");
            System.out.printf("%40s %-10s\n","","4. Quit");
            System.out.println();
            System.out.printf("%40s %-10s","","Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
             switch (choice) {
             case 1:
                Login.loginPage(booking,payments,venues,Venue.currentVenueArr(venues));
            break;
             case 2:
                 Registration.registerMemberPage();
                 break;
             case 3:
                 Registration.registerAdminPage();
                 break;
             case 4:
                 System.out.println(); 
                 System.out.printf("%40s %-10s","","Thank you! Don't forget to explore our party planning tips for your next celebration.");
                 break;
             default:
                  System.out.printf("%40s %-10s","","Invalid choice. Please try again.");
                 }
                 System.out.println(); 
                 }while(choice!=4);
}
}