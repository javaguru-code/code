import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        // Map<String,Integer> map=new HashMap<String,Integer>(); //not synchronised by default
         Map<String,Integer> map=new Hashtable<String,Integer>();  /// synchronised by default
        map.put("Abhay", 50000);
        map.put("Prem", 55000);
        map.put("Sweta", 40000);
        map.put("mohit", 20000);
        map.put("Praveen", 80000);
        map.put("Raja", 90000);
        map.put("Abha", 55000);
        map.put("maya", 20000);
        map.put("Jaya", 45000);
        System.out.println(map);
        System.out.println(map.get("Abhay"));
        for(String key:map.keySet()){
            System.out.println("Name ::" +key +" Salary:: "+map.get(key));
        }
        System.out.println("*******************************************************");
        map.entrySet().forEach(entry->{
            System.out.println("Name ::" +entry.getKey() +" Salary:: "+entry.getValue());
         });
         System.out.println("*******************************************************");
    }
}
