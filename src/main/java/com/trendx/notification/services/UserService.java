package com.trendx.notification.services;

import com.trendx.notification.entities.UserProductPair;
import com.trendx.notification.entities.Product;
import com.trendx.notification.entities.User;
import com.trendx.notification.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User saveUser(User u) {
        User user = new User(u.geteMail(), u.getFullName());
        userRepository.save(user);
        return user;
    }

    public User addProductToUser(@RequestBody UserProductPair userProductPair) {
        User user = userProductPair.getUser();
        Product product = userProductPair.getProduct();
        user.getFollowedProducts().add(product);
        userRepository.save(user);
        return user;
    }


}
