public class Test {

  public static void main(String[] args) {
    
    Thread thread = new Thread(new Runnable(){
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
          System.out.println("���������...");
        } catch (InterruptedException e) {
          System.out.println("��������_�F...");
          return;
        }
      }
    });
    
    thread.start();
    thread.interrupt();
    
  }
  
}