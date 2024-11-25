/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentoop3;



/**
 *
 * @author user
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author kx
 */
import java.util.Date;
import java.util.List;

public class Member extends User {

    private String memberID = "";
    private Date dateRegistered;
    private static int memberCount = 1;

    //CONTRUCTOR
    public Member(String name, char gender, String email, String telNo, String userName, String password) {
        super(name, gender, email, telNo, userName, password);
        this.memberID = "M00" + memberCount;
        memberCount++;
        this.dateRegistered = new Date();
    }

    public Member() {
    }

    //GETTER
    public String getMemberID() {
        return memberID;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    //SETTER
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public void memberPage(List<Booking> booking, String userID, List<Payment> payments, List<Venue> venues) {
        Profile profile = new Profile(this); // Pass 'this' to create a Profile instance for the current admin
        Scanner input = new Scanner(System.in);
        int choice3;
 do {
        System.out.println();
        System.out.printf("%30s %10s\n", "", "**************************************************************************************************************************************");
        System.out.printf("%60s %50s\n", "", "Welcome, Dear Member " + getUsername() + "!");
        System.out.printf("%60s %45s\n", "", "Member Page");
        System.out.printf("%30s %50s\n", "", "**************************************************************************************************************************************");
       
            System.out.println();
            System.out.printf("%40s %-10s\n", "", "1. Profile");
            System.out.printf("%40s %-10s\n", "", "2. Booking");
            System.out.printf("%40s %-10s\n", "", "3. Payment");
            System.out.printf("%40s %-10s\n", "", "4. Quit");
            System.out.println();

            System.out.printf("%40s %-10s", "", "Enter your choice: ");
            choice3 = input.nextInt();
            input.nextLine();
            switch (choice3) {
                case 1:
                    profile.MemberProfile();
                    break;
                case 2:
                    Booking.MakeBooking(booking, userID, payments, venues);
                    break;
                case 3:
                    Payment.MakePayment(booking, userID, payments);
                    break;
                case 4:
                    break;
                default:
                    System.out.printf("%40s %-10s\n", "", "Invalid choice. Please enter yout choice again: ");
                    break;
            }
        } while (choice3 != 2 && choice3 != 3 && choice3 != 4);
    }

}
