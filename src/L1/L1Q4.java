package L1;

import java.util.ArrayList;
import java.util.Date;

public class L1Q4 {
    public static void main(String[] args) {
        Account1 account1=new Account1("George",1122,1000);
        account1.setAnnualInterestRate(1.5);
        account1.deposit(30.00);
        account1.deposit(40.00);
        account1.deposit(50.00);
        account1.withdraw(5);
        account1.withdraw(4);
        account1.withdraw(2);
        System.out.printf("Name = %s Interest rate = %.2f Balance = %.2f\n",account1.getName(),account1.getAnnualInterestRate(),account1.getBalance());
        for (Transaction trs: account1.getTransactions()){
            System.out.println(trs.getDescription());
        }
    }
}
class Account1 extends Account{
    ArrayList<Transaction> transactions=new ArrayList<>();
    private String name;
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account1(String name, int id, double balance) {
        super(id, balance);
        this.name=name;
    }

    @Override
    public void deposit(double deposit) {
        super.deposit(deposit);
        String description=String.format("Deposit with amount %.2f and the balance after the transaction %.2f",deposit,getBalance());
        transactions.add(new Transaction(getDateCreated(),'D',deposit,getBalance(),description));
    }

    @Override
    public void withdraw(double withdraw) {
        super.withdraw(withdraw);
        String description=String.format("Withdraw with amount %.2f and the balance after the transaction %.2f",withdraw,getBalance());
        transactions.add(new Transaction(getDateCreated(),'D',withdraw,getBalance(),description));
    }
}

class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Transaction(Date date, char type, double amount, double balance, String description) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

}