package de.philippmoser.store.user;

import de.philippmoser.store.notification.NotificationService;
import de.philippmoser.store.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public UserService(
            UserRepository userRepository,
            NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException(("User already exists with mail"));
        }

        userRepository.save(user);
        notificationService.send("Registration successfully", user.getEmail());
    }
}
