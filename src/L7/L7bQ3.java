package L7;
import java.util.Queue;
public class L7bQ3 {
     public static void main(String[] args) {
         Queue<ComparableBook> BookQueue = new java.util.PriorityQueue<>();
         BookQueue.add(new ComparableBook(1065, "Effective Java: Third Edition"));
         BookQueue.add(new ComparableBook(3012, "Java: A Beginner Guide Seventh Edition"));
         BookQueue.add(new ComparableBook(1097, "Learn Java in One Day and Learn It Well"));
         BookQueue.add(new ComparableBook(7063, "Beginning Programming with Java (Dummies)"));
         BookQueue.add(new ComparableBook(6481, "Java: Programming Basic for Absolute Beginner"));
         System.out.println(BookQueue);
         while (BookQueue.peek() != null) {
             System.out.println("Head Element: " + BookQueue.peek());
             BookQueue.remove();
             System.out.println("Priority queue: " + BookQueue);
         }
     }
}

class ComparableBook implements Comparable<ComparableBook>{
    int code;
    String name;
    ComparableBook(int code,String name){
        this.code=code;
        this.name=name;
    }

    @Override
    public int compareTo(ComparableBook o) {
        if (code > o.code) {
            return 1;
        } else if (code < o.code) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString(){
        return code +" : "+name;
    }
}
