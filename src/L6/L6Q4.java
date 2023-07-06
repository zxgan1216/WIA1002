package L6;

import java.util.Scanner;

public class L6Q4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MyStack<Character> stringReverse=new MyStack<>();
        String normal;
        do{
            normal=sc.nextLine();
        } while(normal.length()>15);

        for (int i=0;i<normal.length();i++){
            stringReverse.push(normal.charAt(i));
        }


        String reverse="";
        int size= stringReverse.getSize();
        for (int i=0;i<size;i++){
            reverse+=stringReverse.pop();
        }

        System.out.println(reverse.equals(normal)?"is palindrome":"not palindrome");
    }
}