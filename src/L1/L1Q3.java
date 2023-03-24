package L1;

import java.util.Date;

public class L1Q3 {
    public static void main(String[] args) {
        Account acc=new Account(1122,20000);
        acc.setAnnualInterestRate(4.5);
        acc.withdraw(2500);
        acc.deposit(3000);
        System.out.printf("Balance = %f Monthly Interest = %f \n",acc.getBalance(),acc.getMonthlyInterest());
        System.out.println("Date : "+acc.getDateCreated());
    }
}

class Account{
    private int id=0;
    private double balance=0;
    private static double annualInterestRate=0;
    private Date dateCreated=new Date();
    Account(){}
    Account(int id,double  balance){
        this.id=id;
        this.balance=balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public static double getMonthlyInterestRate(){
        return annualInterestRate/12;
    }

    public double getMonthlyInterest(){
        return (Account.getMonthlyInterestRate()/100)*balance;
    }

    public void deposit(double deposit){
        if (deposit>0) balance+=deposit;
    }
    public void withdraw(double withdraw){
        if (withdraw<this.balance) balance-=withdraw;
    }
}