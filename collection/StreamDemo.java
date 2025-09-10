import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
          // 1. Creating Streams
        System.out.println("=== Creating Streams ===");
        // From Collection
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Anna", "Alex");
        Stream<String> nameStream = names.stream();
        
        // From array
        String[] nameArray = {"John", "Alice", "Bob", "Anna", "Alex"};
        Stream<String> arrayStream = Arrays.stream(nameArray);
        
        // Using Stream.of()
        Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5);
        
        // Infinite streams
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2).limit(5);
        infiniteStream.forEach(n -> System.out.print(n + " "));
        System.out.println("\n");
        
        // 2. Intermediate Operations
        System.out.println("=== Intermediate Operations ===");
        // Filter
        System.out.println("Filter names starting with 'A':");
        names.stream()
             .filter(name -> name.startsWith("A"))
             .forEach(System.out::println);
        System.out.println("**********************************************");
        // Map
        System.out.println("\nConvert names to uppercase:");
        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
        System.out.println("**********************************************");
        
        // FlatMap
        System.out.println("\nFlatMap example:");
        List<List<String>> listOfLists = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("c", "d")
        );
        listOfLists.stream()
                  .flatMap(Collection::stream)
                  .forEach(System.out::println);
        
        System.out.println("**********************************************");
        // Distinct
        System.out.println("\nDistinct elements:");
        Stream.of(1, 2, 2, 3, 3, 3, 4)
              .distinct()
              .forEach(System.out::print);
        
        System.out.println("**********************************************");
        // Sorted
        System.out.println("\n\nSorted names:");
        names.stream()
             .sorted()
             .forEach(n -> System.out.print(n + " "));
       
        System.out.println("**********************************************"); 
        // Peek (for debugging)
        System.out.println("\n\nPeek example:");
        names.stream()
             .filter(name -> name.length() > 3)
             .peek(e -> System.out.println("Filtered value: " + e))
             .map(String::toUpperCase)
             .peek(e -> System.out.println("Mapped value: " + e))
             .collect(Collectors.toList());
        
        System.out.println("**********************************************");
        // Limit and Skip
        System.out.println("\nLimit and Skip:");
        Stream.iterate(1, n -> n + 1)
              .skip(5)
              .limit(5)
              .forEach(n -> System.out.print(n + " "));
       
        System.out.println("**********************************************"); 
        // 3. Terminal Operations
        System.out.println("\n\n=== Terminal Operations ===");
        // forEach
        System.out.println("ForEach:");
        names.forEach(System.out::println);
        
        System.out.println("**********************************************");
        // collect
        System.out.println("\nCollect to list:");
        List<String> filteredNames = names.stream()
                                        .filter(name -> name.length() > 3)
                                        .collect(Collectors.toList());
        System.out.println(filteredNames);
        
        System.out.println("**********************************************");
        // reduce
        System.out.println("\nSum of numbers:");
        int sum = Stream.of(1, 2, 3, 4, 5)
                       .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        
        System.out.println("**********************************************");
        // min and max
        System.out.println("\nMin and Max:");
        Optional<String> minName = names.stream().min(String::compareTo);
        Optional<String> maxName = names.stream().max(String::compareTo);
        minName.ifPresent(name -> System.out.println("Min name: " + name));
        maxName.ifPresent(name -> System.out.println("Max name: " + name));
        
        System.out.println("**********************************************");
        // count
        long count = names.stream().count();
        System.out.println("\nCount: " + count);
        
        System.out.println("**********************************************");
        // anyMatch, allMatch, noneMatch
        boolean anyStartsWithA = names.stream().anyMatch(name -> name.startsWith("A"));
        boolean allStartWithA = names.stream().allMatch(name -> name.startsWith("A"));
        boolean noneStartWithZ = names.stream().noneMatch(name -> name.startsWith("Z"));
        
        System.out.println("\nAny starts with 'A': " + anyStartsWithA);
        System.out.println("All start with 'A': " + allStartWithA);
        System.out.println("None start with 'Z': " + noneStartWithZ);
        
        System.out.println("**********************************************");
        // findFirst and findAny
        Optional<String> firstName = names.stream().findFirst();
        Optional<String> anyName = names.stream().findAny();
        firstName.ifPresent(name -> System.out.println("\nFirst name: " + name));
        anyName.ifPresent(name -> System.out.println("Any name: " + name));
        
        System.out.println("**********************************************");
        // 4. Numeric Streams
        System.out.println("\n=== Numeric Streams ===");
        // range and rangeClosed
        System.out.println("Range (exclusive):");
        IntStream.range(1, 5).forEach(n -> System.out.print(n + " "));
        
        System.out.println("\nRange (inclusive):");
        IntStream.rangeClosed(1, 5).forEach(n -> System.out.print(n + " "));
        
        System.out.println("**********************************************");
        // sum, average, max, min
        System.out.println("\n\nSum: " + IntStream.range(1, 6).sum());
        System.out.println("Average: " + IntStream.range(1, 6).average().orElse(0));
        System.out.println("Max: " + IntStream.range(1, 6).max().orElse(0));
        System.out.println("Min: " + IntStream.range(1, 6).min().orElse(0));
        
        System.out.println("**********************************************");
        // 5. Collectors
        System.out.println("\n=== Collectors ===");
        // toList, toSet, toMap
        Set<String> nameSet = names.stream()
                                 .collect(Collectors.toSet());
        System.out.println("Set: " + nameSet);
        
        Map<String, Integer> nameLengthMap = names.stream()
                                               .collect(Collectors.toMap(
                                                   Function.identity(),
                                                   String::length
                                               ));
        System.out.println("Name length map: " + nameLengthMap);
        
        System.out.println("**********************************************");
        // joining
        String joinedNames = names.stream()
                                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Joined names: " + joinedNames);
        
        System.out.println("**********************************************");
        // groupingBy
        Map<Integer, List<String>> namesByLength = names.stream()
                                                      .collect(Collectors.groupingBy(String::length));
        System.out.println("Names by length: " + namesByLength);
        
        System.out.println("**********************************************");
        // partitioningBy
        Map<Boolean, List<String>> partitionedNames = names.stream()
                                                         .collect(Collectors.partitioningBy(name -> name.startsWith("A")));
        System.out.println("Partitioned names (starts with 'A'): " + partitionedNames);
        
        System.out.println("**********************************************");
        // 6. Parallel Streams
        System.out.println("\n=== Parallel Streams ===");
        System.out.println("Sequential stream:");
        names.stream()
            .map(String::toUpperCase)
            .forEach(name -> System.out.println(Thread.currentThread().getName() + " - " + name));
            
        System.out.println("\nParallel stream:");
        names.parallelStream()
            .map(String::toUpperCase)
            .forEach(name -> System.out.println(Thread.currentThread().getName() + " - " + name));
            
    }
    }

