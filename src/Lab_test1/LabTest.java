package Lab_test1;

public class LabTest {
}
class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return String.format("%s (age=%s)", this.name, this.age);
    }
}

class Node<T>{
    private T value;
    private String edgeName1;
    private String edgeName2;
    private Node<T> edgeNode1;
    private Node<T> edgeNode2;
    public void setEdge1(String edgeName, Node<T> node) {
        this.edgeName1=edgeName;
        this.edgeNode1=node;
    }
    public void setEdge2(String edgeName, Node<T> node) {
        this.edgeName2=edgeName;
        this.edgeNode2=node;
    }
    public T getValue() {
        return value;
    }
    public void printEdgesAndNodes(Person person) {
        System.out.println("-".repeat(40));
        System.out.println(person.toString());
        System.out.printf("/t:%s->",edgeName1);
    }

}
