package L2;

public class L2Q5 {
    public static<T extends Comparable<T>> T max(T[] arr){
        T max=arr[0];
        for (T list:arr){
            max=(list.compareTo(max))>0?list:max;
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] intArr={1,2,3};
        String[] strArr={"Red","Green","Blue"};
        Circle[] circleArr={new Circle(3),new Circle(2.9),new Circle(5.9)};

        System.out.println(max(intArr));
        System.out.println(max(strArr));
        System.out.println(max(circleArr));
    }

}

class Circle implements Comparable<Circle>{
    double radius;
    Circle(double radius){
        this.radius=radius;
    }
    @Override
    public int compareTo(Circle o) {
        if(this.radius>o.radius){
            return 1;
        }
        else if (this.radius<o.radius){
            return -1;
        }
        else return 0;
    }

    @Override
    public String toString(){
        return "Max = "+this.radius;
    }
}