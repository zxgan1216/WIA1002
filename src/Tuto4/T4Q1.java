package Tuto4;

public class T4Q1 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.printList();
        System.out.println(linkedList.head.element);
        linkedList.addLast(2);
        linkedList.printList();
        linkedList.add(1,10);
        linkedList.printList();
        linkedList.removeLast();
        linkedList.printList();
        linkedList.removeFirst();
        linkedList.printList();
        linkedList.add(0,1);
        linkedList.add(0,2);
        linkedList.printList();
        linkedList.remove(0);
        linkedList.printList();
        System.out.println(linkedList.head.element);
    }
}
class LinkedList<E> {
    Node<E> head = null;
    Node<E> tail = null;
    int size;

    public void addFirst (E element) {
        Node<E> newNode = new Node<E>(element, head);
        if (tail == null)
            tail = newNode;
        head = newNode;
        size++;
    }

    public void addLast (E element) {
        Node<E> newNode = new Node<E>(element, null);
        if (tail == null)
            head = newNode;
        else
            tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void add (int index, E element) {
        if (index == 0) {
            addFirst(element);
        } else if (index >= size) {
            addLast(element);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> prev = current;
            prev.next = new Node<E>(element, prev.next);
            size++;
        }
    }

    public void removeFirst () {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            head = head.next;
            size--;
        }
    }

    public void removeLast () {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
            size--;
        }
    }

    public void remove (int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bound");
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            current.next = (current.next).next;
            size--;
        }
    }

    public void printList () {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
        this.element = element;
    }

    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }
}