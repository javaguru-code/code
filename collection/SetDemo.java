import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        // Set<Integer> num=new HashSet<Integer>();   //output   :--[20, 40, 10, 90, 60, 30]
        Set<Integer> num=new TreeSet<>();   // output  [10, 20, 30, 40, 60, 90]
        //treeSet give result in sorted order
            num.add(10);
            num.add(20);
            num.add(30);
            num.add(10);
            num.add(40);
            num.add(10);
            num.add(90);
            num.add(40);
            num.add(60);

            System.out.println(num);
    }
}
