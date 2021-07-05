package com.trendx.notification;

import com.trendx.notification.entities.User;
import com.trendx.notification.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationApplication{

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

}
