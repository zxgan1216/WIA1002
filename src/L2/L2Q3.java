package L2;

public class L2Q3 {
    public static void main(String[] args) {
        storeGenericsPair<Integer> a = new storeGenericsPair<Integer>(6,4);
        storeGenericsPair<Integer> b = new storeGenericsPair<Integer>(2,2);
        storeGenericsPair<Integer> c = new storeGenericsPair<Integer>(6,3);

        //(e)
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(c));
        System.out.println(b.compareTo(c));
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(b.equals(c));
    }
}

class storeGenericsPair<T extends Comparable<T>> implements Comparable<storeGenericsPair<T>>{
    private T first;
    private T second;

    public storeGenericsPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setPair(T first,T second){
        this.first=first;
        this.second=second;
    }
    @Override
    public String toString() {
        return "First = "+first+" Second = "+second;
    }
//    @Override
    public boolean equals(storeGenericsPair<T> other){
        return this.first.equals(other.getFirst());
    }
    @Override
    public int compareTo(storeGenericsPair<T> other){
        return this.first.compareTo(other.getFirst());
    }
}
