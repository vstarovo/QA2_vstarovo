import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class firstHomeWork {

    // 1
    @Test
    public void personData() {
        showNameAge("Дима, ", 33);
    }

    private void showNameAge(String name, int age) {
        System.out.println("Привет " + name + "тебе уже " + age);
    }

    // 2
    private double fuelConsumption(double fuelcount, double distance) {
        return (fuelcount / (distance / 100));
    }

    @Test
    public void showFuelConsumption() {
        double consumption;
        consumption = fuelConsumption(37, 505);
        System.out.println("Расход топлива =  " + Math.round(consumption * 100) / 100.0d + " Л/100км");
    }

    // 3
    private double countOfRounds(double radius) {
        return 1000000 / (2 * 3.14 * radius);
    }

    @Test
    public void showcountOfRounds() {
        double radius;
        radius = countOfRounds(0.8);
        System.out.println("Кол-во оборотов " + Math.round(radius * 100) / 100.0d + " на 1000000км");
    }

    //  4
    private double distanceTwoPoints(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Test
    public void showDistanceTwoPoints() {
        double distance;
        distance = distanceTwoPoints(1, 3, 1, 3);
        System.out.println("Растояние между двуми точками =  " + Math.round(distance * 100) / 100.0d);
    }

}



