package com.sda.springjavapoz4.service.generator;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class LastNameGenerator {

    private List<String> lastNames;
    Random random;

    public LastNameGenerator(){
        lastNames = new ArrayList<>();
        lastNames.add("Kowalski");
        lastNames.add("Nowak");
        lastNames.add("Wiśniewski");
        lastNames.add("Kowalewski");
        lastNames.add("Iksiński");
        lastNames.add("Lewandowski");
    }

    public String getRandomLastName(){
        random = new Random();
        return lastNames.get(random.nextInt(lastNames.size()));
    }

}
