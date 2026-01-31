package de.philippmoser.store;

import de.philippmoser.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(StoreApplication.class, args);

        User.builder().name("John").email("john@example.com").password("secret").build();
    }

}
