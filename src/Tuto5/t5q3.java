package Tuto5;

public class t5q3 {
    public static void main(String[] args) {
        DoublyLinkedList<Character> doublyLinkedList=new DoublyLinkedList<>();
        doublyLinkedList.addLast('a');
        doublyLinkedList.addLast('b');
        doublyLinkedList.addLast('c');
        doublyLinkedList.addLast('z');
        doublyLinkedList.print();
    }
}

class Node<E>{
    E element;
    Node<E> previous;
    Node<E> next;

    public Node(E element,Node prev, Node next){
        this.element=element;
        this.previous=prev;
        this.next=next;
    }

    public Node(E element){
        this (element,null,null);
    }

}

class DoublyLinkedList<E>{
    Node<E> head;
    Node<E> tail;
    int size;

    public void addLast(E element){
        Node<E> temp=new Node<>(element,tail,null);
        if (tail!=null) tail.next=temp;
        tail=temp;
        if(head==null) head=temp;
        size++;
        System.out.println("Added : "+temp.element);
    }

    public void print(){
        Node<E> temp=head;
        for (int i=0;i<size;i++){
            System.out.print(temp.element+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}