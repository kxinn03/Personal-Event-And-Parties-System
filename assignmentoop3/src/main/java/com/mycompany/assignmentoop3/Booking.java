/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Booking {
    private int bookingNo;
    private String eventDate; //compare date that user input
    private static String userInputDate;
    private String userID;
    private int venueChoice = 0;
    private int themeChoice = 0;
    private int cuisineChoice = 0;
    private int totalPeople = 0;
    private double totalPrice = 0;
    private static int counter = 0;
    private String paymentStatus ;
    private String selectedVenueName;  // Get the selected venue name from array
    double selectedVenuePricing; // Get the selected venue price from array
    private String selectedTheme;  // Get the selected theme name from array
    private String selectedCuisineType;  // Get the selected cuisine name from array
    private String selectedCuisineChoice;
    private static String editStatus;  //"Unavailable"
    private double totalPriceInArray =0;
    private Venue venue;
    private VenueType theme;
    private static Cuisine cuisine; // Include a Cuisine field
    private static int firstBookingNo = 1001; // Start booking numbers from 1001
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);

    //CONSTRUCTOR
    public Booking() {
        this.bookingNo = firstBookingNo;
    }
    
    
    //GETTER
    public int getBookingNo() {
        return bookingNo;
    }
    public String getEventDate() {
        return eventDate;
    }
    public Venue getVenue() {
        return venue;
    }
    public VenueType getTheme() {
        return theme;
    }
    public static int getFirstBookingNo() {
        return firstBookingNo;
    }
    public int getVenueChoice() {
        return venueChoice;
    }
    public int getThemeChoice() {
        return themeChoice;
    }
    public int getCuisineChoice() {
        return cuisineChoice;
    }
    public int getTotalPeople() {
        return totalPeople;
    }
    public static String getEditStatus() {
        return editStatus;
    }
    public static String getUserInputDate() {
        return userInputDate;
    }  
    public String getSelectedVenueName() {
        return selectedVenueName;
    }
    public double getSelectedVenuePricing() {
        return selectedVenuePricing;
    }
    public String getSelectedTheme() {
        return selectedTheme;
    }
    public String getSelectedCuisineType() {
        return selectedCuisineType;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public String getSelectedCuisineChoice() {
        return selectedCuisineChoice;
    }
    public String getUserID() {
        return userID;
    }
    public double getTotalPriceInArray() {
        return totalPriceInArray;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
    
    
    

    //SETTER
    public void setbookingNo(int bookingNo){
        this.bookingNo = bookingNo;
    }
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
    public void setVenueChoice(int eventChoice) {
        this.venueChoice = eventChoice;
    }
    public void setThemeChoice(int themeChoice) {
        this.themeChoice = themeChoice;
    }
    public void setCuisineChoice(int cuisineChoice) {
        this.cuisineChoice = cuisineChoice;
    }
    public void setTotalPeople(int totalPeople) {
        this.totalPeople = totalPeople;
    }
    public static void setEditStatus(String editStatus) {
        Booking.editStatus = editStatus;
    }
    public static void setUserInputDate(String userInputDate) {
        Booking.userInputDate = userInputDate;
    }
    public void setSelectedVenueName(String selectedVenueName) {
        this.selectedVenueName = selectedVenueName;
    }
    public void setSelectedVenuePricing(double selectedVenuePricing) {
        this.selectedVenuePricing = selectedVenuePricing;
    }
    public void setSelectedTheme(String selectedTheme) {
        this.selectedTheme = selectedTheme;
    }
    public void setSelectedCuisineType(String selectedCuisineType) {
        this.selectedCuisineType = selectedCuisineType;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void setSelectedCuisineChoice(String selectedCuisineChoice) {
        this.selectedCuisineChoice = selectedCuisineChoice;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public void setTotalPriceInArray(double totalPriceInArray) {
        this.totalPriceInArray = totalPriceInArray;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    
    

    // PROCESS OF MAKING BOOKING
    public static void MakeBooking(List<Booking> booking,String ID,List<Payment>payments, List<Venue> venues){     
        Scanner input = new Scanner(System.in);
        Member member = new Member();
        Payment payment = new Payment();
        boolean makeAnotherBooking = true;
        int validDate = 0;
        int validVenue = 0;
        int bookingCount = 0;
        int cuisineNumber = 0;  
        int quantity = 0;  //people quantity
        int paymentChoice;
        int venueSelection;
        int count = 0;
        int themeSelection = 0;
        String includeCuisineChoice = "";
        char confirmBookChoice;
        int gotbooking = 0;
        
        while (makeAnotherBooking) {
        Booking bookings = new Booking();
            counter++;
            if(counter >=100){
                System.out.printf("%40s %-10s","","Maximum number of bookings reached.");
                break;
            }
            
            do{
                System.out.printf("%40s %-10s","","Enter date you want to book(dd-MMM-yyyy format, e.g. 07-Oct-2023): ");
                userInputDate = input.nextLine();

                LocalDate localDate = LocalDate.parse(userInputDate, dateFormatter);
                if(localDate.isBefore(LocalDate.now()) || localDate.isEqual(LocalDate.now())){
                    System.out.printf("%40s %-10s\n","","* Invalid date *");
                    System.out.printf("%40s %-10s\n","","Please re-enter your preferred date");
                    validDate = 0;
                }else {
                    System.out.printf("%40s %-10s","","* Accepted date *");
                    validDate = 1;
                    break;}
            }while (validDate == 0);
            
            VenueType[] venueTypeArr = {
                new VenueType("Rainbow Party Theme"),
                new VenueType("Space Party Theme"),
                new VenueType("All-Pink Party Theme"),
                new VenueType("Nature Party Theme"),
                new VenueType("Gold Party Theme"),
                new VenueType("French Bakery Party Theme"),
                new VenueType("Summer Party Theme"),
                new VenueType("Tropical Party Theme"),
                new VenueType("Art Party Theme"),
                new VenueType("Emoji Birthday Party Theme")
            };
            
            CuisineType[] cuisineTypeArr = {
                new CuisineType("Chinese Cuisine"),
                new CuisineType("Indian Cuisine"),
                new CuisineType("Malay Cuisine"),
                new CuisineType("Japanese Cuisine"),
                new CuisineType("Korean Cuisine"),
                new CuisineType("Seafood"),
                new CuisineType("Food Trucks"),
                new CuisineType("BBQ and Grill")
            };
            
            for(int i = 0; i<booking.size(); i++){
                if(booking.get(i).getEventDate().equals(userInputDate)){
                    editStatus ="Unavailable";
                    int choice = booking.get(i).getVenueChoice();
                    venues.get(choice).setStatus(editStatus);
                }
            }        
           
            // DISPLAY VENUE LIST
            System.out.printf("\n%40s %-10s\n","","Venue List:");
            System.out.printf("%40s %-10s\n","","--------------------------------------------------------------------");
            System.out.printf("%40s %-4s | %-20s | %-12s | %-10s | %-8s \n","","No.", "Venue Name", "Status", "Pricing (RM)", "Capacity");
            System.out.printf("%40s %-10s\n","","--------------------------------------------------------------------");
            for (int i = 0; i < venues.size(); i++) {
                System.out.printf("%40s %-4s | %-20s | %-12s | %-10s | %-8s \n", "",(i + 1), venues.get(i).getVenueName(), venues.get(i).getStatus(), venues.get(i).getPricing(), venues.get(i).getCapacity());
            }
        System.out.printf("%40s %-10s\n","","--------------------------------------------------------------------");
            do{
                System.out.printf("%40s %-10s","","Enter the venue number you want to book: ");
                venueSelection = input.nextInt(); 
                if(venues.get((venueSelection -1)).getStatus().equals(editStatus) || venues.get((venueSelection -1)).getStatus().equals("Unavailable")){
                    System.out.printf("%40s %-10s\n","","This Venue Is Unavailable On The Date You Choose. ");
                    System.out.printf("%40s %-10s\n","","Try again\n");
                    validVenue = 0;
                }else{
                    validVenue = 1;
                    break;
                }
            }while(validVenue == 0);
            input.nextLine();   //TO CLEAR BUFFER
            
            //DISPLAY THEME LIST
            do {
                System.out.printf("\n%40s %-10s\n", "", "Theme List:");
                for (int i = 0; i < venueTypeArr.length; i++) {
                    System.out.printf("%40s %-10s\n", "", (i + 1) + ". " + venueTypeArr[i].getTheme());
                }
                System.out.printf("%40s %-10s", "", "Enter the theme number for choosing event: ");
                themeSelection = input.nextInt();

                if (themeSelection < 1 || themeSelection > venueTypeArr.length) {
                    System.out.printf("%40s %-10s", "", "Error: Invalid theme number. Please enter a valid theme number.");
                }
            } while (themeSelection < 1 || themeSelection > venueTypeArr.length);
            input.nextLine();   //TO CLEAR BUFFER

            // CUISINE CHOICE
            do {
                System.out.printf("%40s %-10s", "", "Do you want to include cuisine for the booking? - Price Per Person RM50 (yes/no): ");
                includeCuisineChoice = input.nextLine().toLowerCase();

                if (!includeCuisineChoice.equals("yes") && !includeCuisineChoice.equals("no")) {
                    System.out.printf("%40s %-10s\n", "", "Error: Please enter 'yes' or 'no'.");
                }
            } while (!includeCuisineChoice.equals("yes") && !includeCuisineChoice.equals("no"));
            if (includeCuisineChoice.equals("yes")) {
                // DISPLAY CUISINE LIST
                    do {
                        System.out.printf("\n%40s %-10s\n", "", "Cuisine List:");
                        for (int i = 0; i < cuisineTypeArr.length; i++) {
                            System.out.printf("%40s %-10s\n", "", (i + 1) + ". " + cuisineTypeArr[i].getCuisine());
                        }
                        System.out.printf("%40s %-10s", "", "Enter the cuisine number for your event: ");
                        cuisineNumber = input.nextInt();

                        if (cuisineNumber < 1 || cuisineNumber > cuisineTypeArr.length) {
                            System.out.printf("%40s %-10s","","Error: Invalid cuisine number. Please enter a valid cuisine number.");
                        }
                    } while (cuisineNumber < 1 || cuisineNumber > cuisineTypeArr.length);
                
                System.out.printf("%40s %-10s","","Enter the quantity of people for cuisine: ");
                quantity = input.nextInt();            
                input.nextLine();   //TO CLEAR BUFFER
            }
            
            //confirm make booking??
            System.out.printf("%40s %-10s", "", "Confirm Making This Booking? (Y/N): ");
            confirmBookChoice =  input.next().charAt(0);
                if(confirmBookChoice == 'Y' || confirmBookChoice == 'y' ){
                    bookings.setUserID(ID);
                    bookings.setbookingNo(firstBookingNo);
                    bookings.setTotalPrice(quantity*50);
                    bookings.setTotalPriceInArray(0);
                    bookings.setEventDate(userInputDate);
                    bookings.setVenueChoice((venueSelection -1)); 
                    bookings.setThemeChoice((themeSelection -1)); 
                    bookings.setSelectedCuisineChoice(includeCuisineChoice);
                    bookings.setPaymentStatus("Unpaid");
                    firstBookingNo++;
                    gotbooking++;
                    if(includeCuisineChoice.equals("yes")){
                        bookings.setCuisineChoice((cuisineNumber -1)); 
                        bookings.setTotalPeople((quantity));
                    }
                    booking.add(bookings);
                }else{
                    if(gotbooking == 0){
                        System.out.printf("\n%40s %-10s\n","","You have decided to terminate your booking.");
                    }   
                }

            //DISPLAY SUMMARY BOOKING
            bookings.setSelectedVenueName(venues.get((venueSelection -1)).getVenueName()); // Get the selected venue name from array
            bookings.setSelectedTheme(venueTypeArr[themeSelection -1].getTheme()); // Get the selected theme from array
            bookings.setSelectedVenuePricing(venues.get((venueSelection -1)).getPricing()); // Get the selected venue price from array
             if(includeCuisineChoice.equals("yes")){
                bookings.setSelectedCuisineType(cuisineTypeArr[cuisineNumber -1].getCuisine());  // Get the selected cuisine name from array

            }else{
                bookings.setSelectedCuisineType("None"); 
            } 
             
            System.out.printf("\n%40s %-10s", "", "Do you want to make another booking? (yes/no): ");
            String anotherBookingChoice = input.next().toLowerCase();
            makeAnotherBooking = anotherBookingChoice.equals("yes");
            input.nextLine(); 
        } // DONE MAKING BOOKING
        
        // DISPLAY SUMMARY BOOKING
        
    //extends
        double totalBookingPrice = 0;
        String paidStatus ="Unpaid";
        System.out.printf("\n%40s %-10s\n","","All Bookings:");
        for (int i = 0; i < booking.size(); i++) {
            if(booking.get(i).getUserID().equals(ID) && booking.get(i).getPaymentStatus().equals(paidStatus)){
            count++;
            System.out.printf("%40s %-10s\n","","Booking " + count + " Details:");
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
                System.out.printf("%40s %-10s\n","","< Total Bills for Booking " + count + ">");
                System.out.printf("%40s %-10s\n\n","","Total Booking Price: RM" + totalBookingPrice);
                booking.get(i).setTotalPriceInArray(totalBookingPrice);
            }else{
                totalBookingPrice = booking.get(i).getSelectedVenuePricing();
                System.out.printf("%40s %-10s\n","","< Total Bills for Booking " + count + " >");
                System.out.printf("%40s %-10s\n\n","","Total Booking Price: RM" + totalBookingPrice);
                booking.get(i).setTotalPriceInArray(totalBookingPrice);
            }
        }
    }
        
        //
        
        System.out.printf("\n%40s %-10s\n","","You Have Done Your Booking. Select Option Below:");
        System.out.printf("%40s %-10s\n","","Enter 1 : Make Payment");
        System.out.printf("%40s %-10s\n","","Enter 2 : Save and Exit Booking. Pay Next Time");
        System.out.printf("%40s %-10s","","Enter your choice: ");
        paymentChoice = input.nextInt();
        
        while(paymentChoice!=1 && paymentChoice!=2 ){
            System.out.printf("%40s %-10s","","Invalid choice please try again: ");
            paymentChoice = input.nextInt();
        }
        if(paymentChoice == 1){
            Payment.MakePayment(booking, ID, payments);
        } 
    }
  
}