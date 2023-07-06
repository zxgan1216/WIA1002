package L7;

import java.util.PriorityQueue;

public class L7bQ2 {
    public static void main(String[] args) {
        PriorityQueue<String> pq1=new PriorityQueue<>();
        PriorityQueue<String> pq2=new PriorityQueue<>();
        String [] arr1={"George","Jim","John", "Blake","Kevin","Michael"};
        String [] arr2= {"George","Katie","Kevin","Michelle","Ryan"};

        for (String arr:arr1){
            pq1.offer(arr);
        }

        for (String arr:arr2){
            pq2.offer(arr);
        }

        System.out.println("Union of pq1 and pq 2 :");
        PriorityQueue<String> union=new PriorityQueue<>(pq1);
        for(String s:pq2){
            if(!union.contains(s)){
                union.offer(s);
            }
        }
        System.out.println(union.toString());

        System.out.println("Difference of pq1 and pq 2 :");
        PriorityQueue<String> diff=new PriorityQueue<>(pq1);
        diff.removeAll(pq2);
        System.out.println(diff.toString());

        System.out.println("Intersection of pq1 and pq 2 :");
        PriorityQueue<String> intersection=new PriorityQueue<>(pq1);
        intersection.retainAll(pq2);
        System.out.println(intersection.toString());
    }
}
