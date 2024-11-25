/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentoop3;



/**
 *
 * @author user
 */
import java.util.Scanner;

public class Profile extends UserAdminProfile{
//    User user = new User();
    public Profile(User user) {
        this.user = user;
    }
    public Profile() {
    }
    
    public void editProfile() {
        Scanner input = new Scanner(System.in);
        char confirmEdit;

        System.out.println();
        System.out.printf("%40s %-10s\n","","1. Password");
        System.out.printf("%40s %-10s\n","","2. Email");
        System.out.printf("%40s %-10s\n","","3. Telephone Number");
        System.out.println();
        System.out.printf("%40s %-10s","","Select an option to edit: ");
        int option = input.nextInt();
        while(option != 1 && option != 2 && option != 3){
            System.out.printf("%40s %-10s","","Invalid Option. Please Enter Again: ");
            option = input.nextInt();
        }
        input.nextLine(); // Clear the newline character in the input buffer

        switch (option) {
            case 1:
                System.out.println();
                System.out.printf("%40s %-10s","","Enter a new password: ");
                String newPassword = input.nextLine();
                System.out.printf("%40s %-10s","","Are you sure to change password? (Y/N): ");
                confirmEdit = input.next().charAt(0);
                while(confirmEdit != 'y' && confirmEdit != 'Y' && confirmEdit != 'N' && confirmEdit != 'n'){
                    System.out.printf("%40s %-10s","","Invalid Choice. Please Enter Again: ");
                    confirmEdit = input.nextLine().charAt(0);
                }
                if (confirmEdit == 'y' || confirmEdit == 'Y') {
                user.setPassword(newPassword);
                System.out.println();
                System.out.printf("%40s %-10s","","Password updated successfully!"); 
                System.out.println();
                }
                else{
                System.out.println();
                System.out.printf("%40s %-10s","","Edited cancelled!"); 
                System.out.println();
                }
                break;
            case 2:
                System.out.println();
                System.out.printf("%40s %-10s","","Enter a new email (E.g.123@gmail.com): ");
                String newEmail = input.nextLine();
                while (!newEmail.contains("@")) {
                    System.out.println();
                    System.out.printf("%40s %-10s","","Invalid email! Please enter a valid email address.");
                    System.out.println();
                    System.out.printf("%40s %-10s","","Email (E.g.123@gmail.com): ");
                    newEmail = input.nextLine();
                }
                System.out.printf("%40s %-10s","","Are you sure to change email? (Y/N): ");
                confirmEdit = input.next().charAt(0);
                while(confirmEdit != 'y' && confirmEdit != 'Y' && confirmEdit != 'N' && confirmEdit != 'n'){
                    System.out.printf("%40s %-10s","","Invalid Choice. Please Enter Again: ");
                    confirmEdit = input.nextLine().charAt(0);
                }
                if (confirmEdit == 'y' || confirmEdit == 'Y') {
                user.setEmail(newEmail);
                System.out.println();
                System.out.printf("%40s %-10s","","Email updated successfully!");
                System.out.println();
                }
                else{
                System.out.println();
                System.out.printf("%40s %-10s","","Edit cancelled!");
                System.out.println();
                }
                break;
            case 3:
                System.out.println();
                System.out.printf("%40s %-10s","","Enter a new telephone number (xxx-xxx-xxxx or xxx-xxxx-xxxx): ");
                String newTelNo = input.nextLine();
                while (!newTelNo.matches("\\d{3}-\\d{3}-\\d{4}") && !newTelNo.matches("\\d{3}-\\d{4}-\\d{4}")) {
                    System.out.println();
                    System.out.printf("%40s %-10s","","Invalid telephone number! Please enter a valid telephone number (xxx-xxx-xxxx or xxx-xxxx-xxxx).");
                    System.out.println();
                    System.out.printf("%40s %-10s","","Telephone number (xxx-xxx-xxxx or xxx-xxxx-xxxx): ");
                    newTelNo = input.nextLine();
                }
                System.out.printf("%40s %-10s","","Are you sure to change telephone number? (Y/N): ");
                confirmEdit = input.next().charAt(0);
                while(confirmEdit != 'y' && confirmEdit != 'Y' && confirmEdit != 'N' && confirmEdit != 'n'){
                    System.out.printf("%40s %-10s","","Invalid Choice. Please Enter Again: ");
                    confirmEdit = input.nextLine().charAt(0);
                }
                if (confirmEdit == 'y' || confirmEdit == 'Y') {
                user.setTelNo(newTelNo);
                System.out.println();
                System.out.printf("%40s %-10s\n","","Telephone number updated successfully!"); 
                System.out.println();
                }
                else {
                System.out.println();
                System.out.printf("%40s %-10s\n","","Edit cancelled!"); 
                System.out.println();
                }
                break;
            default:
                System.out.printf("%40s %-10s\n","","Invalid option.");
                break;
        }
    }
    public void AdminProfile(){
        Scanner input = new Scanner(System.in);
        if (user instanceof Admin) {
            System.out.printf("%97s %-10s\n","","Profile");
            System.out.printf("%70s %-10s\n","","===============================================================");
            System.out.printf("%75s %-20s %30s \n","","Username          | " , user.getUsername());
            System.out.printf("%75s %-20s %30s\n","","Password          |" , user.getPassword());
            Admin admin = (Admin) user;
            System.out.printf("%75s %-20s %30s \n","","Admin ID          |" , admin.getAdminID());
            System.out.printf("%75s %-20s %30s \n","","Date Registered   |" , admin.getDateEmployed());
            System.out.printf("%75s %-20s %30s \n","","Name              |" , user.getName());
            char gender = user.getGender();
            String genderString = (gender == 'M' || gender == 'm') ? "Male" : "Female";
            System.out.printf("%75s %-20s %30s \n","","Gender            |", genderString);
            System.out.printf("%75s %-20s %30s \n","","Email             |" , user.getEmail());
            System.out.printf("%75s %-20s %30s \n","","Telephone Number  |" ,user. getTelNo());}
            System.out.printf("%70s %-10s\n","","===============================================================");
            System.out.println();
       System.out.printf("%40s %-10s", "", "Do you want to edit your profile? (Y/N):");
char choice = input.nextLine().charAt(0);
while (choice != 'y' && choice != 'Y' && choice != 'N' && choice != 'n') {
    System.out.printf("%40s %-10s", "", "Invalid Choice. Please Enter Again: ");
    choice = input.nextLine().charAt(0);
}

if (choice == 'y' || choice == 'Y') {
    editProfile();
}

    }

    public void MemberProfile(){
        Scanner input = new Scanner(System.in);
        if (user instanceof Member) {
            Member member =  (Member) user;

        System.out.printf("%97s %-10s\n","","Profile");
        System.out.printf("%70s %-10s\n","","===============================================================");
        System.out.printf("%75s %-20s %30s \n","","Username          | " , user.getUsername());
        System.out.printf("%75s %-20s %30s\n","","Password          |" , user.getPassword());
        System.out.printf("%75s %-20s %30s \n","","Member ID         |" , member.getMemberID());
        System.out.printf("%75s %-20s %30s \n","","Date Registered   |" , member.getDateRegistered());
        System.out.printf("%75s %-20s %30s \n","","Name              |" , user.getName());
        char gender = user.getGender();
        String genderString = (gender == 'M' || gender == 'm') ? "Male" : "Female";
        System.out.printf("%75s %-20s %30s \n","","Gender            |", genderString);
        System.out.printf("%75s %-20s %30s \n","","Email             |" , user.getEmail());
        System.out.printf("%75s %-20s %30s \n","","Telephone Number  |" , user.getTelNo());}
        System.out.printf("%70s %-10s\n","","===============================================================");
        System.out.println();
System.out.printf("%40s %-10s", "", "Do you want to edit your profile? (Y/N):");
char choice = input.nextLine().charAt(0);
while (choice != 'y' && choice != 'Y' && choice != 'N' && choice != 'n') {
    System.out.printf("%40s %-10s", "", "Invalid Choice. Please Enter Again: ");
    choice = input.nextLine().charAt(0);
}

if (choice == 'y' || choice == 'Y') {
    editProfile();
}
    }
}