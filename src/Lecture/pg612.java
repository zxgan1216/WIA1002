package Lecture;

public class pg612 {
    public static void Eat(cook cook){
        System.out.println(cook.howToEat());
    }

    public static void main(String[] args) {
        cook cook=new Chicken2();
        Eat(cook);

        cook=new Duck2();
        Eat(cook);
    }
}

interface cook{
    public String howToEat();
}

class Chicken2 implements cook{

    @Override
    public String howToEat() {
        return "Fry it";
    }
}

class Duck2 implements cook{
    @Override
    public String howToEat(){
        return "Roast it";
    }
}