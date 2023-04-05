package Tuto3;

import java.util.Scanner;

public class T3Q1 {
    public static void main(String[] args) {
        new candyMachine();
    }
}

class Dispenser{
    private String item_name;
    private Double item_price;
    private int item_stock;
    private int cart;

    Dispenser(String item_name,Double item_price,int item_stock){
        this.item_name=item_name;
        this.item_price=item_price;
        this.item_stock=item_stock;
        this.cart=0;
    }

    public String getItem_name() {
        return item_name;
    }

    public Double getItem_price() {
        return item_price;
    }

    public int getItem_stock() {
        return item_stock;
    }

    public int getCart() {
        return cart;
    }

    public void deduceStock(int deduce){
        this.item_stock-=deduce;
    }

    public boolean addToCart(int num){
        if (num>this.item_stock){
            System.out.println("Out of Stock");
            return false;
        }
        else{
            cart+=num;
            return true;
        }
    }
}

class cashRegister{
    Scanner sc=new Scanner(System.in);
    private double cashIn;
    private double totalPrice;
    private double change;

    public double getCashIn() {
        return cashIn;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getChange() {
        return change;
    }

    cashRegister(){
        this.cashIn=0;
        this.totalPrice=0;
        this.change=0;
    }

    public void total(double price){
        this.totalPrice+=price;
    }
    public void pay(){
        System.out.println("Enter the cash amount");
        this.cashIn=sc.nextDouble();
        this.totalPrice-=cashIn;
        while (this.totalPrice>0){
            System.out.println("Not enuf amount of money");
            System.out.println("Balance fee : "+this.totalPrice);
            System.out.println("Enter the cash amount");
            this.cashIn=sc.nextDouble();
            this.totalPrice-=cashIn;
        }
        if (this.totalPrice<0){
            this.change=-(this.totalPrice);
            System.out.println("Change = "+this.change);
            this.totalPrice=0;
        }
    }
}

class candyMachine{
    static Scanner sc = new Scanner(System.in);
    Dispenser[] disps = {new Dispenser("candy", 0.5, 18), new Dispenser("chip", 2.8, 15), new Dispenser("gum", 1.0, 30), new Dispenser("cookie", 2.2, 8)};
    cashRegister cash = new cashRegister();

    public candyMachine(){
        display();
    }

    public void display(){
        System.out.printf("%-10s%-5s%-5s\n", "Item", "Price", "Stock");
        for (Dispenser d : disps) {
            System.out.printf("%-10s%-5.2f%-5d\n",d.getItem_name(),d.getItem_price(),d.getItem_stock());
        }
        select();
    }

    public void select(){
        System.out.println("Select the items you want (0:Candy 1:Chip 2:Gum 3:Cookie): ");
        int item_chosen=sc.nextInt();
        System.out.println("Enter number of items");
        int num_item=sc.nextInt();
        if(disps[item_chosen].addToCart(num_item)){
            cash.total(disps[item_chosen].getItem_price()*num_item);
        }

        System.out.println("Continue (y/n)");
        char con=sc.next().charAt(0);
        if (con=='y'){
            select();
        }
        else{
            pay();
        }
    }

    public void pay(){
        System.out.println("Total price = "+cash.getTotalPrice());
        cash.pay();
    }

    public void dispense(){
        System.out.println("\nDispensing...");
        for (Dispenser d : disps) {
            if (d.getCart() > 0) {
                System.out.println(d.getItem_name() + ": " + d.getCart());
                d.deduceStock(d.getCart());
            }
        }
    }
}