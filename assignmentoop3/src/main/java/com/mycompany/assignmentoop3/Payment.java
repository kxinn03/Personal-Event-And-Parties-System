/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentoop3;

/**
 *
 * @author user
 */

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Xin Yi
 */
public class Payment{
    private int choice;
    private String cardNumber;
    private double tng = 0;
    private double boost = 0;
    private double grabPay = 0;
    private double discountAmount = 0;
    private double discountedPrice = 0;
    private double ttlBookAmt = 0;
    private String userID = "";
    private Booking bookings;
    Cuisine cuisine;
    Venue venue;
    //Constructor
    public Payment() {    
    } 
    public Payment(int choice, String cardNumber) {
        this.choice = choice;
        this.cardNumber = cardNumber;
    }
    
    //Getter
    public int getChoice() {
        return choice;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public double getTng() {
        return tng;
    }
    public double getBoost() {
        return boost;
    }
    public double getGrabPay() {
        return grabPay;
    }
    public double getDiscountAmount() {
        return discountAmount;
    }
    public double getDiscountedPrice() {
        return discountedPrice;
    }
    public String getUserID() {
        return userID;
    }
    public double getTtlBookAmt() {
        return ttlBookAmt;
    }

    
    //Setter
    public void setChoice(int choice) {
        this.choice = choice;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void setTng(double tng) {
        this.tng = tng;
    }
    public void setBoost(double boost) {
        this.boost = boost;
    }
    public void setGrabPay(double grabPay) {
        this.grabPay = grabPay;
    }
    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }
    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public void setTtlBookAmt(double ttlBookAmt) {
        this.ttlBookAmt = ttlBookAmt;
    }

    
    
    
    //Start here if user direct come from booking
    public static void MakePayment(List<Booking> booking, String ID, List<Payment> payments){
        Scanner input = new Scanner(System.in);
        Payment payment = new Payment();
        Profile profile = new Profile();
        int choice;
        int count = 0;
        int index =0;
        double totalbookingPrice = 0;
        for(int i=0;i<payments.size();i++){
           if(payments.get(i).getUserID().equals(ID)){
                count++;
            }
        }
        if(count == 0){
            payment.setUserID(ID);
            payments.add(payment);
        }
        System.out.println();
        System.out.println();
        System.out.printf("%77s %50s\n","","======= [ Complete Payment To Secure Your Booking ] =======");
        System.out.printf("%80s %50s\n",""," ! Make Payment Using E-Wallat To Get 5% OFF !\n");
        for(int i =0; i<booking.size(); i++){
            if(booking.get(i).getUserID().equals(ID) && booking.get(i).getPaymentStatus().equals("Unpaid")){
                totalbookingPrice += booking.get(i).getTotalPriceInArray();     
            }
        }     
        for(int i =0;i<payments.size();i++){
            if(payments.get(i).getUserID().equals(ID)){
                payments.get(i).setTtlBookAmt(totalbookingPrice);  
            }
        }   
 
        System.out.printf("%72s %50s\n","","Total Price You Needed To Pay: RM" + totalbookingPrice);   
        do{
            System.out.printf("%40s %-10s","","Select Your Payment Method\n");
            System.out.printf("%40s %-10s","","1. E-Wallet\n");
            System.out.printf("%40s %-10s","","2. Credit Card\n");
            System.out.printf("%40s %-10s","","3. Cash\n");
            System.out.printf("%38s %-10s","","4. Exit Online Payment Section\n\n");
            System.out.printf("%40s %-10s","","Enter your choice: ");
            choice = input.nextInt(); 
            switch(choice){
                    case 1: payment.EWallet(payments,ID,payment,booking); break;
                    case 2: CreditCard(payments, ID); break;
                    case 3: CashPayment(booking, ID, payments); break;
                    case 4: break;
                    default: System.out.printf("%40s %-10s","","Invalid Choice"); break;
            }
        }while(choice !=4);        
    }   
    
    public void EWallet(List<Payment> payments,String ID,Payment payment,List<Booking>booking){
        Scanner input = new Scanner(System.in);

        int eWalletChoice;
        System.out.printf("%40s %-10s\n","","Choose Your Preferred E-Wallat Merchant\n\n");
        System.out.printf("%40s %-10s",""," 1 -> Touch'n Go \n");
        System.out.printf("%40s %-10s",""," 2 -> Boost \n");
        System.out.printf("%40s %-10s",""," 3 -> GrabPay \n\n");
        System.out.printf("%40s %-10s","","Enter Your Choice: ");
        eWalletChoice = input.nextInt();
        switch(eWalletChoice){
            case 1 : 
                for(int i=0;i<payments.size();i++){
                    if(payments.get(i).getUserID().equals(ID)){
                    System.out.printf("%40s %-10s\n","","Your Touch'n Go E-Wallet Current Balance: RM" + payments.get(i).getTng());}
                }  
                payment.Topup(eWalletChoice,payments,ID,booking);
                break;
                
            case 2 : 
                for(int i=0;i<payments.size();i++){
                    if(payments.get(i).getUserID().equals(ID)){
                    System.out.printf("%40s %-10s\n","","Your Boost E-Wallet Current Balance: RM" + payments.get(i).getBoost());}
                }
                payment.Topup(eWalletChoice,payments,ID,booking);   
                break;
                
            case 3 : 
                 for(int i=0;i<payments.size();i++){
                    if(payments.get(i).getUserID().equals(ID)){
                    System.out.printf("%40s %-10s\n","","Your GrabPay E-Wallet Current Balance: RM" + payments.get(i).getGrabPay());}
                }
                payment.Topup(eWalletChoice,payments,ID,booking);
                break;
            default: 
                System.out.printf("%40s %-10s","","Invalid Choice");
                break;
       }
    } //END E-WALLET PART 
   

    public static void CreditCard(List<Payment> payments, String ID){  
       Scanner input = new Scanner(System.in);
       boolean cardNoValid = false;
       String cvv;
       String validThru;
       char yesno;
       char authorizationChoice;
       Pattern cardNum = Pattern.compile("^[0-9]{4}$");
       Pattern validCCV = Pattern.compile("^[0-9]{3}$");
       // C.CARD NUMBER PART
        for(int i=0; i<payments.size(); i++){
            if(payments.get(i).getUserID().equals(ID)){
                    
                System.out.printf("%40s %-10s","","Enter Your last 4-digit Credit Card Number :");
                String cardNumber = input.nextLine();
                while(cardNum.matcher(cardNumber).matches()!=true){
                    System.out.printf("%40s %-10s\n","","Credit Card Number Entered Is INVALID");
                    System.out.printf("%40s %-10s\n",""," ** It should contain 4 digit only");
                    cardNumber = input.nextLine();
                }

                payments.get(i).setCardNumber(cardNumber);
                System.out.printf("%40s %-10s\n","","Credit Card Number Entered Is VALID");   

                // C.CARD VALID THRU PART
                System.out.printf("%40s %-10s","","Enter Credit Card VALID THRU (Month/Year * year should not be less then 23): ");
                validThru = input.nextLine();

                while(isValidThru(validThru)!=true) {
                   System.out.printf("%40s %-10s","","Invalid Valid Thru format. Please use the format 'MM/YY'.");
                   validThru = input.nextLine();
                } 
                System.out.printf("%40s %-10s","","Credit Card - Valid.\n");

                // C.CARD CVV PART
                System.out.printf("%40s %-10s","","Enter Credit Card CVV: ");
                cvv = input.nextLine();
                while(validCCV.matcher(cvv).matches()!= true){
                System.out.printf("%40s %-10s","","Invalid CVV Format. CVV should be a 3-digit number.");
                cvv = input.nextLine();                            
                }
                System.out.printf("%40s %-10s","","Credit Card Authorised.\n");

                // Display Confirmation
                System.out.printf("%40s %-10s\n","","------------------------------------------------------");
                System.out.printf("%40s %-10s\n","","Payment Choice: Credit Card");
                System.out.printf("%40s %-10s\n","","Total Bills: RM" + payments.get(i).getTtlBookAmt());
                System.out.printf("%40s %-10s\n","","Credit Card Number: " + payments.get(i).getCardNumber());
                System.out.printf("%40s %-10s\n","","------------------------------------------------------");
                System.out.printf("%40s %-10s\n","","Confirm authorize this payment (Y/N):  ");
                authorizationChoice =  input.next().charAt(0);
                if(authorizationChoice == 'Y' || authorizationChoice == 'y'){
                    System.out.printf("%40s %-10s\n","","You Have Successfully Make Your Payment !");
                    payments.get(i).setTtlBookAmt(0);
                    break;
                }else{
                    System.out.printf("%75s %50s\n","","======= You Have Choose To End The Payment Section ======="); break;
                }        
            }
        } //END CREDIT CARD PART   
    }
    
    public static void CashPayment(List<Booking> booking, String ID, List<Payment> payments){
        Scanner input = new Scanner(System.in);
        Member member = new Member();
        char paymentChoice;
        int returnChoice;
        
        for(int i=0; i<payments.size(); i++){
            if(payments.get(i).getUserID().equals(ID)){
                System.out.printf("%40s %-10s\n","","Dear customers, you may complete your cash payment in our retail shops 3 days before ");
                System.out.printf("%40s %-10s\n\n","","Total Price You Needed To Pay: RM" + payments.get(i).getTtlBookAmt());
                System.out.printf("%40s %-10s\n",""," -- T&C --");
                System.out.printf("%40s %-10s\n","","1. Customers should complete their payment 3 days before their booking dates.");
                System.out.printf("%40s %-10s\n\n","","2. Payments must fully paid at once.");
                System.out.printf("%40s %-10s","","Confirm pay by cash? (Y/N): ");
                paymentChoice = input.next().charAt(0);
                if(paymentChoice == 'Y' || paymentChoice == 'y'){
                    payments.get(i).setTtlBookAmt(0);
                }else
                    System.out.printf("%40s %-10s\n","","Please choose your payment method");
                    break; 
            }
        }
    }
    

    // EXTRA METHOD    
    //  1. Calculate Discount
    public static void Discount(String ID, List<Payment> payments) {
        double discountAmount;
        double discountedPrice;
        for(int i =0; i<payments.size(); i++){
            if(payments.get(i).getUserID().equals(ID)){
                discountAmount = payments.get(i).getTtlBookAmt() * 0.05; // 5% discount
                discountedPrice = payments.get(i).getTtlBookAmt() - discountAmount;  
                payments.get(i).setDiscountedPrice(discountedPrice);
                
                System.out.printf("%80s %50s\n","","Total Price You Needed To Pay: RM" + payments.get(i).getTtlBookAmt());
                System.out.printf("%80s %50s\n","","Discount Applied: RM" + discountAmount);
                System.out.printf("%80s %50s\n\n","","Discounted Price You Need To Pay: RM" + discountedPrice);
            }
        } 
    }
    
    // 2. Topup
    public static void Topup(int choice,List<Payment> payments,String ID,List<Booking> booking) {
        Payment payment = new Payment();
        Scanner input = new Scanner(System.in);
        double topup;
        double latestTopupAmt = 0;
        double saveTopupAmt = 0;
        int noTopupChoie;
        char confirm;
        System.out.println();
        System.out.printf("%40s %-10s","","Do you want to topup (Y/N): ");
        confirm = input.next().charAt(0);
        if (confirm == 'Y' || confirm == 'y'){
            switch (choice) {
            case 1:
                System.out.println();
                System.out.printf("%40s %-10s","","Enter Top Up Amount: ");
                topup = input.nextDouble();  
                for(int i=0;i<payments.size();i++){
                    if(payments.get(i).getUserID().equals(ID)){
                        if(payments.get(i).getTng() < 0){
                            payments.get(i).setTng(topup);
                        }else{
                            latestTopupAmt += payments.get(i).getTng();
                            saveTopupAmt = latestTopupAmt + topup;
                            payments.get(i).setTng(saveTopupAmt);
                        }
                    }
                }
                payment.AfterTopup(choice,payments,ID,booking); // Pass the choice
                break;
                
            case 2:
                    System.out.printf("%40s %-10s","","Enter Top Up Amount: ");
                    topup = input.nextDouble();
                     for(int i=0; i<payments.size(); i++){
                        if(payments.get(i).getUserID().equals(ID)){
                             payments.get(i).setBoost(topup);
                        }
                    }
                    payment.AfterTopup(choice,payments,ID,booking); // Pass the choice
                break;
                
            case 3:
                    System.out.printf("%40s %-10s","","Enter Top Up Amount: ");
                    topup = input.nextDouble();
                    for(int i=0;i<payments.size();i++){
                        if(payments.get(i).getUserID().equals(ID)){
                             payments.get(i).setGrabPay(topup);
                        }
                    }
                    payment.AfterTopup(choice,payments,ID,booking); // Pass the choice
                break;
            }
        }else{
            System.out.printf("%40s %-10s\n","","1. Proceed To Payment");
            System.out.printf("%40s %-10s\n","","2. Exit Topup Section");
            System.out.printf("%40s %-10s","","Enter You Choice: ");
            noTopupChoie = input.nextInt();
            if(noTopupChoie == 1){
                payment.EWalletPayment(choice,payments,ID,booking);
                
            }
        } 
    }

    // 3. topup validate and check balance
    public void AfterTopup(int choice, List<Payment>payments, String ID,List<Booking>booking) { // Accept the choice parameter
        Scanner input = new Scanner(System.in);
        String pinNumber;
        char checkBlcChoice;
        char proceedPaymentChoice;

        System.out.printf("%40s %-10s","","Enter Your 6 Digit PIN Number: ");
        pinNumber = input.nextLine();
        while(isValidPIN(pinNumber) != true){
            System.out.printf("%40s %-10s","","Invalid PIN format. Please enter a 6-digit PIN: ");
            pinNumber = input.nextLine();
        }

        System.out.printf("%40s %-10s\n","","You Have Successfully Topped Up Your E-wallet!\n");
        System.out.printf("%40s %-10s","","Do you want to check the latest balance? (Y/N): ");
        checkBlcChoice = input.next().charAt(0);
        input.nextLine();
        while(checkBlcChoice !='N' && checkBlcChoice != 'Y' && checkBlcChoice !='n' && checkBlcChoice !='y'){
            System.out.printf("%40s %-10s","","Invalid choice. Please enter again: ");
            checkBlcChoice = input.next().charAt(0);
        }
        if (checkBlcChoice == 'Y' || checkBlcChoice == 'y') {
            System.out.printf("%50s %-10s\n", "","****  E-wallet Balance (RM)****");
            System.out.printf("%50s%-17s%-15s%-15s\n","", "Touch'N GO", "Boost", "GrabPay");
            for(int i = 0; i<payments.size(); i++){
                if(payments.get(i).getUserID().equals(ID)){
                    System.out.printf("%50s%-17s%-15s%-15s\n\n", "", payments.get(i).getTng(), payments.get(i).getBoost(), payments.get(i).getGrabPay());
                }
            }
        }
        System.out.printf("%40s %-10s","","Proceed Your Payment? (Y/N): ");
        proceedPaymentChoice = input.next().charAt(0);
        while(proceedPaymentChoice !='N' && proceedPaymentChoice != 'Y' && proceedPaymentChoice !='n' && proceedPaymentChoice !='y'){
            System.out.printf("%40s %-10s","","Invalid choice. Please enter again: ");
            proceedPaymentChoice = input.next().charAt(0);
        }
        if(proceedPaymentChoice == 'Y' || proceedPaymentChoice == 'y'){
            EWalletPayment(choice, payments, ID,booking);
        } 

    }
    
    // 4. E-wallet Payment
    public void EWalletPayment(int choice, List<Payment>payments, String ID, List<Booking>booking){
        Scanner input = new Scanner(System.in); 
        Payment payment = new Payment();
        Member member = new Member();
        String pinNumber;
        double newBalance;
        int exitChoice;
        
//        Discount(ID, payments);
        for(int i=0; i<payments.size(); i++){
            if(payments.get(i).getUserID().equals(ID) && payments.get(i).getTtlBookAmt() != 0.0 ){
                Discount(ID, payments);
                System.out.printf("%40s %-10s","","Pay Now By Entering Your 6 digit PIN Number: ");
                pinNumber = input.nextLine(); 
                while(isValidPIN(pinNumber) != true){
                    System.out.printf("%40s %-10s","","Invalid PIN format. Please enter a 6-digit PIN: ");
                    pinNumber = input.nextLine(); 
                }
                switch(choice){
                    case 1:
                        if(payments.get(i).getTng() >= payments.get(i).getDiscountedPrice()){
                            System.out.printf("%40s %-10s\n","","You Have Successfully Paid Using Touch'N GO With The Amount RM" + payments.get(i).getDiscountedPrice());
                            newBalance = payments.get(i).getTng() - payments.get(i).getDiscountedPrice();
                            payments.get(i).setTng(newBalance);
                            payments.get(i).setTtlBookAmt(0);

                        } else {
                            System.out.printf("%40s %-10s","","Insufficient Balance, Please Topup Your Touch'N Go E-Wallet");
                            Topup(choice,payments,ID,booking);
                        }
                        break;
                    case 2: 
                        if(payments.get(i).getBoost() >=  payments.get(i).getDiscountedPrice()){
                            System.out.printf("%40s %-10s","","You Have Successfully Paid Using Boost With The Amount RM" + payments.get(i).getDiscountedPrice());
                            newBalance = payments.get(i).getBoost() - payments.get(i).getDiscountedPrice();
                            payments.get(i).setBoost(newBalance);
                            payments.get(i).setTtlBookAmt(0);
                        } else {
                            System.out.printf("%40s %-10s","","Insufficient Balance, Please Topup Your Boost E-Wallet");
                            Topup(choice,payments,ID,booking);
                        }
                        break;
                    case 3: 
                        if(payments.get(i).getGrabPay() >=  payments.get(i).getDiscountedPrice()){
                            System.out.printf("%40s %-10s","","You Have Successfully Paid Using GrabPay With The Amount RM" + payments.get(i).getDiscountedPrice());
                            newBalance = payments.get(i).getBoost() - payments.get(i).getDiscountedPrice();
                            payments.get(i).setGrabPay(newBalance);
                            payments.get(i).setTtlBookAmt(0);
                        } else {
                            System.out.printf("%40s %-10s","","Insufficient Balance, Please Topup Your Boost E-Wallet");
                            Topup(choice,payments,ID,booking);
                        }
                        break;
                    }
                    for(Booking  bookings : booking){
                        if(bookings.getPaymentStatus()== "Unpaid"){
                            bookings.setPaymentStatus("Paid");
                        }
                    }
                    System.out.printf("%90s %-10s\n","","1. Exit");
                    System.out.printf("%90s %-10s\n","","2. Check Balance");
                    System.out.printf("%40s %-10s","","Enter Your Choice : ");
                    exitChoice = input.nextInt();
                    if(exitChoice == 2){
                        payment.EWallet(payments, ID, payment,booking);
                    }else{
                        break;}
            }else{
                System.out.printf("%40s %-10s\n\n","","No booking Needed To Be Pay");
                break;
            }
        }
        
    }
    
    //  5.  C.Card ValidThru
    public static boolean isValidThru(String validThru) {
        // Check if VT matches the "MM/YY" format
        return validThru.matches("^([0-1]{1})+([0-9]{1})/([2-9]{1})+([4-9]{1})$");
    }
    
    //  5.  C.Card Valid PIN
    public static boolean isValidPIN(String pin) {
        String pinString = String.valueOf(pin);
        if(pinString.matches("^[0-9]{6}$")){
            return true;  
        }else
            return false;
    }

}