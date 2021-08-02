public class Pbx extends Thread {
    private final CallCenter callCenter;

    public Pbx(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
        callCenter.pbxProcessing();
    }
}
