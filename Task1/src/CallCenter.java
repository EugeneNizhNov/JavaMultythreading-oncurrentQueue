import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {
    private Queue<String> queue = new ConcurrentLinkedQueue<String>();
    private volatile boolean cycle = true;

    public void pbxProcessing() {
        final int phoneСall = 60;
        final int millis = 500;
        System.out.println("Старт очереди АТС");
        try {
            for (int i = 0; i < phoneСall; i++) {
                String str = "Звонок " + (i + 1);
                queue.add(str);
                System.out.println("АТС добавила в очередь " + str);
                Thread.sleep(millis);
            }
            cycle = false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void operatorProcessing() {
        String str;
        final int millis = 3000;
        System.out.println("Старт очереди оператора " + Thread.currentThread().getName());
        while (cycle || !queue.isEmpty()) {
            if ((str = queue.poll()) != null) {
                System.out.println("Оператор " + Thread.currentThread().getName() + " обработал " + str);
            }
            try {
                Thread.sleep(millis);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
