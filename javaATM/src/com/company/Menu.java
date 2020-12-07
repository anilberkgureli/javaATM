package com.company;

import java.beans.Customizer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by taspinar on 25.12.2016.
 */
public class Menu {

    private static ArrayList<Costumers> accounts;

    public static Costumers GetCostumer(int costumerID){

        boolean found = false;
        Costumers foundCostumer = new Costumers();

        for(Costumers ac: accounts) {
            if(ac.getID() == costumerID){
                found =  true;
                foundCostumer = ac;
            }
        }

        return foundCostumer;
    }

    public static ArrayList<Costumers> GetCustomers(){

        return  accounts;

    }

    public static void SetCustomers(){

        accounts = new ArrayList<Costumers>();

        Costumers costumerA = new Costumers();
        costumerA.setID(2032);
        costumerA.setName("CAN TAŞPINAR");
        costumerA.setPassword("123456");
        costumerA.setBalance(12000.0);
        costumerA.setUSDBalance(500.0);
        accounts.add(costumerA);

        Costumers costumerB = new Costumers();
        costumerB.setID(2033);
        costumerB.setName("ATAMER ŞAHİN");
        costumerB.setPassword("1234567");
        costumerB.setBalance(12000.0);
        costumerB.setUSDBalance(500.0);
        accounts.add(costumerB);

        Costumers costumerC = new Costumers();
        costumerC.setID(2034);
        costumerC.setName("ANIL BERK GÜRELİ");
        costumerC.setPassword("12345678");
        costumerC.setBalance(12000.0);
        costumerC.setUSDBalance(500.0);
        accounts.add(costumerC);
    }

    public static void showOptions(Costumers a){

        Scanner scn = new Scanner(System.in);

        System.out.println(a.getName());
        System.out.println();

        System.out.println("Enter 1 To Withdraw Money");
        System.out.println("Enter 2 To Enter Money");
        System.out.println("Enter 3 To Exchange");
        System.out.println("Enter 4 To Transfer Money");
        System.out.println("Enter 5 To Logout");

        switch(scn.nextInt()){
            case 1:
                navigateConsole();
                withdrawMoney(a);
                break;
            case 2:
                navigateConsole();
                enterMoney(a);
                break;
            case 3:
                navigateConsole();
                exchangeMoney(a);
                break;
            case 4:
                transferMoney(a);
                break;
            case 5:
                logoutAccount(a);
                break;
            default:
                logoutAccount(a);
                break;
        }

    }
    public static void authMenu (){

        Scanner scn = new Scanner(System.in);

        System.out.println("Welcome, please login or create an account first.");
        System.out.println("Enter 1 To Login");
        System.out.println("Enter 2 To Create An Account");

        switch(scn.nextInt()){
            case 1:
                navigateConsole();
                System.out.println("Account ID: ");
                int acID = scn.nextInt();
                System.out.println("Account Password: ");
                String acPassword = scn.next();
                LoginToAccount(acID,acPassword, GetCustomers());
                break;
            case 2:
                navigateConsole();
                scn.nextLine();
                System.out.println("Account Name: ");
                String aName = scn.nextLine();
                System.out.println("Account ID: ");
                int aID = scn.nextInt();
                System.out.println("Account Password: ");
                String aPassword = scn.next();
                System.out.println("Account Balance: ");
                double aBalance = scn.nextDouble();
                System.out.println("US Account Balance: ");
                double aUSBalance = scn.nextDouble();
                CreateAccount(aName,aID, aPassword, aBalance,aUSBalance);
                break;
            default:
                authMenu();
                break;

        }


    }

    public static void CreateAccount(String name, int accountID, String accountPassword, double balance, double USBalance){

        Costumers newCstmr = new Costumers();

        newCstmr.setName(name);
        newCstmr.setID(accountID);
        newCstmr.setPassword(accountPassword);
        newCstmr.setBalance(balance);
        newCstmr.setUSDBalance(USBalance);

        boolean exists = false;

        for(Costumers ac: accounts) {
            if(ac.getID() == newCstmr.getID()){
                exists =  true;
            }
        }

        if(!exists){
            accounts.add(newCstmr);
        }else{
            navigateConsole();
            System.out.println("User with id " + newCstmr.getID() + " is already our costumer");
            authMenu();
        }


        navigateConsole();

        System.out.println("You have succesfully registered to our bank");
        showOptions(newCstmr);

    }

    public static void LoginToAccount(int accountID, String accountPassword, ArrayList<Costumers> customerList){

        boolean loggedIn = false;

        Costumers currentCostumer = new Costumers();

        for(Costumers ac: customerList) {
           if(ac.getID() == accountID  && ac.getPassword().equals(accountPassword)){
                loggedIn =  true;
               navigateConsole();
               currentCostumer = ac;
           }
        }

        if(loggedIn){
            System.out.println("You have logged in");
            showOptions(currentCostumer);
        }else {
            navigateConsole();
            System.out.println("Error, turn back to menu");
            authMenu();
        }

    }

    public static void withdrawMoney(Costumers a){

        Scanner scn = new Scanner(System.in);

        System.out.println("Your current balance is: " + a.getBalance() + " TL");
        System.out.print("Enter the amount you want to withdraw: ");
        double amnt = scn.nextDouble();
        if(amnt <= a.getBalance()){

            a.setBalance(a.getBalance()-amnt);
            System.out.println("RECIPT");
            System.out.println("Account Name: " + a.getName());
            System.out.println("Withdraw Amount: " + amnt + " TL");
            System.out.println("Remaining Balance: " + a.getBalance() + " TL");

            System.out.println("Enter 1 for other Actions, 2 for Logout");

            switch(scn.nextInt()){
                case 1:
                    navigateConsole();
                    showOptions(a);
                    break;
                case 2:
                    logoutAccount(a);
                    break;
                default:
                    logoutAccount(a);
                    break;
            }

        }else{

            navigateConsole();
            System.out.println("Insufficient Ballance!");
            showOptions(a);
            System.out.println("Insufficient Ballance!");

        }


    }

    public static void enterMoney(Costumers a){

        Scanner scn = new Scanner(System.in);

        System.out.println("Your current balance is: " + a.getBalance() + " TL");
        System.out.println("Enter the amount you want to enter: ");
        double amnt = scn.nextDouble();

        a.setBalance(a.getBalance()+amnt);
        System.out.println("RECIPT");
        System.out.println("Account Name: " + a.getName());
        System.out.println("Entered Money: " + amnt + " TL");
        System.out.println("Total Balance: " + a.getBalance() + " TL");

        System.out.println("Enter 1 for other Actions, 2 for Logout");

        switch(scn.nextInt()){
            case 1:
                navigateConsole();
                showOptions(a);
                break;
            case 2:
                logoutAccount(a);
                break;
            default:
                logoutAccount(a);
                break;

        }

    }

    public static  void exchangeMoney(Costumers a){
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter 1 --> TL to USD");
        System.out.println("Enter 2 --> USD to TL");
        System.out.println("Enter 3 to turn back");

        double exchangeRate = 3.51;


        switch(scn.nextInt()){
            case 1:
                System.out.println("Your current balance is: " + a.getBalance() + " TL");
                System.out.println("Enter the amount in USD you want to exchange: ");
                double amnt = scn.nextDouble();
                double finalAmnt = amnt*exchangeRate;
                if(finalAmnt <= a.getBalance()) {

                    a.setBalance(a.getBalance()-finalAmnt);
                    a.setUSDBalance(a.getUSDBalance() + amnt);
                    System.out.println("RECIPT");
                    System.out.println("Account Name: " + a.getName());
                    System.out.println("Exchange Rate: " + exchangeRate);
                    System.out.println("Exchanged Amount: " + amnt + " USD" + "(" + finalAmnt + " TL" + ")" );
                    System.out.println("USD Balance: " + a.getUSDBalance() + " USD");
                    System.out.println("TL Balance: " + a.getBalance() + " TL");
                    System.out.println("Enter 1 for other Actions, 2 for Logout");

                    switch(scn.nextInt()){
                        case 1:
                            navigateConsole();
                            showOptions(a);
                            break;
                        case 2:
                            logoutAccount(a);
                            break;
                        default:
                            logoutAccount(a);
                            break;

                    }

                }else{
                    navigateConsole();
                    System.out.println("Insufficient TL Ballance!");
                    showOptions(a);
                    System.out.println("Insufficient TL Ballance!");
                }

                break;
            case 2:

                System.out.println("Your current balance is: " + a.getUSDBalance() + " USD");
                System.out.println("Enter the amount in USD you want to exchange: ");
                double amnt2 = scn.nextDouble();
                double finalAmnt2 = amnt2*exchangeRate;

                a.setBalance(a.getBalance()+finalAmnt2);
                a.setUSDBalance(a.getUSDBalance() - amnt2);
                System.out.println("RECIPT");
                System.out.println("Account Name: " + a.getName());
                System.out.println("Exchange Rate: " + exchangeRate);
                System.out.println("Exchanged Amount: " + amnt2 + " USD" + "(" + finalAmnt2 + " TL" + ")" );
                System.out.println("USD Balance: " + a.getUSDBalance() + " USD");
                System.out.println("TL Balance: " + a.getBalance() + " TL");
                System.out.println("Enter 1 for other Actions, 2 for Logout");

                switch(scn.nextInt()){
                    case 1:
                        navigateConsole();
                        showOptions(a);
                        break;
                    case 2:
                        logoutAccount(a);
                        break;
                    default:
                        logoutAccount(a);
                        break;

                }

                break;
            default:
                showOptions(a);
                break;

        }


    }

    public static void transferMoney(Costumers a){

        Scanner scn = new Scanner(System.in);

        navigateConsole();
        System.out.println("Your current balance is: " + a.getBalance() + " TL");
        System.out.println("Enter the amount you want to transfer: ");
        double amnt = scn.nextDouble();
        if(amnt <= a.getBalance()) {
            System.out.println("Enter the recipent ID: ");
            int recipentID = scn.nextInt();
            Costumers cstmr = GetCostumer(recipentID);
            if(cstmr != null){

                a.setBalance(a.getBalance()-amnt);
                cstmr.setBalance(cstmr.getBalance()+amnt);
                System.out.println("RECIPT");
                System.out.println("FROM " + a.getName() + " TO " + cstmr.getName());
                System.out.println("Amount Transfered: " + amnt + " TL");
                System.out.println("Remaining Balance: " + a.getBalance() + " TL");

                System.out.println("Enter 1 for other Actions, 2 for Logout");

                switch(scn.nextInt()){
                    case 1:
                        navigateConsole();
                        showOptions(a);
                        break;
                    case 2:
                        logoutAccount(a);
                        break;
                    default:
                        logoutAccount(a);
                        break;
                }

            }else{
                navigateConsole();
                System.out.println("Cant Find Customer With ID " + recipentID);
                showOptions(a);
            }

        }else{
            navigateConsole();
            System.out.println("Insufficient Ballance!");
            showOptions(a);
        }
    }

    public static  void logoutAccount(Costumers a){

        navigateConsole();
        System.out.println("Goodbye, " + a.getName());
        authMenu();

    }

    public static void navigateConsole(){
        for (int i = 0; i < 50; ++i)
            System.out.println();
    }



}
