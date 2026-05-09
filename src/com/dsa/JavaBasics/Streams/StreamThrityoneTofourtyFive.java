package com.dsa.JavaBasics.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamThrityoneTofourtyFive {
    public static void main(String[] args) {

        // problem 31
        int[] arr = { 12, 3, 43, 2, 2 };
        double ans = Arrays.stream(arr).boxed().mapToDouble(Integer::doubleValue).average().getAsDouble();

        System.out.println(ans);

        // problem 32

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> interSecIntegers = list1.stream().filter(ele -> list2.contains(ele)).collect(Collectors.toList());
        System.out.println(interSecIntegers);

        List<Integer> ConcatedList = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(ConcatedList);

        // problem 33

        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("alex", "alex@gmail.com"));
        emp.add(new Employee("adam", "adam@gmail.com"));

        Map<String, Long> map = emp.stream().map(ele -> ele.getEmail().substring(ele.getEmail().indexOf("@")))
                .collect(Collectors.groupingBy(ele -> ele, Collectors.counting()));
        System.out.println(map);

        // problem 34

        List<Integer> faboSeries = Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] }).limit(10)
                .map(f -> f[0]).collect(Collectors.toList());
        System.out.println(faboSeries);

        // problem 36
        String namesString = emp.stream().map(person -> person.name).map(ele -> ele.toUpperCase())
                .collect(Collectors.joining("|"));
        System.out.println(namesString);

        // problem 37
        List<String> Strings = Arrays.asList("apple", "banana", "apricot", "cheery", "blueberry", "avacado");
        Map<Character, Long> map2 = Strings.stream()
                .collect(Collectors.groupingBy(ele -> ele.charAt(0), Collectors.counting()));
        System.out.println(map2);

        // problem 38
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("alex", "alex@gmail.com", "atlanta"));
        empList.add(new Employee("adam", "adam@gmail.com", "atlanta"));
        empList.add(new Employee("alex", "alex@gmail.com", "california"));
        empList.add(new Employee("adam", "adam@gmail.com", "california"));
        Map<String, List<Employee>> result = empList.stream().collect(Collectors.groupingBy(ele -> ele.getCity()));
        System.out.println(result);

        // problem 39
        int Multiply = list1.stream().reduce(1, (a, b) -> a * b).intValue();
        System.out.println(Multiply);

        String completeString = Strings.stream().map(ele -> ele.toUpperCase()).collect(Collectors.joining(" "));
        System.out.println(completeString);

        List<List<Integer>> ls = new ArrayList<>();
        ls.add(Arrays.asList(1, 2, 3, 4));
        ls.add(Arrays.asList(1, 2, 3, 4));
        ls.add(Arrays.asList(1, 2, 3, 4));
        List<Integer> flattenedList =

                ls.stream().flatMap(ele -> ele.stream()).collect(Collectors.toList());
        System.out.println(flattenedList);

        // problem 41
        List<Employee> empList2 = new ArrayList<>();
        empList2.add(new Employee("alex", "alex@gmail.com", "atlanta", Arrays.asList("gym", "Gardening")));
        empList2.add(new Employee("adam", "adam@gmail.com", "atlanta", Arrays.asList("gym", "dancing")));
        empList2.add(new Employee("alex", "alex@gmail.com", "california", Arrays.asList("gym", "clubing")));
        empList2.add(new Employee("adam", "adam@gmail.com", "california", Arrays.asList("gym", "Music")));
        String topHobby = empList2.stream().map(ele -> ele.getHobbies()).flatMap(ele -> ele.stream())
                .collect(Collectors.groupingBy(ele -> ele, Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);

        System.out
                .println(topHobby);

        // problem 45
        List<Employee> empList3 = new ArrayList<>();
        empList3.add(new Employee("alex", "alex@gmail.com", "atlanta", Arrays.asList("gym", "Gardening"), 31));
        empList3.add(new Employee("adam", "adam@gmail.com", "atlanta", Arrays.asList("gym", "dancing"), 21));
        empList3.add(new Employee("alex", "alex@gmail.com", "california", Arrays.asList("gym", "clubing"), 32));
        empList3.add(new Employee("adam", "adam@gmail.com", "california", Arrays.asList("gym", "Music"), 43));
        List<String> uniqueNames = empList3.stream().filter(ele -> ele.getAge() > 30).map(ele -> ele.getName())
                .distinct().sorted().collect(Collectors.toList());
        System.out.println(uniqueNames);

        List<Product> products = new ArrayList<>();

        List<String> productNames = products.stream().filter(ele -> ele.price < 1000.0).map(ele -> ele.name)
                .collect(Collectors.toList());
        System.out.println(productNames);

        List<Product> reducedPrices = products.stream().map(
                product -> {
                    double discountedPrice = product.price * 0.80;
                    product.setPrice(discountedPrice);
                    return product;
                }).collect(Collectors.toList());

        System.out.println(reducedPrices);

        double AveragePrice = products.stream().mapToDouble(ele -> ele.price).average().getAsDouble();
        System.out.println(AveragePrice);
        double maxPrice = products.stream().sorted((ele1, ele2) -> Double.compare(ele2.price, ele1.price))
                .map(ele -> ele.price).findFirst().orElse(0.0);
        System.out.println(maxPrice);

    }

}

class Product {

    int id;
    double price;
    String name;
    String category;

    Product(int id, double price, String name, String category) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Employee {

    public String name;
    public String email;
    public String city;
    public List<String> hobbies;
    public int age;

    Employee(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;

    }

    Employee(String name, String email, String city, List<String> hobbies) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.hobbies = hobbies;

    }

    Employee(String name, String email, String city, List<String> hobbies, int age) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.hobbies = hobbies;
        this.age = age;

    }

    Employee(String name, String email) {
        this.name = name;
        this.email = email;

    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCity() {
        return this.city;
    }

    public List<String> getHobbies() {
        return this.hobbies;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
