package L2;

public class L2Q2 {
    public static void main(String[] args) {
        CompareMax compareMax=new CompareMax();
        System.out.println(compareMax.maximum(4,5,6));
    }
}

class CompareMax{
    static <T extends Comparable<T>> T maximum(T a,T b,T c){
        T max=a;
        if(b.compareTo(max)>0){
            max=b;
        }
        if(c.compareTo(max)>0){
            max=c;
        }
        return max;
    }
}
