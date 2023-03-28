package L2;

public class L2Q1 {
    public static void main(String[] args) {
        myGenerics<String> strObj=new myGenerics<>("Hello world");
        myGenerics<Integer> intObj=new myGenerics<>(69);
        System.out.println(strObj.getE());
        System.out.println(intObj.getE());
    }
}

class myGenerics<E>{
    private E e;
    public myGenerics(E e){
        this.e=e;
    }
    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}
