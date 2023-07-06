package LabTest2;

import java.io.*;
import java.util.*;

/* 30mins
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */




class Solution {


    static int question1(String s,char ch) {
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==ch){
                count++;
            }
        }
        return count;
    }



    static int[] question2(int[] arr) {
        ArrayList<Integer> arr_list=new ArrayList<>();
        for (int i:arr){
            if (!arr_list.contains(i)){
                arr_list.add(i);
            }
        }
        int result[] = new int[arr_list.size()];
        for (int i=0;i<result.length;i++){
            result[i]=arr_list.get(i);
        }
        return result;
    }






    static int[] question3(int[] arr) {
        int max=arr[0];
        int min=arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i]>max) max=arr[i];
            if (arr[i]<min) min=arr[i];
        }
        ArrayList<Integer> list=new ArrayList<>();
        list.add(min);
        list.add(max);
        for (int i:arr){
            if (!list.contains(i)){
                list.add(i);
            }
        }
        int result[] = new int[list.size()];
        for (int i=0;i<result.length;i++){
            result[i]=list.get(i);
        }
        return result;
    }



    static String question4(String s) {
        String result="";


        return result;
    }


    static String[] question5(String[] countries) {
        // write your code here
        for (int i=0;i< countries.length;i++){
            countries[i]=Character.toUpperCase(countries[i].charAt(0))+countries[i].substring(1);
        }
        ArrayList<String> list=new ArrayList<>();
        for (String s:countries){
            if (s.equals("Malaysia")){
                list.add(s);
            }
        }
        for (String s:countries){
            if (!list.contains(s)){
                list.add(s);
            }
        }
        for (int i=0;i< list.size();i++){
            countries[i]= list.get(i);
        }
        return countries;
    }


    public static void main(String[] args) {
        String s1="Good Luck";

        System.out.printf("Question 1: %s\n", question1(s1,'o'));


        //2. remove duplicates from an array arr[] without using library
        int arr[] = {50, 10,20,20,30,30,40,50,50, 60, 60, 60};
        System.out.printf("Question 2: %s\n", Arrays.toString(question2(arr)));


        //3. write a method to find largest and smallest number in an unsorted integer array arr2[] and return array whereas smallest as first element and biggest and second element.
        int arr2[] = {123,555,432,765,30,123,2000,8000, 999};
        System.out.printf("Question 3: %s\n", Arrays.toString(question3(arr2)));


        //4. print duplicate characters from a string
        String s2="testingoooggg";
        System.out.printf("Question 4: %s\n", question4(s2));

        //5. Create a method to sort the countries as below.
        //a. Capitalized first letter in a sentence.
        //b. Sort countries alphabetically from A to Z.
        //c. Country ‘Malaysia’ must be first of the sort.
        String[] countries = new String[]{"singapore", "malaysia", "china", "india", "australia"};
        System.out.printf("Question 5: %s\n", Arrays.toString(question5(countries)));

    }
}