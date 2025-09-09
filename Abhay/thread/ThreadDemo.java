 package thread;

class A extends Thread{
    public void run(){
        for(int i=0;i<20;i++){
             System.out.println("Hi!....");
             try {
                sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class B extends Thread{
    public void run(){
          for(int i=0;i<20;i++){
                    System.out.println("Hello!....");
                       try {
                sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
public class ThreadDemo {

    public static void main(String[] args) {
        A a=new A();
        B b=new B();
        a.start();
        b.start();
        // a.sayHi();
        // b.sayHello();
    }
}