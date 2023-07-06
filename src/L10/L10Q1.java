package L10;

import java.util.Arrays;

public class L10Q1 {
    public static int[] selectionSortSamllest(int[] arr){
        for (int i=0;i< arr.length-1;i++){
            int currentMin=arr[i];
            int currentMinIndex=i;
            for (int j=i+1;j< arr.length;j++){
                if (arr[j]<currentMin){
                    currentMin=arr[j];
                    currentMinIndex=j;
                }
            }
            if(currentMinIndex!=i){
                arr[currentMinIndex]=arr[i];
                arr[i]=currentMin;
            }
        }
        return arr;
    }

    public static int[] selectionSortLargest(int[] arr){
        for (int i=0;i< arr.length-1;i++){
            int currentMax=arr[i];
            int currentMaxIndex=i;
            for (int j=i+1;j< arr.length;j++){
                if (arr[j]>currentMax){
                    currentMax=arr[j];
                    currentMaxIndex=j;
                }
            }
            if(currentMaxIndex!=i){
                arr[currentMaxIndex]=arr[i];
                arr[i]=currentMax;
            }
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr){
        for (int i=1;i< arr.length;i++){
            int k;
            int currentElement=arr[i];
            for (k=i-1;k>=0&&arr[k]>currentElement;k--){
                arr[k+1]=arr[k];
            }
            arr[k+1]=currentElement;
        }
        return arr;
    }
    public static int[] insertionSortMax(int[] arr){
        for (int i=1;i< arr.length;i++){
            int k;
            int currentElement=arr[i];
            for (k=i-1;k>=0&&arr[k]<currentElement;k--){
                arr[k+1]=arr[k];
            }
            arr[k+1]=currentElement;
        }
        return arr;
    }

    public static void main(String[] args) {
        int []arr1 = {45, 7, 2, 8, 19, 3};
        System.out.println("Array sorting with ascending order : "+Arrays.toString(selectionSortSamllest(arr1)));
        int []arr2 = {45, 7, 2, 8, 19, 3};
        System.out.println("Array sorting with descending order : "+Arrays.toString(selectionSortLargest(arr2)));
        int[]arr3={10,34,2,56,7,67,88,42};
        System.out.println("Array sorting with insertion sort : "+Arrays.toString(insertionSort(arr3)));
        int[]arr4={10,34,2,56,7,67,88,42};
        System.out.println("Array sorting with insertion sort : "+Arrays.toString(insertionSortMax(arr4)));
    }
}

