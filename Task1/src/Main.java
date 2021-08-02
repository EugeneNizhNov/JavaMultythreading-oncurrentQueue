/**
 * Задача 1. Колл-центр
 **/

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CallCenter callCenter = new CallCenter();
        Thread operator = new Thread(new Operator(callCenter), "1");
        Thread operator1 = new Thread(new Operator(callCenter), "2");
        Thread operator2 = new Thread(new Operator(callCenter), "3");
        Thread pbx = new Thread(new Pbx(callCenter));
        pbx.start();
        operator.start();
        operator1.start();
        operator2.start();
    }
}
