package Tuto2;

import java.util.ArrayList;

public class t2q2 {
    public static void main(String[] args) {
        myArray<Integer> integermyArray=new myArray<>();
        myArray<String> stringmyArray=new myArray<>();
        myArray<Character> charactermyArray=new myArray<>();
        for (int i=1;i<=5;i++) integermyArray.add(i);
        stringmyArray.add("Jane");
        stringmyArray.add("Tom");
        stringmyArray.add("Bob");
        charactermyArray.add('a');
        charactermyArray.add('b');
        charactermyArray.add('c');
        integermyArray.print();
        stringmyArray.print();
        charactermyArray.print();
    }
}

class myArray<E>{
    ArrayList<E> arrayList=new ArrayList<>();

    public void add(E d){
        arrayList.add(d);
    }

    public void print(){
        System.out.println(arrayList.toString());
    }
}


