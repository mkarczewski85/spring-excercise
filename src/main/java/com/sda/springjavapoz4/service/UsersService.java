package com.sda.springjavapoz4.service;

import com.sda.springjavapoz4.model.User;
import com.sda.springjavapoz4.repository.UsersRepository;
import com.sda.springjavapoz4.service.generator.FirstNameGenerator;
import com.sda.springjavapoz4.service.generator.LastNameGenerator;
import com.sda.springjavapoz4.service.generator.PhoneNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UsersService {

    @Autowired
    FirstNameGenerator firstNameGenerator;
    @Autowired
    LastNameGenerator lastNameGenerator;
    @Autowired
    PhoneNumberGenerator phoneNumberGenerator;
    @Autowired
    private UsersRepository usersRepository;

    public UsersService() {

    }

    @PostConstruct
    public void init() {
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.findAll().forEach(System.out::println);
    }


    public User getUser(long id) {
        return usersRepository.findOne(id);
    }

    public User getExampleUser() {
        return new User(firstNameGenerator.getRandomFirstName(), lastNameGenerator.getRandomLastName(),
                phoneNumberGenerator.getRandomNumber());
    }


    public List<User> getListOfUsersByFirstName(String firstName) {
        return usersRepository.findByFirstName(firstName);
    }

    public List<User> getListOfUsersByLastName(String lastName) {
        return StreamSupport.stream(usersRepository.findAll().spliterator(), false)
                .filter(user -> user.getFirstName().equals(lastName))
                .collect(Collectors.toList());
    }

    public List<User> getAllUsers() {
        return StreamSupport.stream(usersRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void addUser(User user) {
        usersRepository.save(user);
    }

    public User getRandomUser() {
        Random random = new Random();
        long size = usersRepository.findAll().spliterator().getExactSizeIfKnown();
        return getUser(random.nextInt((int) size));
    }


}
