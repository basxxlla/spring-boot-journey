import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        //Filter even numbers
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        //Sort descending
        List<Integer> sortedList = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        //Remove duplicates
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();

        // Any number divisible by 5
        boolean anyDivBy5 = numbers.stream()
                .anyMatch(n -> n % 5 == 0);

        //Collect into Set
        Set<Integer> numberSet = numbers.stream()
                .collect(Collectors.toSet());

        //Skip first 3
        List<Integer> skipped = numbers.stream()
                .skip(3)
                .toList();

        //Sum using reduce
        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        //Max & Min
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        Optional<Integer> min = numbers.stream().min(Integer::compare);

        //Multiply all numbers
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);

        //Count positive numbers
        long positives = numbers.stream()
                .filter(n -> n > 0)
                .count();

        //Partition even/odd
        /* Map<Boolean, List<Integer>> evenOdd = numbers.stream()
                        .collect(Collectors.partitioningBy(n -> n % 0 == 0)); // wrong
        */
        Map<Boolean, List<Integer>> evenOdd = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        //Names starting with "A"
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
        List<String> namesWithA = names.stream()
                .filter(n -> n != null && n.startsWith("A"))
                .toList();

        //Convert to uppercase
        List<String> upperNames = names.stream()
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .toList();

        //Count strings longer than 5
        long countLong = names.stream()
                .filter(n -> n != null && n.length() > 5)
                .count();
        //Find first matching that starts with "S"
        Optional<String> firstS = names.stream()
                .filter(n -> n != null && n.startsWith("S"))
                .findFirst();

        //Comma-separated string
        String joinedNames = names.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", "));

        //Average students' grades
        List<Student> students = Arrays.asList(
                new Student("Ali", "IT", 85),
                new Student("Mona", "CS", 92),
                new Student("Ahmed", "IT", 60),
                new Student("Sara", "CS", 70),
                new Student("Omar", "IS", 45),
                new Student("Laila", "IS", 78)
        );

        OptionalDouble avgGrade = students.stream()
                .mapToDouble(Student::getGrade)
                .average();

        //Group students by department
        Map<String, List<Student>> byDept = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));

        //Group employees by age and count
        List<Employee> employees = Arrays.asList(
                new Employee("Ali", 30, "HR", 5000),
                new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500),
                new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200)
        );

        Map<Integer, Long> countByAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));

        //Average salary per department
        Map<String, Double> avgSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        //Flatten nested list
        List<List<String>> nestedWords = Arrays.asList(
                Arrays.asList("Java", "Stream"),
                Arrays.asList("API", "Lambda"),
                Arrays.asList("FlatMap", "Map")
        );

        List<String> flat = nestedWords.stream()
                .flatMap(List::stream)
                .toList();

        //Unique characters from words
        Set<Character> uniqueChars = names.stream()
                .filter(Objects::nonNull)
                .flatMap(s -> s.chars().mapToObj(c -> (char)c))
                .collect(Collectors.toSet());

        //Filter Optionals
        List<Optional<String>> optionals = Arrays.asList(
                Optional.of("Ali"), Optional.empty(), Optional.of("Sara")
        );

        List<String> present = optionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        //Map strings to lengths
        List<Integer> lengths = names.stream()
                .filter(Objects::nonNull)
                .map(String::length)
                .toList();

        //Uppercase words starting with A
        List<String> upperA = names.stream()
                .filter(n -> n != null && n.startsWith("A"))
                .map(String::toUpperCase)
                .toList();

        //Sort employees by salary then name
        List<Employee> sortedEmp = employees.stream()
                .sorted(Comparator
                        .comparing(Employee::getSalary)
                        .thenComparing(Employee::getName))
                .toList();

        //Second-highest number
        Optional<Integer> secondHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        //Find duplicates
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = numbers.stream()
                .filter(n -> !seen.add(n))
                .collect(Collectors.toSet());

        //Remove null or empty strings
        List<String> cleanNames = names.stream()
                .filter(n -> n != null && !n.isEmpty())
                .toList();

        //Partition students pass/fail
        Map<Boolean, List<Student>> passFail = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getGrade() >= 50));
    }


}