    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.mycompany.assignmentoop3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Registration {
    private static List<Member> members = new ArrayList<>();
    private static List<Admin> admins = new ArrayList<>();
    private static final String ADMIN_PASSWORD = "admin123";
    int memberCount = 1;

    public int getMemberCount() {
        return memberCount;
    }
    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public Registration() {
        
    }

   public static void registerMemberPage(){
        Scanner input = new Scanner(System.in);
        Registration registration = new Registration();
        char registerChoice;
        int memberAdd = 1;
        int passMemberCount;

        System.out.printf("%30s %50s\n","","------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%60s %50s\n","","Register as a member");
        System.out.printf("%70s %45s\n","","Please fill in your information");
        System.out.printf("%30s %50s\n","","------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.printf("%40s %-10s","","Name: ");
        String name = input.nextLine();
        System.out.printf("%40s %-10s","","Gender ('M' : Male | 'F' : Female): ");
        char gender = Character.toUpperCase(input.nextLine().charAt(0));
        
        while (gender != 'M' && gender != 'F') {               
            System.out.printf("%40s %-10s","","Invalid gender! Please enter 'M' for male or 'F' for female.");
            System.out.println();
            System.out.printf("%40s %-10s","","Gender ('M' or 'F'): ");
            gender = Character.toUpperCase(input.nextLine().charAt(0));
        }
                   
        System.out.printf("%40s %-10s","","Email (E.g.123@gmail.com): ");
        String email = input.nextLine();
            while (!email.contains("@")) {
                System.out.printf("%40s %-10s","","Invalid email! Please enter a valid email address.");
                System.out.println();
                System.out.printf("%40s %-10s","","Email (E.g.123@gmail.com): ");
                email = input.nextLine();
            }
        System.out.printf("%40s %-10s","","Telephone number (xxx-xxx-xxxx or xxx-xxxx-xxxx): ");
        String telNo = input.nextLine();
         // Check if the telephone number is valid
        while (!telNo.matches("\\d{3}-\\d{3}-\\d{4}") && !telNo.matches("\\d{3}-\\d{4}-\\d{4}")) {
            System.out.printf("%40s %-10s","","Invalid telephone number! Please enter a valid telephone number (xxx-xxx-xxxx or xxx-xxxx-xxxx).");
            System.out.println();
            System.out.printf("%40s %-10s","","Telephone number (xxx-xxx-xxxx or xxx-xxxx-xxxx): "); 
            telNo = input.nextLine();
        }
        System.out.println();
        System.out.printf("%40s %-10s","","Username: ");
        String username = input.nextLine();
        // Check if the username already exists
        // Check if the username already exists
        while (getUserByUsername(username) != null) {
            System.out.printf("%40s %-10s","","Username already exists! Please enter a different username.");
            System.out.println();
            System.out.printf("%40s %-10s", "", "Username: ");
            username = input.nextLine();
        }
        System.out.printf("%40s %-10s","","Password: ");
        String password = input.nextLine();
        
        
         do {
            System.out.printf("%40s %-10s","","Are you sure you want to register this account (Y/N): ");
            registerChoice = input.next().charAt(0);
            if (registerChoice != 'Y' && registerChoice != 'y' && registerChoice != 'N' && registerChoice != 'n') {
                System.out.printf("%40s %-10s\n", "", "Error: Please enter 'Y' or 'N'.");
            }
            if(registerChoice == 'Y'|| registerChoice == 'y'){
                Member member = new Member(name,gender,email,telNo,username,password);
                member.setName(name);
                member.setGender(gender);
                member.setEmail(email);
                member.setTelNo(telNo);
                member.setUsername(username);
                member.setPassword(password);
                System.out.println();            
                System.out.printf("%40s %-10s","","Member registered successfully!");
                System.out.println();
                passMemberCount = memberAdd++;
                registration.setMemberCount(passMemberCount);
               members.add(member);
            }else if(registerChoice == 'N' || registerChoice == 'n' ){
                System.out.println();
                System.out.printf("%40s %-10s","","Your register cancel");
                System.out.println();
            }

        } while (registerChoice != 'Y' && registerChoice != 'y' && registerChoice != 'N' && registerChoice != 'n');
        
    }                  
   
    public static void registerAdminPage(){
        Scanner input = new Scanner(System.in);
        char registerAdminChoice;
        
        System.out.printf("%30s %50s\n","","------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%60s %50s\n","","Register as an admin");
        System.out.printf("%65s %45s\n","","Please fill in your information & Enter correct password that given");
        System.out.printf("%30s %50s\n","","------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.printf("%40s %-10s","","Name: ");
        String name = input.nextLine();
        System.out.printf("%40s %-10s","","Gender ('M' : Male | 'F' : Female): ");
        char gender = Character.toUpperCase(input.nextLine().charAt(0));
        while (gender != 'M' && gender != 'F') {
            System.out.printf("%40s %-10s","","Invalid gender! Please enter 'M' for male or 'F' for female.");
            System.out.println();
            System.out.printf("%40s %-10s","","Gender ('M' or 'F'): ");
            gender = Character.toUpperCase(input.nextLine().charAt(0));
        }
        System.out.printf("%40s %-10s","","Email (E.g.123@gmail.com): ");
        String email = input.nextLine();
        while (!email.contains("@")) {
            System.out.printf("%40s %-10s","","Invalid email! Please enter a valid email address.");
            System.out.println();
            System.out.printf("%40s %-10s","","Email (E.g.123@gmail.com): ");
            email = input.nextLine();
        }
        System.out.printf("%40s %-10s","","Telephone number (xxx-xxx-xxxx or xxx-xxxx-xxxx): ");
        String telNo = input.nextLine();
        // Check if the telephone number is valid
        while (!telNo.matches("\\d{3}-\\d{3}-\\d{4}") && !telNo.matches("\\d{3}-\\d{4}-\\d{4}")) {
            System.out.printf("%40s %-10s","","Invalid telephone number! Please enter a valid telephone number (xxx-xxx-xxxx or xxx-xxxx-xxxx).");
            System.out.println();
            System.out.printf("%40s %-10s","","Telephone number (xxx-xxx-xxxx or xxx-xxxx-xxxx): ");
            telNo = input.nextLine();
        }                   
        System.out.println();
        System.out.printf("%40s %-10s","","Username: ");
        String username = input.nextLine();
        // Check if the username already exists
        while (getUserByUsername(username) != null) {
            System.out.printf("%40s %-10s","","Username already exists! Please enter a different username.");
            System.out.println();
            System.out.printf("%40s %-10s", "", "Username: ");
            username = input.nextLine();
        }
                
        System.out.printf("%40s %-10s","","Password: ");
        String password = input.nextLine();
                    
        // Check if the admin password is valid
        if (!password.equals(ADMIN_PASSWORD)) {
            System.out.println();
            System.out.printf("%40s %-10s","","Invalid admin password! Registration failed.");
           return;
        }
        do {
            System.out.printf("%40s %-10s","","Are you sure you want to register this account (Y/N): ");
            registerAdminChoice = input.next().charAt(0);
            if (registerAdminChoice != 'Y' && registerAdminChoice != 'y' && registerAdminChoice != 'N' && registerAdminChoice != 'n') {
                System.out.printf("%40s %-10s\n", "", "Error: Please enter 'Y' or 'N'.");
            }
            if(registerAdminChoice == 'Y'|| registerAdminChoice == 'y'){
                Admin admin = new Admin(name,gender,email,telNo,username,password);
                admin.setName(name);
                admin.setGender(gender);
                admin.setEmail(email);
                admin.setTelNo(telNo);
                admin.setUsername(username);
                admin.setPassword(password);
                admins.add(admin);
                System.out.println();
                System.out.printf("%40s %-10s","","Admin registered successfully!");
                System.out.println();
            }else if(registerAdminChoice == 'N' || registerAdminChoice == 'n' ){
                System.out.println();
                System.out.printf("%40s %-10s","","Your register cancel");
                System.out.println();
            }

        } while (registerAdminChoice != 'Y' && registerAdminChoice != 'y' && registerAdminChoice != 'N' && registerAdminChoice != 'n');
  
   }
    
     public static List<Member> getMembers() {
        return members;
    }
     
      public static List<Admin> getAdmin() {
        return admins;
    }
      
       private static User getUserByUsername(String username) {
        for (Member member : members) {
            if (member.getUsername().equals(username)) {
                return member;
            }
        }

        for (Admin admin : admins) {
            if (admin.getUsername().equals(username)) {
                return admin;
            }
        }

        return null;
    }
      
     
    
  
}