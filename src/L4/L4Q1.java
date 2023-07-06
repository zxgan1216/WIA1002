package L4;

public class L4Q1 {
    public static void main(String[] args) {
        MyLinkedList<Character> myLinkedList=new MyLinkedList<>();
        myLinkedList.addFirst('a');
        myLinkedList.add(1,'b');
        myLinkedList.add(2,'c');
        myLinkedList.add(3,'d');
        myLinkedList.addLast('e');

        myLinkedList.print();

        myLinkedList.reverse();

        System.out.println("Size = "+myLinkedList.size);
        System.out.println("Middle value = "+myLinkedList.getMiddleValue());

        System.out.println("First value : "+myLinkedList.getFirst());

        System.out.println("Last value = "+myLinkedList.getLast());

        System.out.println("Removed : "+ myLinkedList.remove(2));

        System.out.println("Second value = "+myLinkedList.get(2));
        System.out.println("Third value = "+ myLinkedList.get(3));

        System.out.println("Contains c ? = "+ myLinkedList.contains('c'));

        System.out.println(myLinkedList.set(0,'j'));
        System.out.println(myLinkedList.set(1,'a'));
        System.out.println(myLinkedList.set(2,'v'));
        System.out.println(myLinkedList.set(3,'a'));
        myLinkedList.print();

        System.out.println("Size = "+myLinkedList.size);
        System.out.println("Middle value = "+myLinkedList.getMiddleValue());
    }
}

class Node<E>{
    public E element;
    public Node <E> next;
    Node(E element){
        this.element=element;
    }
}

class MyLinkedList<E>{
    MyLinkedList(){}
    Node<E> head;
    Node<E> tail;
    int size;
    public void addFirst(E e){
        Node<E> newNode=new Node<>(e);
        newNode.next= head;
        head=newNode;
        if (tail==null) tail=newNode;
        size++;
    }

    public void addLast(E e){
        if (tail==null) tail=head=new Node<>(e);
        else{
            tail.next=new Node<>(e);
            tail=tail.next;
        }
        size++;
    }

    public void add(int index,E e){
        if (index==0) addFirst(e);
        else if (index>=size) addLast(e);
        else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E removeFirst(){
        if (size==0) return null;
        else{
            Node<E> temp=head;
            head=head.next;
            size--;
            if (head==null) tail=null;
            return temp.element;
        }
    }

    public E removeLast(){
        if (size==0) return null;
        else if (size==1){
            Node<E> temp=tail;
            head=tail=null;
            size--;
            return temp.element;
        }
        else {
            Node<E> newTail=head;
            for (int i=0;i<size-2;i++){
                newTail=newTail.next;
            }
            Node<E> temp=tail;
            tail=newTail;
            tail.next=null;
            size--;
            return temp.element;
        }
    }

    public E remove(int index){
        if (index<0||index>=size) return null;
        else if(index==0) return removeFirst();
        else if(index==size-1) return removeLast();
        else{
            Node<E> previous=head;
            for (int i=1;i<index;i++){
                previous=previous.next;
            }
            Node<E> current=previous.next;
            previous.next=current.next;
            size--;
            return current.element;
        }
    }

    public boolean contains(E e){
        Node<E> current=head;
        for (int i=0;i<size;i++,current=current.next){
            if (e==current.element) {
                return true;
            }
        }
        return false;
    }

    public E get(int index){
        if (index<0||index>size){
            System.out.println("Index out of bound");
            return null;
        }
        else {
            Node<E> current=head;
            for (int i=0;i<index;i++){
                current=current.next;
            }
            return current.element;
        }
    }

    public E getFirst(){
        if (head==null){
            System.out.println("List is empty");
            return null;
        }
        else {
            return head.element;
        }
    }

    public E getLast(){
        if (tail==null){
            System.out.println("List is empty");
            return null;
        }
        else {
            return tail.element;
        }
    }

    public int indexOf(E e){
        Node<E> current=head;
        for (int i=0;i<size;i++){
            if (e==current.element){
                return i;
            }
            current=current.next;
        }
        System.out.println("Element "+e+" not found");
        return -1;
    }

    public int lastIndexOf(E e){
        Node<E> current=head;
        int index=-1;
        for (int i=0;i<size;i++){
            if (e==current.element){
                index=i;
            }
            current=current.next;
        }
        return index;
    }

    public E set(int index,E e){
        if (index<0||index>size) return null;
        else {
            Node<E> current=head;
            for (int i=0;i<index;i++){
                current=current.next;
            }
            E temp=current.element;
            current.element=e;
            return temp;
        }
    }

    public void clear(){
        Node<E> current=head;
        for (int i=0;i<size;i++){
            current.element=null;
            current=current.next;
        }
        head = tail = null;
        size = 0;
    }

    public void print(){
        if(head == null && tail == null) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            Node<E> current = head;
            while (current != null) {
                System.out.print(current.element + " ");
                current = current.next;
            }
            System.out.println("]");
        }
    }

    public void reverse(){
        if(head == null && tail == null) {
            System.out.println("[ ]");
        }
        else {
            String s = head.element + "";
            for(Node<E> node = head.next; node != null; node = node.next) {
                s = node.element + ", " + s;
            }
            System.out.printf("[%s]\n", s);
        }
    }

    public E getMiddleValue(){
        if (size==0){
            System.out.println("List is empty");
            return null;
        }
        else{
            return get(size/2);
        }
    }
//public E getMiddleValue() {
//    if (head == null && tail == null) {
//        System.out.println("List is empty");
//        return null;
//    } else {
//        Node<E> slow = head;
//        Node<E> fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow.element;
//    }
//}

}
