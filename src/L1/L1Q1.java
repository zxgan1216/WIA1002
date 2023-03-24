package L1;

import java.io.*;
import java.util.Scanner;

public class L1Q1 {
    public static void main(String[] args) throws IOException {
        //part 1
        Scanner sc=new Scanner(new FileInputStream("/Users/zxgan/Downloads/Gan Zi Xiang_22004732.txt"));
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
        sc.close();
        
        //part 2
        Scanner scanner=new Scanner(System.in);
        PrintWriter writer =new PrintWriter(new FileWriter("/Users/zxgan/Downloads/Gan Zi Xiang_22004732.txt",true));
        writer.println("Thursday, 18 June 2021");
        System.out.println("Add something");
        String line=scanner.nextLine();
        writer.println(line);
        writer.close();

        Scanner input=new Scanner(new FileInputStream("/Users/zxgan/Downloads/Gan Zi Xiang_22004732.txt"));
        while (input.hasNextLine()){
            System.out.println(input.nextLine());
        }
        input.close();
    }
}
