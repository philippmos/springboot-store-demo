package de.philippmoser.store;

import de.philippmoser.store.entities.Address;
import de.philippmoser.store.entities.Profile;
import de.philippmoser.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(StoreApplication.class, args);

        var user = User.builder()
                        .name("John")
                        .email("john@example.com")
                        .password("secret")
                        .build();

        var address = Address.builder()
                        .street("street")
                        .city("city")
                        .state("state")
                        .build();

        user.addAddress(address);

        user.addTag("Tag 1");

        var profile = Profile.builder()
                            .bio("bioo")
                            .build();

        user.addProfile(profile);


        System.out.println(user);
    }
}
