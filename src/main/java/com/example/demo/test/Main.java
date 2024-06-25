package com.example.demo.test;/**
 * @author: xutu
 * @since: 2024/2/19 17:12
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        String s = "爱丽丝,霍华德,科鲁兹";
        if (s.contains("霍华德")){
            System.out.println(s.replace("霍华德","贾斯汀"));
        }



//        List<Person> personList = Arrays.asList(
//                new Person("Alice", "25"),
//                new Person("Bob", "30"),
//                new Person("Charlie", "40")
//        );
//
//        // 使用Stream的flatMap()函数将name和age两个属性合并到一个新的List中
//        List<Object> mergedList = personList.stream()
//                .map(person -> Arrays.asList(person.getName(), person.getAge()))
//                .flatMap(List::stream)
//                .collect(Collectors.toList());
//
//        System.out.println(mergedList);
    }
}

class Person {
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}