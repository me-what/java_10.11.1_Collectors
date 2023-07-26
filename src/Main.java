import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, List<Phone>> phonesByCompany = phoneStream.collect(
                Collectors.groupingBy(Phone::getCompany));

        for(Map.Entry<String, List<Phone>> item : phonesByCompany.entrySet()){
            System.out.println(item.getKey());
            for(Phone phone : item.getValue()){
                System.out.println(phone.getName());
            }
            System.out.println("\n");
        }



        System.out.println("Method Collectors.partitioningBy:"+"\n");
        Stream<Phone> phoneStream2 = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<Boolean, List<Phone>> phonesByCompany2 = phoneStream2.collect(
                Collectors.partitioningBy(p->p.getCompany()=="Apple"));

        for(Map.Entry<Boolean, List<Phone>> item : phonesByCompany2.entrySet()){

            System.out.println(item.getKey());
            for(Phone phone : item.getValue()){
                System.out.println(phone.getName());
            }
            System.out.println();
        }
        System.out.println("\n");



        System.out.println("Method Coollectors.counting"+"\n");
        Stream<Phone> phoneStream3 = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, Long> phonesByCompany3 = phoneStream3.collect(
                Collectors.groupingBy(Phone::getCompany, Collectors.counting()));

        for(Map.Entry<String, Long> item : phonesByCompany3.entrySet()){
            System.out.println(item.getKey() + " - " + item.getValue());
        }
        System.out.println("\n");



        System.out.println("Method Coollectors.summing"+"\n");
        Stream<Phone> phoneStream4 = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, Integer> phonesByCompany4 = phoneStream4.collect(
                Collectors.groupingBy(Phone::getCompany, Collectors.summingInt(Phone::getPrice)));

        for(Map.Entry<String, Integer> item : phonesByCompany4.entrySet()){

            System.out.println(item.getKey() + " - " + item.getValue());
        }
        System.out.println("\n");



        System.out.println("Methods maxBy() and minBy() "+"\n");
        Stream<Phone> phoneStream5 = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, Optional<Phone>> phonesByCompany5 = phoneStream5.collect(
                Collectors.groupingBy(Phone::getCompany,
                        Collectors.minBy(Comparator.comparing(Phone::getPrice))));

        for(Map.Entry<String, Optional<Phone>> item : phonesByCompany5.entrySet()){
            System.out.println(item.getKey() + " - " + item.getValue().get().getName());
        }
        System.out.println("\n");



        System.out.println("Method summarizing "+"\n");
        Stream<Phone> phoneStream6 = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, IntSummaryStatistics> priceSummary = phoneStream6.collect(
                Collectors.groupingBy(Phone::getCompany,
                        Collectors.summarizingInt(Phone::getPrice)));

        for(Map.Entry<String, IntSummaryStatistics> item : priceSummary.entrySet()){
            System.out.println(item.getKey() + " - " + item.getValue().getAverage());
        }
        System.out.println("\n");



        System.out.println("Method mapping "+"\n");
        Stream<Phone> phoneStream7 = Stream.of(new Phone("iPhone X", "Apple", 600),
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, List<String>> phonesByCompany7 = phoneStream7.collect(
                Collectors.groupingBy(Phone::getCompany,
                        Collectors.mapping(Phone::getName, Collectors.toList())));

        for(Map.Entry<String, List<String>> item : phonesByCompany7.entrySet()){
            System.out.println(item.getKey());
            for(String name : item.getValue()){
                System.out.println(name);
            }
        }
    }
}