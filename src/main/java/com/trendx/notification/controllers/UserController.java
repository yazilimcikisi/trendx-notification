package com.trendx.notification.controllers;

import com.trendx.notification.entities.Holder;
import com.trendx.notification.entities.Product;
import com.trendx.notification.entities.User;
import com.trendx.notification.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        User u = new User(user.geteMail(), user.getFullName());
        userRepository.save(u);
    }

    @PostMapping("/addFollowed")
    public void addProductToUser(@RequestBody Holder h) {

        User user = h.getUser();
        Product product = h.getProduct();

        user.getFollowedProducts().add(product);
        userRepository.save(user);

    }
}
