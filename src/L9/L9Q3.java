package L9;

public class L9Q3 {
    public static int exponent(int x,int y){
        if(y==0) return 1;
        else return x*exponent(x,y-1);
    }

    public static void main(String[] args) {
        System.out.println(exponent(10,3));
    }
}
