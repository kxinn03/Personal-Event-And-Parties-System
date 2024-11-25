/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */package com.mycompany.assignmentoop3;


import java.util.List;
import java.util.Scanner;

public class Venue {
    private String venueName;
    private String status;
    private double pricing;
    private int capacity;
    private String action = "";

    public Venue() {
    }
    
    

    public Venue(String venueName, String status, double pricing, int capacity, String action) {
        this.venueName = venueName;
        this.status = status;
        this.pricing = pricing;
        this.capacity = capacity;
        this.action = action;
    }
    
    //Getter
    public String getVenueName() {
        return venueName;
    }
    public double getPricing() {
        return pricing;
    }
    public int getCapacity() {
        return capacity;
    }
    public String getStatus() {
        return status;
    }
    public String getAction() {
        return action;
    }

    
    //Setter
    public void setStatus(String status) {
        this.status = status;
    }
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
    public void setPricing(double pricing) {
        this.pricing = pricing;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setAction(String action) {
        this.action = action;
    }


    public static void createVenue(List<Venue> venues){
        Scanner input = new Scanner(System.in);
        char confirmAdd;
        String newAction ="";
        
        System.out.printf("%40s %-10s","","Enter new venueName : ");
        String newVenueName = input.nextLine();
        
        System.out.printf("%40s %-10s","","Enter status for the new venue : ");
        String newStatus = input.nextLine();
        
        System.out.printf("%40s %-10s","","Enter new venue pricing : ");
        double newPricing = input.nextDouble();
        
        System.out.printf("%40s %-10s","","Enter capacity for the new venue : ");
        int newCapacity = input.nextInt();
        
        
        if(newStatus.equals("Unavailable")){
             newAction ="Edited";
        }else if(newStatus.equals("Available")){
            newAction ="havenEdited";
        }
        venues.add(new Venue(newVenueName, newStatus, newPricing, newCapacity,newAction));
    }
    
    public static void editVenue(List<Venue> venues){
        Scanner input = new Scanner(System.in);
        char yesNo;
        int count =0;
        String modifyAction ="";
        
        for(int i =0; i<venues.size();i++){
            if(!venues.get(i).equals(null)){
                count++;
            }
        }
        if(count > 0){
            displayVenue(venues);

            System.out.printf("%40s %-10s","","Enter the Venue number you want to edit : ");
            int choice = input.nextInt();

            System.out.printf("%40s %-10s\n","","--------------------------------------------------------------------");
            System.out.printf("%40s %-4s | %-20s | %-12s | %-10s | %-8s |%-8s\n","","No.", "Venue Name", "Status", "Pricing (RM)", "Capacity","Admin Action");
            System.out.printf("%40s %-10s\n","","--------------------------------------------------------------------");
            System.out.printf("%40s %-4s | %-20s | %-12s | %-10s | %-8s |%-8s\n","", (choice), venues.get((choice-1)).getVenueName(), venues.get((choice-1)).getStatus(), venues.get((choice-1)).getPricing(), venues.get((choice-1)).getCapacity(),venues.get((choice-1)).getAction());
            System.out.printf("%40s %-10s\n","","--------------------------------------------------------------------");
            input.nextLine();
            System.out.printf("%40s %-10s","","Enter new venueName : ");
            String modifyVenueName = input.nextLine();
            while(modifyVenueName.isEmpty()== true){
                System.out.printf("%40s %-10s","","Cannot be empty try again : ");
                modifyVenueName = input.nextLine();
            }

            System.out.printf("%40s %-10s","","Enter status for the new venue (A: Available / U: Unavailable): ");
            String modifyStatus = input.nextLine().toUpperCase();
            while(!modifyStatus.equals("A") && !modifyStatus.equals("U")){
                System.out.printf("%40s %-10s","","Invalid input please try again : ");
                modifyStatus = input.nextLine().toUpperCase();
            }
            if(modifyStatus.equals("U")){
                modifyStatus ="Unavailable";
                modifyAction ="Edited";
            }else if(modifyStatus.equals("A")){
                modifyStatus ="Available";
                modifyAction ="havenEdited";
            }

            System.out.printf("%40s %-10s","","Enter new venue pricing : ");
            double modifyPricing = input.nextDouble();
            while(modifyPricing <=0){
                System.out.printf("%40s %-10s","","Cannot enter 0 try again : ");
                modifyPricing = input.nextDouble();
            }

            System.out.printf("%40s %-10s","","Enter capacity for the new venue : ");
            int modifyCapacity = input.nextInt();
            while(modifyCapacity <=0){
                System.out.printf("%40s %-10s","","Cannot enter 0 try again : ");
                modifyCapacity = input.nextInt();
            }

            System.out.printf("%40s %-10s","","Confirm u want to edit? (Y/N): ");
            yesNo = input.next().charAt(0);
            while(yesNo !='Y' && yesNo!='y' && yesNo !='N' && yesNo!='n'){
                System.out.printf("%40s %-10s","","Invalid input please try again(Y/N): ");
                yesNo = input.next().charAt(0);
            }
            if(Character.toUpperCase(yesNo)=='Y'){
                System.out.printf("%40s %-10s","","U have successful edited the venue!!\n\n");
                venues.get((choice-1)).setVenueName(modifyVenueName);
                venues.get((choice-1)).setStatus(modifyStatus);
                venues.get((choice-1)).setPricing(modifyPricing);
                venues.get((choice-1)).setCapacity(modifyCapacity);
                venues.get((choice-1)).setAction(modifyAction);
            }
        }else{
        System.out.printf("%40s %-10s","","Here doesn't have any venue!!\n\n");
        }
    }

    
    public static void displayVenue(List<Venue> venues){
        System.out.printf("\n%40s %-10s\n","","Venue List:");
        System.out.printf("%40s %-10s\n","","--------------------------------------------------------------------");
        System.out.printf("%40s %-4s | %-20s | %-12s | %-10s | %-8s |%-8s\n","","No.", "Venue Name", "Status", "Pricing (RM)", "Capacity", "Admin Action");
        System.out.printf("%40s %-10s\n","","--------------------------------------------------------------------");
        for (int i = 0; i < venues.size(); i++) {
            if(venues.get(i).getAction().equals("Edited")){
                venues.get(i).setStatus("Unavailable");
                System.out.printf("%40s %-4s | %-20s | %-12s | %-10s | %-8s |%-8s\n", "",(i + 1), venues.get(i).getVenueName(), venues.get(i).getStatus(), venues.get(i).getPricing(), venues.get(i).getCapacity(),venues.get(i).getAction());

            }else if(venues.get(i).getAction().equals("havenEdited")){
                venues.get(i).setStatus("Available");
                System.out.printf("%40s %-4s | %-20s | %-12s | %-10s | %-8s |%-8s\n", "",(i + 1), venues.get(i).getVenueName(), venues.get(i).getStatus(), venues.get(i).getPricing(), venues.get(i).getCapacity(),venues.get(i).getAction());
            }
        }
        System.out.printf("%40s %-10s\n","","--------------------------------------------------------------------");
    }
    
    public static void setDefaultVenues(List<Venue> venues){
        venues.add(new Venue("Restaurant", "Available", 100.0, 50,"havenEdited"));
        venues.add(new Venue("Hotel", "Available", 100.0, 20,"havenEdited"));
        venues.add(new Venue("Airbnb", "Available", 150.0, 30,"havenEdited"));
        venues.add(new Venue("Beach", "Available", 300.0, 200,"havenEdited"));
        venues.add(new Venue("Karaoke Room", "Available", 80.0, 20,"havenEdited"));
        venues.add(new Venue("Banquet Hall", "Available", 250.0, 150,"havenEdited"));
        venues.add(new Venue("Rooftop Terrace", "Available", 180.0, 80,"havenEdited"));
        
        System.out.printf("\n%40s %-10s\n\n","","You have successfully set the default venue to venue list!");
        
    }
    
    public static void deleteVenues(List<Venue> venues){
        Scanner input = new Scanner(System.in);
        displayVenue(venues);
        
        System.out.printf("%40s %-10s","","Enter the Venue number you want to Delete : ");
        int choice = input.nextInt();
        
        venues.remove((choice-1));
    }

   public static Venue[] currentVenueArr(List<Venue> venues) {
        Venue[] venueArr = new Venue[venues.size()];
        for (int i = 0; i < venues.size(); i++) {
            venueArr[i] = venues.get(i);
        }
        return venueArr;
    }
}
 
