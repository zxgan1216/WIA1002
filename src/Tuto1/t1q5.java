package Tuto1;

import java.util.ArrayList;

public class t1q5 {
    public static void main(String[] args) {
        BankAccount bank=new BankAccount(100);
        bank.deposit(1000);
        System.out.println(bank.withdraw(1000000));
        System.out.println(bank.withdraw(100));
        System.out.println(bank.getBalance());
    }
}

interface Account{
    int deposit(int deposit);
    boolean withdraw(int withdraw);
}

class BankAccount implements Account{
    protected int balance;

    BankAccount(int balance){
        this.balance=balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public int deposit(int deposit) {
        return this.balance+=deposit;
    }

    @Override
    public boolean withdraw(int withdraw) {
        if (withdraw>this.balance){
            return false;
        }
        else {
            this.balance-=withdraw;
            return true;
        }
    }
}