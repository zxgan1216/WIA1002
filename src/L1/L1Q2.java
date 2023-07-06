package L1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class L1Q2 {
    public static void main(String[] args) {
        String fileName = "";
        String pattern = "";
        for(int i = 1 ; i<=4 ; i++){
            System.out.println();
            fileName = String.format("/Users/zxgan/eclipse-workspace/WIA1002/src/L1/text%d.txt",i);
            switch(i){
                case 1 -> pattern = ",";
                case 2 -> pattern = ", ";
                case 3 -> pattern = "; ";
                case 4 -> pattern = "\\d+";
            }

            try{
                Scanner sc = new Scanner(new FileInputStream(fileName));
                String finalLine = "";
                int charCount = 0;
                while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    if(i<=3){
                        String[] words = line.split(pattern);
                        finalLine = String.join("", words);
                    }
                    else{
                        finalLine = line.replaceAll(pattern , "");
                    }

                    charCount += finalLine.length();
                    System.out.println(finalLine);
                }
                System.out.println("Total number of characters: " + charCount);
                sc.close();

            }catch(FileNotFoundException e){
                System.out.println("File not found");
            }
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
