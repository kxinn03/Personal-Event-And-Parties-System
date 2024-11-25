/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentoop3;

/**
 *
 * @author user
 */
/**
 *
 * @author user
 */
import java.util.List;
import java.util.Scanner;

public class Report {

    private static double totalBookingPrice = 0;
    public static void report(List<Booking> booking) {
        Scanner input = new Scanner(System.in);
        while (true) {
        System.out.printf("%40s %-10s\n","","Generate Report Menu:");
        System.out.printf("%40s %-10s\n","","1. All Bookings");
        System.out.printf("%40s %-10s\n","","2. Bookings on a Specific Date");
        System.out.printf("%40s %-10s\n","","3. Bookings on a Specific Month");
        System.out.printf("%40s %-10s\n","","4. Bookings on a Specific Year");
        System.out.printf("%40s %-10s\n","","5. Bookings by Member ID");
        System.out.printf("%40s %-10s\n","","6. Calculate Total Revenue");
        System.out.printf("%40s %-10s\n","","7. Cuisines on a Specfic Date");
        System.out.printf("%40s %-10s\n","","8. Exit");
        System.out.printf("%40s %-10s","","Enter your choice: ");
        int choice = input.nextInt();
        
        switch (choice) {
            case 1:
                displayAllBookings(booking);
                break;
            case 2:
                displayBookingsOnDate(booking);
                break;
            case 3:
                displayBookingsOnMonth(booking);
                break;
            case 4:
                displayBookingsOnYear(booking);
                break;
            case 5:
                displayBookingsByMemberID(booking);
                break;
            case 6:
                calculateTotalRevenue(booking);
                break;
            case 7:
                displayCuisineReport(booking);
                break;
            case 8:
                return;
            default:
                System.out.printf("%40s %-10s\n","","Invalid choice. Please select a valid option.");
        }
        }
        
    }
    
    public static void displayAllBookings(List<Booking> booking) {
        Scanner input = new Scanner(System.in);
        System.out.printf("\n%40s %-10s\n","","All Bookings:");
        double totalBookingPrice = 0;
        int totalBookings = 0;
        for (int i = 0; i < booking.size(); i++) {
            totalBookings++; 
            System.out.printf("%40s %-10s\n","","Booking " + (i +1) + " Details:");
            System.out.printf("%40s %-10s\n","","Booking No: " + booking.get(i).getBookingNo()); 
            System.out.printf("%40s %-10s\n","","Venue: " + booking.get(i).getSelectedVenueName());
            System.out.printf("%40s %-10s\n","","Venue's Booking Price: RM" + booking.get(i).getSelectedVenuePricing());
            System.out.printf("%40s %-10s\n","","Theme: " + booking.get(i).getSelectedTheme());
            System.out.printf("%40s %-10s\n","","Event Date: " + booking.get(i).getEventDate());
            
            if (booking.get(i).getSelectedCuisineChoice().equals("yes")) {
                totalBookingPrice = booking.get(i).getSelectedVenuePricing() + booking.get(i).getTotalPrice();
                System.out.printf("%40s %-10s\n","","< Selected Cuisine Details >");
                System.out.printf("%40s %-10s\n","","Cuisine Choice: " +  booking.get(i).getSelectedCuisineType()); // Display cuisine name
                System.out.printf("%40s %-10s\n","","Total Cuisine Price: RM" + booking.get(i).getTotalPrice());
                System.out.printf("%40s %-10s\n","","Cuisine Pax: " + booking.get(i).getTotalPeople());
                System.out.printf("%40s %-10s\n","","< Total Bills for Booking " + (i +1) + ">");
                System.out.printf("%40s %-10s\n","","Total Booking Price: RM" + totalBookingPrice);

            }else{
                totalBookingPrice = booking.get(i).getSelectedVenuePricing();
                System.out.printf("%40s %-10s\n","","< Total Bills for Booking " + (i +1) + " >");
                System.out.printf("%40s %-10s\n\n","","Total Booking Price: RM" + totalBookingPrice);

            }
        }
        System.out.printf("%40s %-10s\n","","Total Number of Bookings: " + totalBookings);
        System.out.printf("%40s %-10s","","Enter any character to go back: ");
        String choice = input.next();
        return;
    }
    
    public static void displayBookingsOnDate(List<Booking> booking) {
        Scanner input = new Scanner(System.in);
        String dateToSearch;
        String datePattern = "\\d{2}-[A-Z][a-z]{2}-\\d{4}";
        while(true) {
            
            do {
                System.out.printf("%40s %-10s", "", "Enter the date (dd-Mon-yyyy) to view bookings: ");
                dateToSearch = input.nextLine();

                if (!dateToSearch.matches(datePattern)) {
                    System.out.printf("%40s %-10s\n", "", "Invalid date format. Please enter the date in the format dd-Mon-yyyy.");
                }
            } while (!dateToSearch.matches(datePattern)); 
            
            int totalBookings = 0;
            for (int i = 0; i < booking.size(); i++) {
                if (booking.get(i).getEventDate().equals(dateToSearch)) {
                    totalBookings++; 
                    System.out.printf("%40s %-10s\n","","Booking " + (i +1) + " Details:");
                    System.out.printf("%40s %-10s\n","","Booking No: " + booking.get(i).getBookingNo()); 
                    System.out.printf("%40s %-10s\n","","Venue: " + booking.get(i).getSelectedVenueName());
                    System.out.printf("%40s %-10s\n","","Venue's Booking Price: RM" + booking.get(i).getSelectedVenuePricing());
                    System.out.printf("%40s %-10s\n","","Theme: " + booking.get(i).getSelectedTheme());
                    System.out.printf("%40s %-10s\n","","Event Date: " + booking.get(i).getEventDate());

                    if (booking.get(i).getSelectedCuisineChoice().equals("yes")) {
                        totalBookingPrice = booking.get(i).getSelectedVenuePricing() + booking.get(i).getTotalPrice();
                        System.out.printf("%40s %-10s\n","","< Selected Cuisine Details >");
                        System.out.printf("%40s %-10s\n","","Cuisine Choice: " +  booking.get(i).getSelectedCuisineType()); // Display cuisine name
                        System.out.printf("%40s %-10s\n","","Total Cuisine Price: RM" + booking.get(i).getTotalPrice());
                        System.out.printf("%40s %-10s\n","","Cuisine Pax: " + booking.get(i).getTotalPeople());
                        System.out.printf("%40s %-10s\n","","< Total Bills for Booking " + (i +1) + ">");
                        System.out.printf("%40s %-10s\n","","Total Booking Price: RM" + totalBookingPrice);

                    }else{
                        totalBookingPrice = booking.get(i).getSelectedVenuePricing();
                        System.out.printf("%40s %-10s\n","","< Total Bills for Booking " + (i +1) + " >");
                        System.out.printf("%40s %-10s\n\n","","Total Booking Price: RM" + totalBookingPrice);
                    }
                }
            }
            
            System.out.printf("%40s %-10s\n","","Total Bookings on " + dateToSearch + ": " + totalBookings);

            System.out.printf("%40s %-10s","","Do you want to search again for bookings on a specific date? (yes/no): ");
            String response = input.next();

            if (response.equalsIgnoreCase("no")) {
                break; 
            }
            input.nextLine();
        }         
    }
    
    public static void displayBookingsOnMonth(List<Booking> booking) {
        Scanner input = new Scanner(System.in);
        String monthYearToSearch;
        while(true) {
            String monthYearPattern = "^[A-Z][a-z]{2}-\\d{4}$";
             do {
               System.out.printf("%40s %-10s", "", "Enter the month (Mon-yyyy) to view bookings: ");
                monthYearToSearch = input.nextLine();

                if (!monthYearToSearch.matches(monthYearPattern)) {
                    System.out.printf("%40s %-10s\n", "", "Invalid format. Please enter the month in the format Mon-yyyy (e.g., Sep-2023).");
                    continue;
                }
            } while (!monthYearToSearch.matches(monthYearPattern)); 
                
            int totalBookings = 0;
            for (int i = 0; i < booking.size(); i++) {
                String eventDate = booking.get(i).getEventDate();
                String[] dateParts = eventDate.split("-");
                if (dateParts.length >= 2) {
                    String bookingMonthYear = dateParts[1] + "-" + dateParts[2];

                    if (bookingMonthYear.equalsIgnoreCase(monthYearToSearch)) {
                        totalBookings++; 
                        System.out.printf("%40s %-10s\n","","Booking " + (i +1) + " Details:");
                        System.out.printf("%40s %-10s\n","","Booking No: " + booking.get(i).getBookingNo()); 
                        System.out.printf("%40s %-10s\n","","Venue: " + booking.get(i).getSelectedVenueName());
                        System.out.printf("%40s %-10s\n","","Venue's Booking Price: RM" + booking.get(i).getSelectedVenuePricing());
                        System.out.printf("%40s %-10s\n","","Theme: " + booking.get(i).getSelectedTheme());
                        System.out.printf("%40s %-10s\n","","Event Date: " + booking.get(i).getEventDate());

                        if (booking.get(i).getSelectedCuisineChoice().equals("yes")) {
                            totalBookingPrice = booking.get(i).getSelectedVenuePricing() + booking.get(i).getTotalPrice();
                            System.out.printf("%40s %-10s\n","","< Selected Cuisine Details >");
                            System.out.printf("%40s %-10s\n","","Cuisine Choice: " +  booking.get(i).getSelectedCuisineType()); // Display cuisine name
                            System.out.printf("%40s %-10s\n","","Total Cuisine Price: RM" + booking.get(i).getTotalPrice());
                            System.out.printf("%40s %-10s\n","","Cuisine Pax: " + booking.get(i).getTotalPeople());
                            System.out.printf("%40s %-10s\n","","< Total Bills for Booking " + (i +1) + ">");
                            System.out.printf("%40s %-10s\n","","Total Booking Price: RM" + totalBookingPrice);

                        }else{
                            totalBookingPrice = booking.get(i).getSelectedVenuePricing();
                            System.out.printf("%40s %-10s\n","","< Total Bills for Booking " + (i +1) + " >");
                            System.out.printf("%40s %-10s\n\n","","Total Booking Price: RM" + totalBookingPrice);

                        }
                    }
                }
            }
            System.out.printf("%40s %-10s\n","","Total Bookings on " + monthYearToSearch + ": " + totalBookings);

            System.out.printf("%40s %-10s","","Do you want to search again for bookings on a specific month of a year? (yes/no): ");
            String response = input.next();
            if (response.equalsIgnoreCase("no")) {
                break; 
            }
            input.nextLine();
        }
            
    }
    
    public static void displayBookingsOnYear(List<Booking> booking) {
        Scanner input = new Scanner(System.in);
        while(true) {
            String yearPattern = "^\\d{4}$";
            String yearToSearch;
             do {
                System.out.printf("%40s %-10s", "", "Enter the year (yyyy) to view bookings: ");
                yearToSearch = input.nextLine();

                if (!yearToSearch.matches(yearPattern)) {
                    System.out.printf("%40s %-10s\n", "", "Invalid format. Please enter a valid four-digit year (e.g., 2023):");
                    continue; 
                }
            } while (!yearToSearch.matches(yearPattern)); 
                

            
            int totalBookings = 0;
            for (int i = 0; i < booking.size(); i++) {
                String eventDate = booking.get(i).getEventDate();
                String[] dateParts = eventDate.split("-");
                if (dateParts.length >= 3) {
                    String bookingYear = dateParts[2];

                    if (bookingYear.equals(yearToSearch)) {
                        totalBookings++; 
                        System.out.printf("%40s %-10s\n","","Booking " + (i +1) + " Details:");
                        System.out.printf("%40s %-10s\n","","Booking No: " + booking.get(i).getBookingNo()); 
                        System.out.printf("%40s %-10s\n","","Venue: " + booking.get(i).getSelectedVenueName());
                        System.out.printf("%40s %-10s\n","","Venue's Booking Price: RM" + booking.get(i).getSelectedVenuePricing());
                        System.out.printf("%40s %-10s\n","","Theme: " + booking.get(i).getSelectedTheme());
                        System.out.printf("%40s %-10s\n","","Event Date: " + booking.get(i).getEventDate());

                        if (booking.get(i).getSelectedCuisineChoice().equals("yes")) {
                            totalBookingPrice = booking.get(i).getSelectedVenuePricing() + booking.get(i).getTotalPrice();
                            System.out.printf("%40s %-10s\n","","< Selected Cuisine Details >");
                            System.out.printf("%40s %-10s\n","","Cuisine Choice: " +  booking.get(i).getSelectedCuisineType()); // Display cuisine name
                            System.out.printf("%40s %-10s\n","","Total Cuisine Price: RM" + booking.get(i).getTotalPrice());
                            System.out.printf("%40s %-10s\n","","Cuisine Pax: " + booking.get(i).getTotalPeople());
                            System.out.printf("%40s %-10s\n","","< Total Bills for Booking " + (i +1) + ">");
                            System.out.printf("%40s %-10s\n","","Total Booking Price: RM" + totalBookingPrice);

                        }else{
                            totalBookingPrice = booking.get(i).getSelectedVenuePricing();
                            System.out.printf("%40s %-10s\n","","< Total Bills for Booking " + (i +1) + " >");
                            System.out.printf("%40s %-10s\n\n","","Total Booking Price: RM" + totalBookingPrice);
                        }
                    }
                }
            }
            System.out.printf("%40s %-10s\n","","Total Bookings on " + yearToSearch + " year: " + totalBookings);

            System.out.printf("%40s %-10s","","Do you want to search again for bookings on a specific year? (yes/no): ");
            String response = input.next();
            if (response.equalsIgnoreCase("no")) {
                break; 
            }
            input.nextLine();
        }
        
    }
    
    public static void displayBookingsByMemberID(List<Booking> booking) {
        Scanner input = new Scanner(System.in);
        while(true) {
            String memberIDPattern = "^M\\d{3}$";
            String memberIDToSearch;
             do {
                System.out.printf("%40s %-10s", "", "Enter the Member ID to view bookings: ");
                memberIDToSearch = input.nextLine();

                if (!memberIDToSearch.matches(memberIDPattern)) {
                    System.out.printf("%40s %-10s\n","","Invalid format. Please enter a valid member ID in the format M###.");
                    continue; 
                }
            } while (!memberIDToSearch.matches(memberIDPattern)); 

            boolean foundMember = false; // Flag to track if a matching member is found

            int totalBookings = 0;
            for (int i = 0; i < booking.size(); i++) {
                if (booking.get(i).getUserID().equals(memberIDToSearch)) {
                    foundMember = true; 
                    totalBookings++;
                        System.out.printf("%40s %-10s\n","","Booking " + (i +1) + " Details:");
                        System.out.printf("%40s %-10s\n","","Booking No: " + booking.get(i).getBookingNo()); 
                        System.out.printf("%40s %-10s\n","","Venue: " + booking.get(i).getSelectedVenueName());
                        System.out.printf("%40s %-10s\n","","Venue's Booking Price: RM" + booking.get(i).getSelectedVenuePricing());
                        System.out.printf("%40s %-10s\n","","Theme: " + booking.get(i).getSelectedTheme());
                        System.out.printf("%40s %-10s\n","","Event Date: " + booking.get(i).getEventDate());

                        if (booking.get(i).getSelectedCuisineChoice().equals("yes")) {
                            totalBookingPrice = booking.get(i).getSelectedVenuePricing() + booking.get(i).getTotalPrice();
                            System.out.printf("%40s %-10s\n","","< Selected Cuisine Details >");
                            System.out.printf("%40s %-10s\n","","Cuisine Choice: " +  booking.get(i).getSelectedCuisineType()); // Display cuisine name
                            System.out.printf("%40s %-10s\n","","Total Cuisine Price: RM" + booking.get(i).getTotalPrice());
                            System.out.printf("%40s %-10s\n","","Cuisine Pax: " + booking.get(i).getTotalPeople());
                            System.out.printf("%40s %-10s\n","","< Total Bills for Booking " + (i +1) + ">");
                            System.out.printf("%40s %-10s\n","","Total Booking Price: RM" + totalBookingPrice);

                        }else{
                            totalBookingPrice = booking.get(i).getSelectedVenuePricing();
                            System.out.printf("%40s %-10s\n","","< Total Bills for Booking " + (i +1) + " >");
                            System.out.printf("%40s %-10s\n\n","","Total Booking Price: RM" + totalBookingPrice);
                        }

                }
            }

            if (!foundMember) {
                System.out.printf("%40s %-10s\n", "", "No such member with ID " + memberIDToSearch + " found.");
            } else {
                System.out.printf("%40s %-10s\n", "", "Total Bookings for Member " + memberIDToSearch + ": " + totalBookings);
            }

            System.out.printf("%40s %-10s", "", "Do you want to search again for bookings of a specific member? (yes/no): ");
            String response = input.next();
            if (response.equalsIgnoreCase("no")) {
                break; 
            }
            input.nextLine();
        }
        
        
    }
  
    public static void calculateTotalRevenue(List<Booking> booking) {
        double totalRevenue = 0.0;
        
        for (int i = 0; i < booking.size(); i++) {
            System.out.printf("%40s %-10s\n","","Booking " + (i +1) + " Details:");
            System.out.printf("%40s %-10s\n","","Booking No: " + booking.get(i).getBookingNo()); 
            System.out.printf("%40s %-10s\n","","Venue: " + booking.get(i).getSelectedVenueName());
            System.out.printf("%40s %-10s\n","","Venue's Booking Price: RM" + booking.get(i).getSelectedVenuePricing());
            System.out.printf("%40s %-10s\n","","Theme: " + booking.get(i).getSelectedTheme());
            System.out.printf("%40s %-10s\n","","Event Date: " + booking.get(i).getEventDate());
            
            if (booking.get(i).getSelectedCuisineChoice().equals("yes")) {
                totalBookingPrice = booking.get(i).getSelectedVenuePricing() + booking.get(i).getTotalPrice();
                System.out.printf("%40s %-10s\n","","< Selected Cuisine Details >");
                System.out.printf("%40s %-10s\n","","Cuisine Choice: " +  booking.get(i).getSelectedCuisineType()); // Display cuisine name
                System.out.printf("%40s %-10s\n","","Total Cuisine Price: RM" + booking.get(i).getTotalPrice());
                System.out.printf("%40s %-10s\n","","Cuisine Pax: " + booking.get(i).getTotalPeople());
                System.out.printf("%40s %-10s\n","","< Total Bills for Booking " + (i +1) + ">");
                System.out.printf("%40s %-10s\n\n","","Total Booking Price: RM" + totalBookingPrice);
                booking.get(i).setTotalPriceInArray(totalBookingPrice);
                totalRevenue += booking.get(i).getTotalPriceInArray();

            }else{
                totalBookingPrice = booking.get(i).getSelectedVenuePricing();
                System.out.printf("%40s %-10s\n","","< Total Bills for Booking " + (i +1) + " >");
                System.out.printf("%40s %-10s\n\n","","Total Booking Price: RM" + totalBookingPrice);
                booking.get(i).setTotalPriceInArray(totalBookingPrice);
                totalRevenue += booking.get(i).getTotalPriceInArray();

            }
        }
        
        System.out.printf("%40s %-10s\n","","Total Revenue: RM" + totalRevenue);
    }
    
    public static void displayCuisineReport(List<Booking> booking) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.printf("%40s %-10s", "", "Enter the date to view cuisine report: ");
            String datePrepareCuisine = input.nextLine();

            boolean cuisineFound = false;
            System.out.printf("%40s %-10s\n", "", "<Cuisine Need To Prepared on" + datePrepareCuisine + ">");
            for (int i = 0; i < booking.size(); i++) {
                if (booking.get(i).getEventDate().equals(datePrepareCuisine) &&
                    booking.get(i).getSelectedCuisineChoice().equals("yes")) {
                    String cuisineType = booking.get(i).getSelectedCuisineType();
                    int totalPeople = booking.get(i).getTotalPeople();

                    cuisineFound = true;

                    // Check if this cuisine type has already been printed
                    boolean cuisinePrinted = false;

                    for (int j = 0; j < i; j++) {
                        if (booking.get(j).getEventDate().equals(datePrepareCuisine) &&
                            booking.get(j).getSelectedCuisineChoice().equals("yes") &&
                            booking.get(j).getSelectedCuisineType().equals(cuisineType)) {
                            cuisinePrinted = true;
                            break;
                        }
                    }

                    if (!cuisinePrinted) {
                        int totalQuantity = 0;
                        for (int j = i; j < booking.size(); j++) {
                            if (booking.get(j).getEventDate().equals(datePrepareCuisine) &&
                                booking.get(j).getSelectedCuisineChoice().equals("yes") &&
                                booking.get(j).getSelectedCuisineType().equals(cuisineType)) {
                                totalQuantity += booking.get(j).getTotalPeople();
                            }
                        }


                        System.out.printf("%40s %-10s\n", "", "Cuisine Type: " + cuisineType);
                        System.out.printf("%40s %-10s\n", "", "Total Quantity: " + totalQuantity);
                    }
                }
            }

            if (!cuisineFound) {
                System.out.printf("%40s %-10s\n", "", "There are no cuisine need to prepare on this date.");
            }

            System.out.printf("%40s %-10s", "", "Do you want to search again for cuisines on a specific date? (yes/no): ");
            String response = input.next();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
            input.nextLine();
        }
    }
}
    