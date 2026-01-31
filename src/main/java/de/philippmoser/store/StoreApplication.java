package de.philippmoser.store;

import de.philippmoser.store.notification.NotificationManager;
import de.philippmoser.store.user.User;
import de.philippmoser.store.user.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(StoreApplication.class, args);

        var userService = context.getBean(UserService.class);

        var newUser = new User(1L, "demo@user.com", "strongpassword12345", "Demo User");

        userService.registerUser(newUser);

        context.close();
    }

}
