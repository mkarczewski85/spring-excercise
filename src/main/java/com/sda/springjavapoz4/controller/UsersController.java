package com.sda.springjavapoz4.controller;

import com.sda.springjavapoz4.model.User;
import com.sda.springjavapoz4.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService userService;

    @GetMapping("/{id}")
    public ModelAndView getUser(@PathVariable("id") int id) {
        User user = userService.getUser(id);
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping(params = {"lastName"})
    public ModelAndView getUsersByLastName(@RequestParam("lastName") String lastName){
        System.out.println(lastName);
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("lastName", lastName);
        return modelAndView;
    }

    @GetMapping(params = {"firstName"})
    public ModelAndView getUsersByFirstName(@RequestParam("firstName") String firstName){
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("listOfUsers", userService.getListOfUsersByFirstName(firstName));
        return modelAndView;
    }


    @GetMapping("/example")
    public ModelAndView getExampleUser(){
        System.out.println(userService.getExampleUser());
        return new ModelAndView("users");
    }

    @GetMapping("/all")
    public ModelAndView getAllUsers(){
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("listOfUsers", userService.getAllUsers());
        return modelAndView;
    }

    @PostMapping
    public String saveUser(@ModelAttribute User user){
        userService.addUser(user);
        return "redirect:/users/all";
    }

    @PostMapping(consumes = "application/json")
    public String saveUserJSON(@RequestBody User user){
        userService.addUser(user);
        return "redirect:/users/all";
    }

}
