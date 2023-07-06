package L7;

import java.util.LinkedList;

public class L7Q1 {
    public static void main(String[] args) {
        String[] fruitArr={"Durian","Blueberry"};
        MyQueue<String> fruitQ = new MyQueue<>(fruitArr);
        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");
        System.out.println(fruitQ.toString());
        System.out.println(fruitQ.peek());
        System.out.println(fruitQ.getSize());
        System.out.println("Removed : "+fruitQ.dequeue());
        System.out.println(fruitQ.getElement(2));
        System.out.println("Is Cherry exists ? :"+fruitQ.contains("Cherry"));
        System.out.println("Is Durian exists ? :"+fruitQ.contains("Durian"));
        while (!fruitQ.isEmpty()){
            System.out.println(fruitQ.dequeue());
        }
    }
}

class MyQueue<E>{
    LinkedList<E> queue=new LinkedList<>();

    public MyQueue(E[] e){
        for (E i:e){
            queue.add(i);
        }
    }

    public MyQueue(){
    }

    public void enqueue(E e){
        queue.add(e);
    }

    public E dequeue(){
        return queue.removeFirst();
    }

    public E getElement(int i){
        return queue.get(i);
    }

    public E peek(){
        return queue.getFirst();
    }

    public int getSize(){
        return queue.size();
    }

    public boolean contains(E e){
        return queue.contains(e);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public String toString(){
        return queue.toString();
    }
}
