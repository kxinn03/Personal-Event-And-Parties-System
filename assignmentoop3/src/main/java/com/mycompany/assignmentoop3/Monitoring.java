/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.assignmentoop3;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Monitoring {
    private List<Booking> bookingList;
    private Venue[] venueArr;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

    public Monitoring(List<Booking> bookingList, Venue[] venueArr) {
        this.bookingList = bookingList;
        this.venueArr = venueArr;
    }

    public void monitoringPage(List<Venue> venues) {
        Scanner input = new Scanner(System.in);
        boolean monitorAnotherMonth = true;
        
        while (monitorAnotherMonth) {
            System.out.printf("%97s %-10s\n", "", "Monitoring");
            System.out.printf("%70s %-10s\n", "", "===============================================================");
            
            int year = getValidYear(input);
            int month = getValidMonth(input);
            
            LocalDate startDate = LocalDate.of(year, month, 1);
            LocalDate endDate = startDate.plusMonths(1).minusDays(1);
            
            displayMonitoringPeriod(startDate, endDate);
            
            displayMonitoringTable(venues, startDate, endDate);
            
            if (shouldFilterData(input)) {
                filterData(venues, year, month);
            }

            if (!shouldMonitorAnotherMonth(input)) {
                monitorAnotherMonth = false;
            }
        }
    }

    private int getValidYear(Scanner input) {
        int year;
        while (true) {
            System.out.printf("%40s %-10s", "", "Enter the year (e.g., 2023 or later): ");
            if (input.hasNextInt()) {
                year = input.nextInt();
                if (year >= 2023) {
                    break; 
                } else {
                    System.out.printf("%40s %-10s", "", "Invalid year. Please enter a year of 2023 or later\n ");
                }
            } else {
                System.out.printf("%40s %-10s", "", "Invalid input. Please enter a valid year (e.g., 2023 or later)\n ");
                input.next();
            }
        }
        return year;
    }

    private int getValidMonth(Scanner input) {
        int month;
        while (true) {
            System.out.printf("%40s %-10s", "", "Enter the month (e.g., 1 for January): ");
            if (input.hasNextInt()) {
                month = input.nextInt();
                if (month >= 1 && month <= 12) {
                    break; 
                } else {
                    System.out.printf("%40s %-10s", "", "Invalid month. Please enter a valid month (e.g., 1-12)\n ");
                }
            } else {
                System.out.printf("%40s %-10s", "", "Invalid input. Please enter a valid month (e.g., 1-12)\n ");
                input.next(); 
            }
        }
        return month;
    }

    private void displayMonitoringPeriod(LocalDate startDate, LocalDate endDate) {
        System.out.println();
        System.out.printf("%80s %-10s", "", "Monitoring Period: " + startDate.format(dateFormatter) + " to " + endDate.format(dateFormatter));
        System.out.println();
        System.out.println();
    }

    private void displayMonitoringTable(List<Venue> venues, LocalDate startDate, LocalDate endDate) {
        Scanner input = new Scanner(System.in);

        // Display table header
        System.out.printf("%13s %5s", "Date", "");
        for (Venue venue : venues) {
            System.out.printf("%19s      ", venue.getVenueName());
        }
        System.out.println();
        System.out.printf("%5s", "-".repeat(200));
        System.out.println();

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            String formattedDate = currentDate.format(dateFormatter);

            // Display the status of each venue for the current date
            System.out.printf("%15s    |     ", formattedDate);
            for (int i = 0; i < venues.size(); i++) {
                String status = "Available";

                // Check if the venue is booked on the current date
                for (Booking booking : bookingList) {
                    if (booking.getEventDate().equals(formattedDate) && booking.getVenueChoice() == i) {
                        status = "Booked";
                        break;
                    }
                }
                System.out.printf("%13s      |     ", status);
            }
            System.out.println();
            currentDate = currentDate.plusDays(1);
        }
    }

    private boolean shouldFilterData(Scanner input) {
        String filterChoice;
         while (true) {
        System.out.printf("%40s %-10s", "", "Do you want to filtering? (Y/N): ");
        filterChoice = input.next().toLowerCase();
        if (filterChoice.equals("y") || filterChoice.equals("n")) {
            break; 
        } else {
            System.out.printf("%40s %-10s", "", "Invalid input. Please enter 'Y' or 'N'\n ");
        }
    }
    return filterChoice.equals("y");
    }

    private void filterData(List<Venue> venues, int year, int month) {
        Scanner input = new Scanner(System.in);
        boolean filterMenu = true;
        while (filterMenu) {
            System.out.println();
            System.out.printf("%40s %-10s", "", "Filter Options:\n");
            System.out.printf("%40s %-10s", "", "1. Display Booked Venues and Dates\n");
            System.out.printf("%40s %-10s", "", "2. Display Specific Venue\n");
            System.out.printf("%40s %-10s", "", "3. Display Specific Date\n");
            System.out.println();
            System.out.printf("%40s %-10s", "", "Enter your choice: ");
            
            int filterChoice ;
                    
               if (input.hasNextInt()) {
            filterChoice = input.nextInt();
            input.nextLine();
        
            switch (filterChoice) {
                case 1:
                    displayUnavailableVenuesAndDates(year, month);
                    break;
                case 2:
                    displaySpecificVenue(venues, year, month);
                    break;
                case 3:
                    displaySpecificDate(venues);
                    break;
                default:
                    System.out.printf("%40s %-10s", "", "Invalid choice. Please enter a valid option.");
                    System.out.println();
            }
        } else {
            System.out.printf("%40s %-10s", "", "Invalid input. Please enter a valid option.");
            System.out.println();
            input.next(); 
        }
           while (true) {
    System.out.printf("%40s %-10s", "", "Do you want to continue filtering? (Y/N): ");
    String continueFiltering = input.nextLine().toLowerCase(); 
    if (continueFiltering.equals("y") || continueFiltering.equals("n")) {
        if (continueFiltering.equals("n")) {
            filterMenu = false; // Set filterMenu to false to exit the filtering loop
        }
        break;
    } else {
        System.out.printf("%40s %-10s", "", "Invalid input. Please enter 'Y' or 'N'\n");
    }
}

    }
    }

    private void displayUnavailableVenuesAndDates(int year, int month) {
        System.out.println();
        System.out.printf("%85s %-10s", "", "Booked Venues and Dates:\n");
        System.out.printf("%80s %-10s", "", "-------------------------------------\n");
        System.out.printf("%100s | %-10s%n", "Venue Name", "Date");
        System.out.println();

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);

        for (Booking booking : bookingList) {
            LocalDate eventDate = LocalDate.parse(booking.getEventDate(), dateFormatter);
            // Check if the booking date falls within the monitoring period
            if (!eventDate.isBefore(startDate) && !eventDate.isAfter(endDate)) {
                Venue bookedVenue = venueArr[booking.getVenueChoice()];
                System.out.printf("%100s | %-10s%n", bookedVenue.getVenueName(), booking.getEventDate());
            }
        }
        System.out.printf("%80s %-10s", "", "-------------------------------------");
        System.out.println();
    }

    private void displaySpecificVenue(List<Venue> venues, int year, int month) {
        Scanner input = new Scanner(System.in);
        System.out.println();

        // Ask the admin to select a venue
        System.out.printf("%80s %-10s", "", "Venue List");
        System.out.println();
        for (int i = 0; i < venues.size(); i++) {
            System.out.printf("%-77s%s%s %s", "", (i + 1), ". ", venues.get(i).getVenueName() + "\n");
        }
        
         int venueChoice=0;
         boolean validChoice = false;

         LocalDate startDate = LocalDate.of(year, month, 1);
         LocalDate endDate = startDate.plusMonths(1).minusDays(1);
       do {
        System.out.printf("%40s %-10s", "", "Enter the venue number: ");
        if (input.hasNextInt()) {
            venueChoice = input.nextInt();
            if (venueChoice >= 1 && venueChoice <= venues.size()) {
                validChoice = true;
            } else {
                System.out.printf("%40s %-10s", "", "Invalid venue number. Please enter a valid number\n ");
            }
        } else {
            System.out.printf("%40s %-10s", "", "Invalid input. Please enter a valid number\n ");
            input.next(); 
        }
        } while (!validChoice);

        System.out.println();
        System.out.printf("%70s %-10s", "", "Monitoring Period: " + startDate.format(dateFormatter) + " to " + endDate.format(dateFormatter));
        System.out.println();
        System.out.println();

        // Display table header
        System.out.printf("%90s | %13s%n", "Date", "Status");
        System.out.printf("%130s", "------------------------------------------------------------------\n");

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            String formattedDate = currentDate.format(dateFormatter);
            String status = "Available";

            // Check if the venue is booked on the current date
            for (Booking booking : bookingList) {
                if (booking.getEventDate().equals(formattedDate) && booking.getVenueChoice() == (venueChoice - 1)) {
                    status = "Booked";
                    break;
                }
            }

            System.out.printf("%90s | %15s%n", formattedDate, status);
            currentDate = currentDate.plusDays(1);
        }
        System.out.printf("%130s", "------------------------------------------------------------------\n");
    }

private void displaySpecificDate(List<Venue> venues) {
    Scanner input = new Scanner(System.in);
    System.out.println();

    String monitoringDate;
    boolean validDate = false;

    do {
        System.out.printf("%40s %-10s", "", "Enter a date to monitor (dd-MMM-yyyy format, e.g., 29-Mar-2023): ");
        monitoringDate = input.nextLine();
        if (isValidDateFormat(monitoringDate)) {
            validDate = true;
        } else {
            System.out.printf("%40s %-10s", "", "Invalid date format. Please enter a valid date\n ");
        }
    } while (!validDate);

    System.out.println();
    System.out.printf("%80s %-10s", "", "Monitoring Date: " + monitoringDate);
    System.out.println();
    System.out.println();
    // Display table header
    System.out.printf("%90s     |      %-15s%n", "Venue Name", "Status");
    System.out.printf("%60s %-10s", "", "-------------------------------------------------------------------\n");

    for (Venue venue : venues) {
        String status = "Available";

        for (Booking booking : bookingList) {
            if (booking.getEventDate().equals(monitoringDate) && venue.equals(venues.get(booking.getVenueChoice()))) {
                status = "Booked";
                break;
            }
        }

        System.out.printf("%90s     | %15s%n", venue.getVenueName(), status);
        System.out.println();
    }
}

private boolean isValidDateFormat(String date) {
    try {
        LocalDate.parse(date, dateFormatter);
        return true;
    } catch (DateTimeParseException e) {
        return false;
    }
}


    private boolean shouldMonitorAnotherMonth(Scanner input) {
    String monitorAnotherChoice;
    while (true) {
        System.out.printf("%40s %-10s", "", "Do you want to monitor another month/year? (Y/N): ");
        monitorAnotherChoice = input.next().toLowerCase();
        if (monitorAnotherChoice.equals("y") || monitorAnotherChoice.equals("n")) {
            break;
        } else {
            System.out.printf("%40s %-10s", "", "Invalid input. Please enter 'Y' or 'N'\n ");
        }
    }
    return monitorAnotherChoice.equals("y");
}
}