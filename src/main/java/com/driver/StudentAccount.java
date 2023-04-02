package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, double balance, String  institutionName) throws Exception {
        //minimum balance is 0 by default
        if(super.getBalance()<0) {
            throw new Exception("cannot be negative");
        }
        this.institutionName = institutionName;
    }

}
