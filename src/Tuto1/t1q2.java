package Tuto1;

public class t1q2 {
    public static void main(String[] args) {
        BMW bmw=new BMW(100);
        System.out.println(bmw.pedalToTheMetal());
    }
}
class BMW extends Vehicle{
    public BMW(double maxSpeed) {
        super(maxSpeed);
    }

    @Override
    public void accelerate() {
        super.current_speed++;
    }
}
abstract class Vehicle{
    double maxSpeed;
    protected double current_speed;
    public Vehicle(double maxSpeed){
        this.maxSpeed=maxSpeed;
    }

    public abstract void accelerate();

    public double getCurrent_speed() {
        return current_speed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public String pedalToTheMetal(){
        while(current_speed!=maxSpeed){
            accelerate();
        }
        return "done";
    }
}