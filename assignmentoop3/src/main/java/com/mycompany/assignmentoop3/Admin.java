/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author user
 */
package com.mycompany.assignmentoop3;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Admin extends User{
    private static int adminCount = 1;
    private String adminID;
    private Date dateEmployed;
    private List<Booking> bookingList;
    private boolean firstLogin;
    
    public Admin(String name, char gender, String email, String telNo, String userName, String password) {
        super(name, gender, email, telNo, userName, password);
        this.adminID = "A00" + adminCount;
        adminCount++;
        this.dateEmployed = new Date();
        this.firstLogin = true;
    }

    //GETTER
    public static int getAdminCount() {
        return adminCount;
    }
    public String getAdminID() {
        return adminID;
    }
    public Date getDateEmployed() {
        return dateEmployed;
    }
    public boolean isFirstLogin() {
    return firstLogin;
    }
      
    //SETTER
    public static void setAdminCount(int adminCount) {
        Admin.adminCount = adminCount;
    }
    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }
    public void setDateEmployed(Date dateEmployed) {
        this.dateEmployed = dateEmployed;
    }
 
    
    public void adminPage2(List<Booking> bookings, List<Venue> venues,Venue[] venueArr){
    Profile profile = new Profile(this); // Pass 'this' to create a Profile instance for the current admin
    Scanner input = new Scanner(System.in);
    int choice2;
    do{
        System.out.printf("%30s %50s\n\n","","**************************************************************************************************************************************");
        System.out.printf("%60s %50s\n","","Good Day, Dear Admin "+getUsername()+"!");
        System.out.printf("%60s %45s\n","","Admin Page");
        System.out.printf("%30s %50s\n","","**************************************************************************************************************************************");
        System.out.println();
        System.out.println();
        System.out.printf("%40s %-10s\n","","1. Profile");
        System.out.printf("%40s %-10s\n","","2. Venue Menu");
        System.out.printf("%40s %-10s\n","","3. Monitoring of Booking Venue Status");
        System.out.printf("%40s %-10s\n","","4. Report");
        System.out.printf("%40s %-10s\n","","5. Quit");
        System.out.println();
        System.out.printf("%40s %-10s","","Enter your choice: ");
        choice2 = input.nextInt();
        input.nextLine();
        switch (choice2) {
            case 1:
                profile.AdminProfile();
                break;
            case 2:
                venueMenu(venues);
                break;
            case 3:
                Monitoring monitoring = new Monitoring(bookings, venueArr);
                monitoring.monitoringPage(venues);
                break;
            case 4:
                Report.report(bookings);
                break;
            case 5 :
                break;
            default:     
                System.out.printf("%40s %-10s\n","","3. Invalid choice"); break; 
        }
    }while(choice2 != 5);
    }     
    
    
    
    
    public static void venueMenu(List<Venue> venues){
        Scanner input = new Scanner(System.in);
        int choice;
        do{
            System.out.printf("%40s %-10s\n","","1. Pre-set venue");
            System.out.printf("%40s %-10s\n","","2. Create New Venue");
            System.out.printf("%40s %-10s\n","","3. Edit Existing Venue");
            System.out.printf("%40s %-10s\n","","4. Delete Existing Venue");
            System.out.printf("%40s %-10s\n","","5. Display Venue");
            System.out.printf("%40s %-10s\n","","6. Quit");
            System.out.printf("%40s %-10s","","Enter Your Choice: ");
            choice = input.nextInt();
            switch(choice){
                case 1:
                    Venue.setDefaultVenues(venues); 
                    break;
                case 2:
                    Venue.createVenue(venues); 
                    break;
                case 3:
                    Venue.editVenue(venues);
                    break;
                case 4:
                    Venue.deleteVenues(venues);
                    break;
                case 5:
                   Venue.displayVenue(venues);
                   break;
                case 6:
                    System.out.printf("%40s %-10s\n","","Quit....");
                    break;
                default:     
                    System.out.printf("%40s %-10s","","Invalid choice"); break;
            }
        }while(choice != 6);
    }
    
}
