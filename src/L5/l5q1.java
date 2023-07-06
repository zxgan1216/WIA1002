package L5;

public class l5q1 {
    public static void main(String[] args) {
        SList<String> stringSList=new SList<>();
        stringSList.appendEnd("Linked list");
        stringSList.appendEnd("is");
        stringSList.appendEnd("easy");
        stringSList.display();
        stringSList.removeInitial();
        stringSList.display();
        System.out.println(stringSList.contains("difficult"));
        stringSList.clear();
        stringSList.display();
    }
}

class SNode<E>{
    E element;
    SNode<E> prev;
    SNode<E> next;
    SNode(E element,SNode prev, SNode next){
        this.element=element;
        this.prev=prev;
        this.next=next;
    }

    SNode(E element){
        this(element,null,null);
    }
}

class SList<E>{
    SNode<E> head;
    SNode<E> tail;
    int size;
    public void appendEnd(E element){
        SNode<E> temp=new SNode<>(element,tail,null);
        if (tail!=null) tail.next=temp;
        tail=temp;
        if(head==null) head=temp;
        System.out.println("Adding "+temp.element);
        size++;
    }

    public E removeInitial(){
        if(size==0) return null;
        else{
            SNode<E> temp=head;
            head=head.next;
            head.prev=null;
            size--;
            System.out.println("Removed : "+temp.element);
            return temp.element;
        }
    }

    public boolean contains(E element){
        SNode<E> temp=head;
        for (int i=0;i<size;i++){
            if (element.equals(temp.element)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    public void clear(){
        SNode<E> temp=head;
        while (head!=null){
            temp=head.next;
            head.next=head.prev=null;
            head=temp;
        }
        temp=null;
        tail.prev=tail.next=null;
        size=0;
    }

    public void display(){
        SNode<E> temp=head;
        if(size==0){
            System.out.println("The list is empty");
        }
        else{
            for (int i=0;i<size;i++){
                System.out.print(temp.element+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }
}