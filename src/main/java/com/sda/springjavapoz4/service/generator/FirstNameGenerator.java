package com.sda.springjavapoz4.service.generator;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FirstNameGenerator {

    private List<String> firstNames;
    Random random;

    public FirstNameGenerator(){
        firstNames = new ArrayList<>();
        firstNames.add("Jan");
        firstNames.add("Michał");
        firstNames.add("Andrzej");
        firstNames.add("Stefan");
        firstNames.add("Walerian");
        firstNames.add("Marcin");
    }

    public String getRandomFirstName(){
        random = new Random();
        return firstNames.get(random.nextInt(firstNames.size()));
    }

}
