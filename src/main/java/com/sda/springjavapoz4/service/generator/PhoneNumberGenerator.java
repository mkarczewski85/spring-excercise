package com.sda.springjavapoz4.service.generator;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberGenerator {

    private String prefix;
    private String firstPart;
    private String secondPart;
    private String thirdPart;

    public PhoneNumberGenerator(String prefix) {
        this.prefix = prefix;
    }

    public String getRandomNumber(){
        firstPart = RandomStringUtils.randomNumeric(3);
        secondPart = RandomStringUtils.randomNumeric(3);
        thirdPart = RandomStringUtils.randomNumeric(3);
        return prefix + " " + firstPart + "-" + secondPart + "-" + thirdPart;
    }
}
