package com.sda.springjavapoz4.config;

import com.sda.springjavapoz4.service.generator.PhoneNumberGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhoneNumberConfig {

    @Bean
    public PhoneNumberGenerator phoneNumberGenerator(){
        return new PhoneNumberGenerator("+48");
    }

}
