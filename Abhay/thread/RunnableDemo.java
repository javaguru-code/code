package thread;
class A implements Runnable{
    public void run(){
        for(int i=0;i<20;i++){
             System.out.println("Hi!....");
             try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
             
        }
    }
}

class B implements Runnable{
    public void run(){
          for(int i=0;i<20;i++){
                    System.out.println("Hello!....");
                     try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
                   
        }
    }
}
public class RunnableDemo {
    public static void main(String[] args) {
            Runnable r1=new A();
    Runnable r2=new B();
    Thread t1=new Thread(r1);
    Thread t2=new Thread(r2);
    t1.start();
    t2.start();
    }


}
