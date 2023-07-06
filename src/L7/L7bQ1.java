package L7;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class L7bQ1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq_int = new PriorityQueue<>();
        int [] arr={4,8,1,2,9,6,3,7};
        for (int i:arr){
            pq_int.offer(i);
        }

        System.out.println(pq_int.toString());
        System.out.println(pq_int.poll());
        System.out.println(pq_int.add(5));
        Integer[] arr2 = pq_int.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr2));
        System.out.println(pq_int.peek());
        System.out.println(pq_int.contains(1));
        System.out.println(pq_int.size());

        while(!pq_int.isEmpty()){
            System.out.println(pq_int.poll());
        }

        PriorityQueue<Integer> pq_reversed= new PriorityQueue<>(Collections.reverseOrder());
        pq_reversed.addAll(Arrays.asList(arr2));
        System.out.println(pq_reversed.toString());
    }
}
