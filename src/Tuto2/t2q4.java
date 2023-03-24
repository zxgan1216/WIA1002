package Tuto2;

public class t2q4 {
    myGenerics<String,Integer> sideShape=new myGenerics<>("Square",69);
    myGenerics<Double,Double> points=new myGenerics<>(6.69,6.69);
}

class myGenerics<A,B>{
    private A a;
    private B b;

    myGenerics(A a,B b){
        this.a=a;
        this.b=b;
    }
}
