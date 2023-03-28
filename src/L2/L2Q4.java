package L2;

import java.util.ArrayList;

public class L2Q4 {
//    public static <T extends Comparable<T>> String minMax(T[] arr){
//        T min=arr[0],max=arr[0];
//        for (T t:arr){
//            if (t.compareTo(max) > 0) max = t;
//            if (t.compareTo(min) < 0) min = t;
//        }
//        return "Max = "+max +" Min = "+min;
//    }

    public static void main(String[] args) {
        Integer[] intArray={5,3,7,1,4,9,8,2};
        String[] strArray = {"red", "blue", "orange", "tan"};
        System.out.println(findMinMax.compareTo(intArray));
        System.out.println(findMinMax.compareTo(strArray));

//        System.out.println(minMax(intArray));
//        System.out.println(minMax(strArray));
    }
}

class findMinMax<T extends Comparable<T>>{
    T[] arr;
    findMinMax(T[] arr){
        this.arr=arr;
    }

    public static <T extends Comparable<T>> String compareTo(T[] arr){
        T min=arr[0],max=arr[0];
        for (T t:arr){
            if (t.compareTo(max) > 0) max = t;
            if (t.compareTo(min) < 0) min = t;
        }
        return "Max = "+max +" Min = "+min;
    }
}