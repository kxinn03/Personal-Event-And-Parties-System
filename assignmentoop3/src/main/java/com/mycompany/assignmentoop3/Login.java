/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentoop3;


import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Login {

    private static boolean isAdminLoggedIn = false;

    public static void loginPage(List<Booking> booking, List<Payment> payments, List<Venue> venues, Venue[] venueArr) {
        Scanner input = new Scanner(System.in);
        Member member = new Member();
        String newPassword;

        System.out.printf("%30s %50s\n", "", "------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%60s %50s\n", "", "Login");
        System.out.printf("%80s %45s\n", "", "Please enter your username & password");
        System.out.printf("%30s %50s\n", "", "------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.printf("%40s %-10s", "", "Username: ");
        String username = input.nextLine();
        System.out.printf("%40s %-10s", "", "Password: ");
        String password = input.nextLine();

        // Check if the user is an admin
        if (adminLogin(username, password)) {
            isAdminLoggedIn = true;
            Admin loggedInAdmin = getLoggedInAdmin(username);
            if (loggedInAdmin != null) {
                if (loggedInAdmin.isFirstLogin() && loggedInAdmin.getPassword().equals("admin123")) {
                    System.out.println();
                    System.out.printf("%40s %-10s", "", "Welcome, admin! You required to change your password.\n");
                    System.out.printf("%40s %-10s", "", "Enter a new password: ");
                    newPassword = input.nextLine();
                    loggedInAdmin.setPassword(newPassword);
                    System.out.printf("%40s %-10s", "", "Password changed successfully!\n");
                }
                //check the entered password against the updated password.
                System.out.println();
                System.out.printf("%40s %-10s", "", "Admin login successful!\n");
                loggedInAdmin.adminPage2(booking, venues, venueArr);
            } else {
                System.out.printf("%40s %-10s", "", "Invalid password. Please try again.");
            }

        } else {
            Member loggedInMember = memberLogin(username, password);
            if (loggedInMember != null) {
                String userID = loggedInMember.getMemberID();
                System.out.println();
                System.out.printf("%40s %-10s", "", "Member login successful!");
                loggedInMember.memberPage(booking, userID, payments, venues);
            } else {
                System.out.printf("%40s %-10s", "", "Invalid username or password. Please try again.");
            }
        }
    }

    private static boolean adminLogin(String username, String password) {
        for (Admin admin : Registration.getAdmin()) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private static Admin getLoggedInAdmin(String username) {
        for (Admin admin : Registration.getAdmin()) {
            if (admin.getUsername().equals(username)) {
                return admin;
            }
        }
        return null;
    }

    private static Member memberLogin(String username, String password) {
        for (Member member : Registration.getMembers()) {
            if (member.getUsername().equals(username) && member.getPassword().equals(password)) {
                return member;
            }
        }
        return null;
    }
}
