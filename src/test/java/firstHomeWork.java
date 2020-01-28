import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class firstHomeWork {

    // 1 zadanie
    @Test
    public void personData() {
        showNameAge("Дима, ", 33);
    }

    private void showNameAge(String a, int b) {
        System.out.println("Привет " + a + "тебе уже " + b);
    }

    // 2 zadanie

    private double fuelConsumption(double l, double s) {
        return (l / (s / 100));
    }

    @Test
    public void showFuelConsumption() {
        double x;
        x = fuelConsumption(35, 500);
        System.out.println("Литров " + x + "на 100км");
    }

   /*public void countOfRounds() {
   double r = 0.8;
   double z = 1000000/(2*3.14*r);
   System.out.println("Кол-во оборотов " + z + " на 1000000км");}*/

    // 3 zadanie

    private double countOfRounds(double r) {
        return 1000000 / (2 * 3.14 * r);
        //return Math.round((1000000 / (2 * 3.14 * r)),2);
    }

    @Test
    public void showcountOfRounds() {
        double z;
        z = countOfRounds(0.8);
        System.out.println("Кол-во " + z + " на 1000000км");
    }


//  4 zadanie

    private double distanceTwoPoints(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }


    @Test
    public void showDistanceTwoPoints() {
        double d;
        d = distanceTwoPoints(1, 3, 1, 3);
        System.out.println("Растояние между двуми точками =  " + d);
    }




}



