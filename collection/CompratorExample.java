import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;
import java.util.Collection.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
class Student{
    int age;
    String name;
    public Student(int age,String name){
      this.age=age;
      this.name=name;  
    }
    public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
    public String toString(){
        return "Student :[age =  "+age+" , Name= " +name+"]";
    }
}
public class CompratorExample {
    public static void main(String[] args) {
        Comparator<Integer> com=(a,b)->a>b?1:-1;
        List<Student> students=new ArrayList<>();
         // Adding 20 student records
        students.add(new Student(20, "John Doe"));
        students.add(new Student(21, "Jane Smith"));
        students.add(new Student(22, "Michael Johnson"));
        students.add(new Student(19, "Emily Davis"));
        students.add(new Student(20, "David Wilson"));
        students.add(new Student(21, "Sarah Brown"));
        students.add(new Student(20, "Robert Taylor"));
        students.add(new Student(22, "Jennifer Anderson"));
        students.add(new Student(19, "William Thomas"));
        students.add(new Student(21, "Elizabeth Jackson"));
        students.add(new Student(20, "James White"));
        students.add(new Student(22, "Patricia Harris"));
        students.add(new Student(19, "Charles Martin"));
        students.add(new Student(20, "Linda Thompson"));
        students.add(new Student(21, "Joseph Garcia"));
        students.add(new Student(22, "Barbara Martinez"));
        students.add(new Student(20, "Thomas Robinson"));
        students.add(new Student(19, "Margaret Clark"));
        students.add(new Student(21, "Daniel Rodriguez"));
        students.add(new Student(20, "Susan Lewis"));
        //Collections.sort(students., com);
        // System.out.println(students);
        //students.stream().forEach(System.out::println);  :---> print all object
     List<Student> youngStudent=   students.stream().filter(s->s.getAge()<20).collect(Collectors.toList());
   System.out.println(youngStudent);
    }
}
