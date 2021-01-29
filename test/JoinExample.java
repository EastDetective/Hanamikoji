public class JoinExample extends Thread {
    String myId;
    public JoinExample(String id) {
        myId = id;
    }
    public void run() { // overwrite Thread's run()
	for (int i=0; i < 500; i++) {
            System.out.println(myId+" Thread");
        }
    }
    public static void main(String[] argv) {
        Thread t1 = new JoinExample("T1"); // ����Thread����
        Thread t2 = new JoinExample("T2"); // ����Thread����
        t1.start(); // �}�l����t1.run()
        t2.start();
        try {
            t1.join(); // ����t1����
            t2.join(); // ����t2����
        } catch (InterruptedException e) {}
        for (int i=0;i < 5; i++) {
            System.out.println("Main Thread");
        }
    }
}