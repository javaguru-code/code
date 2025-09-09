import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IODemo
 {
    public static void main(String[] args) {
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter your name:--");
            String name=br.readLine();
            System.out.println("Hi "+name+" Welcome to world of java" );
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            System.out.println("code completed");
        }
    }
}
