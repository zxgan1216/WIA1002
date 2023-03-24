package L1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class L1Q2 {
    public static void main(String[] args) throws IOException {
        data[] data=new data[1];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<data.length;i++){
            int num_char=0;
            System.out.println("Enter the file name");
            String name=sc.nextLine();
            System.out.println("Enter the separate character");
            String character= sc.nextLine();

            data[i]=new data(name,character);
            Scanner scanner=new Scanner(new FileInputStream(data[i].file));
            while (scanner.hasNextLine()){
                String line1=scanner.nextLine();
                String[] line2=line1.split(data[i].character_sep);
                for (String line:line2){
                    System.out.print(line);
                    num_char++;
                }
                System.out.println();
            }
            System.out.println("num char ="+num_char);
        }

    }
}

class data{
    String file;
    String character_sep;

    public data(String file,String character_sep){
        this.file=file;
        this.character_sep=character_sep;
    }
}
