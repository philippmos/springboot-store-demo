package de.philippmoser.store;

import de.philippmoser.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(StoreApplication.class, args);

        var user1 = new User();
        user1.setName("John");
        user1.setEmail("john@example.com");
        user1.setPassword("secret");

        var user2 = new User(1L, "John", "john@example.com", "secret");

        var user3 = User.builder().name("John").email("john@example.com").password("secret").build();
    }
}
