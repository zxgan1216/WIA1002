package Tuto2;

import java.util.ArrayList;
import java.util.Random;

public class t2q8 {
    public static void printList(ArrayList<? extends Number> list){
        for (Number num:list){
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        Random rn=new Random();
        ArrayList<Integer> numOfCars = new ArrayList<>();
        ArrayList<Double> milesPerHour = new ArrayList<>();
        for (int i=0;i<5;i++){
            numOfCars.add(rn.nextInt(10));
            milesPerHour.add(rn.nextDouble(10.0));
        }
        printList(numOfCars);
        printList(milesPerHour);
    }
}
//q9
// When the compiler encounters a generic class, interface, or method with an unbound type
// parameter, such as <T> or <E>, it replaces all occurrences of the type parameter with what
// type?

// Object

//q10
// When the compiler encounters a generic class, interface, or method with a bound type
// parameter, such as <T extends Number> or <E extends Comparable>, it replaces all
// occurrences of the type parameter with what type?

// Bounded type, i.e Number and Comparable