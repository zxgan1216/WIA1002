package L6;

import java.util.ArrayList;

public class L6Q1 {
    public static void main(String[] args) {
        MyStack<Character> stack=new MyStack<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        System.out.println(stack.toString());
        System.out.println("b is found : "+stack.search('b'));
        System.out.println("k is found : "+stack.search('k'));

        MyStack<Integer> integerMyStack=new MyStack<>();
        integerMyStack.push(1);
        integerMyStack.push(2);
        integerMyStack.push(3);

        System.out.println(integerMyStack.toString());
        System.out.println("6 is in the stack :"+integerMyStack.search(6));
    }
}

class MyStack<E>{
    ArrayList<E> stack=new ArrayList<>();
    public void push(E o){
        stack.add(o);
    }
    public E pop(){
        return stack.remove(stack.size()-1);
    }
    public E peek(){
        return stack.get(stack.size()-1);
    }
    public int getSize(){
        return stack.size();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public String toString(){
        return "Stack :"+stack;
    }
    public boolean search(E o){
        return stack.contains(o);
    }
}
