package de.philippmoser.store;

import de.philippmoser.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(StoreApplication.class, args);

        var user1 = new User(1L, "John", "john@example.com", "password");

        var user2 = new User();

        user2.setName("John");
        user2.setEmail("john@example.com");
        user2.setPassword("password");
    }

}
