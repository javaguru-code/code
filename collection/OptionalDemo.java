import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class OptionalDemo {
    
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Anna", "Alex");
    String name=   names.stream().filter(str->str.contains("o")).findFirst().orElse("No name found");
        System.out.println(name);
    }
}
