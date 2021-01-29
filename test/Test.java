public class Test {

  public static void main(String[] args) {
    
    Thread thread = new Thread(new Runnable(){
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
          System.out.println("執行緒執行...");
        } catch (InterruptedException e) {
          System.out.println("執行緒中斷了...");
          return;
        }
      }
    });
    
    thread.start();
    thread.interrupt();
    
  }
  
}