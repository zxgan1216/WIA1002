package Tuto2;

public class T2Q1 {
}
 class container<T> {
    private T t;
    container(){
    }

    public void add(T t){
        this.t=t;
    }

    public T retrieve(){
        return t;
    }

     public static void main(String[] args) {
         container<String> stringcontainer= new container<String>();
         container<Integer> integercontainer= new container<Integer>();
         stringcontainer.add("Java");
         integercontainer.add(50);
         System.out.println(stringcontainer.retrieve());
         System.out.println(integercontainer.retrieve());
     }
 }