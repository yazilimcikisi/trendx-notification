package com.trendx.notification.controllers;

import com.trendx.notification.entities.UserProductPair;
import com.trendx.notification.entities.User;
import com.trendx.notification.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/addFollowed")
    public User addProductToUser(@RequestBody UserProductPair userProductPair) {
        return userService.addProductToUser(userProductPair);
    }
}
