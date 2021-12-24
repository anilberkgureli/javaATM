package com.company;

import java.util.ArrayList;

/**
 * Created by taspinar on 25.12.2016.
 */
public class Costumers {

    private int ID;
    private String name;
    private String password;
    private double balance;
    private double USDbalance;


    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public double getBalance(){
        return balance;
    }
    public double getUSDBalance(){
        return USDbalance;
    }



    public void setID(int id){
        this.ID = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setUSDBalance(double balance){
        this.USDbalance = balance;
    }
}

