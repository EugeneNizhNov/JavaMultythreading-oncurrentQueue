public class Operator extends Thread {
    private final CallCenter callCenter;

    public Operator(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
        callCenter.operatorProcessing();
    }
}
