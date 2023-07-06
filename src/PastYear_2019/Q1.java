package PastYear_2019;

public class Q1 {
    public static void main(String[] args) {
        int[] arr1 = { 2, 10, 38, 41, 51 };
        myLinkedList<Integer> list1 = new myLinkedList<>();
        for (int val : arr1) {
            list1.addLast(val);
        }
        System.out.println(list1.toString());

        int[] arr2 = { 5, 12, 18, 21, 35, 41, 56 };
        myLinkedList<Integer> list2 = new myLinkedList<>();
        for (int val : arr2) {
            list2.addLast(val);
        }
        System.out.println(list2.toString());
    }

    public static <E extends Comparable<E>> myLinkedList combines(myLinkedList<E> first,myLinkedList<E> second){
        
    }
}
class Node<E>{
    E element;
    Node<E> next;
    Node(E element,Node<E> next){
        this.element=element;
        this.next=next;
    }
    Node(E element){
        this.element=element;
    }
}

class myLinkedList<E>{
    Node<E> head;
    Node<E> tail;
    int size;
    myLinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }
    public int getSize(){
        return size;
    }
    public void addFirst(E e){
        if (size==0){
            head=tail=new Node<>(e);
            size++;
        }
        else{
            Node<E> temp=head;
            head=new Node<>(e);
            head.next=temp;
            size++;
        }
    }
    public void addLast(E e){
        if (size==0){
            head=tail=new Node<>(e);
            size++;
        }
        else{
            Node<E> current=head;
            for (int i=0;i<size-1;i++){
                current=current.next;
            }
            current.next=new Node<>(e);
            tail=current.next;
            size++;
        }
    }
    public E removeFirst(){
        if(size==0) {
            return null;
        }
        else if(size==1){
            Node<E> temp=head;
            head=tail=null;
            size--;
            return temp.element;
        }
        else{
            Node<E> temp=head;
            head=head.next;
            size--;
            return temp.element;
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[size=%d] ", size));
        for (Node<E> current=head;current!=null;current=current.next){
            sb.append(" >> "+current.element);
        }
        return sb.toString();
    }
}