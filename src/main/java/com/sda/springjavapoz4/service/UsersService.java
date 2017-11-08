package com.sda.springjavapoz4.service;

import com.sda.springjavapoz4.model.User;
import com.sda.springjavapoz4.service.generator.FirstNameGenerator;
import com.sda.springjavapoz4.service.generator.LastNameGenerator;
import com.sda.springjavapoz4.service.generator.PhoneNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class UsersService {


    private List<User> users;

    @Autowired
    FirstNameGenerator firstNameGenerator;
    @Autowired
    LastNameGenerator lastNameGenerator;
    @Autowired
    PhoneNumberGenerator phoneNumberGenerator;

    public UsersService() {
        this.users = new ArrayList<>();

    }

    @PostConstruct
    public void init() {
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        users.forEach(System.out::println);
    }


    public User getUser(int id) {
        return id >= users.size() ? null : users.get(id);
    }

    public User getExampleUser() {
        return new User((long) users.size(), firstNameGenerator.getRandomFirstName(), lastNameGenerator.getRandomLastName(), phoneNumberGenerator.getRandomNumber());
    }


    public List<User> getListOfUsersByFirstName(String firstName) {
        List<User> listOfUsers = users.stream()
                .filter(user -> user.getFirstName().equals(firstName))
                .collect(Collectors.toList());
        return listOfUsers;
    }


    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        user.setId((long) users.size());
        this.users.add(user);
    }

    public User getRandomUser() {
        Random random = new Random();
        return getUser(random.nextInt(users.size()));
    }
}
