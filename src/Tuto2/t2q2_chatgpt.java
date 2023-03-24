package Tuto2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t2q2_chatgpt {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<String> stringList = Arrays.asList("Jane", "Tom", "Bob");
        List<Character> charList = Arrays.asList('a', 'b', 'c');
        printList(integerList);
        printList(stringList);
        printList(charList);
    }

    private static void printList(List<?> list) {
        System.out.println(list);
    }
}
