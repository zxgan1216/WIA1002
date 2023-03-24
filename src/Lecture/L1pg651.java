package Lecture;

import java.util.ArrayList;

public class L1pg651 {
    public static void main(String[] args) {
        Animal animal=new Chicken();
        eat(animal);

        animal=new Duck();
        eat(animal);

        animal=new Chicken();
        System.out.println(animal.howToEat());

        animal=new Duck();
        System.out.println(animal.howToEat());

        ArrayList<Animal> animals=new ArrayList<>();
        animals.add(new Chicken());
        animals.add(new Duck());

        System.out.println(animals.get(0).howToEat());
        System.out.println(animals.get(1).howToEat());
    }

    //due to its void so cant print at main method
    public static void eat(Animal stuff){
        System.out.println(stuff.howToEat());
    }
}

abstract class Animal{
    public abstract String howToEat();
}

class Chicken extends Animal{
    @Override
    public String howToEat() {
        return "Fry it";
    }
}

class Duck extends Animal{

    @Override
    public String howToEat() {
        return "Roast it";
    }
}
