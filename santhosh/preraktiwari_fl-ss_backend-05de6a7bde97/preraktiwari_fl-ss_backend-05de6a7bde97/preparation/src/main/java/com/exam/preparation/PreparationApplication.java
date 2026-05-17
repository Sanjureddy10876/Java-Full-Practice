package com.exam.preparation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PreparationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PreparationApplication.class, args);
    }


    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);

    List<Integrer> evenNumbers = numbers.stream().filter(num -> num % 2 ==0).collect(Collectors.toList());

        System.out.println(evenNumbers);
}
