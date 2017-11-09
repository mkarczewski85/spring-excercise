package com.sda.springjavapoz4.repository;

import com.sda.springjavapoz4.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<User, Long> {

    List<User> findByFirstName(String firstName);

}
