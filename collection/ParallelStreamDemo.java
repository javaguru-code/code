import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        int size=100_000;
        List<Integer> nums=new ArrayList<>(size);
        Random ran=new Random();
        for(int i=0;i!=size;i++){
            nums.add(ran.nextInt(100));
        }
      //  System.out.println(nums);
int sum1=    nums.stream().map(i->i*2).reduce(0,(c,e)->c+e);
int sum2=nums.stream().map(i->{
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            // TODO: handle exception
        }
    return i*2;
})    .mapToInt(i->i).sum();
long time=System.currentTimeMillis();
System.out.println("******************using stream()**************************");
System.out.println(sum1);
System.out.println(sum2);
System.out.println("*********************stream over***********************");
long timeTakenByStream=System.currentTimeMillis()-time;
System.out.println("Time taken By Stream...  "+timeTakenByStream);
System.out.println("******************using stream()**************************");
long ptime=System.currentTimeMillis();
int sum3=nums.parallelStream().map(i->{
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            // TODO: handle exception
        }
    return i*2;
})    .mapToInt(i->i).sum();
System.out.println(sum3);
long timeTakenByParallelStream=System.currentTimeMillis()-ptime;
System.out.println("Time taken By parallel Stream...  "+timeTakenByParallelStream);
}
}
