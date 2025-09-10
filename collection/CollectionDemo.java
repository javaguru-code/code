import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionDemo {
    public static void main(String[] args) {
    //     Collection  c=new ArrayList<Integer>();
    //     c.add(10);
    //     c.add(20);
    //     c.add(30);
    //     c.add(40);
    //     c.add(60);
    //     c.add(50);
    //     c.add(25);
    //     c.add(15);
    //     c.add(5);

    //    for(Object a:c){
    //     System.out.println(a.toString());
    //    }

    List<Integer> l=new ArrayList<Integer>();
    l.add(80);
    l.add(50);
    l.add(70);
    l.add(20);
    l.add(60);
    l.add(30);
    l.add(10);
    l.add(40);
    System.out.println(l.indexOf(40));
    System.out.println(l.indexOf(60));
    System.out.println(l.get(4));
    Collections.sort(l);
    System.err.println(l);
    }
}
