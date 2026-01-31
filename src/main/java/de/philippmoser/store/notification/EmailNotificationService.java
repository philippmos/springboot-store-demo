package de.philippmoser.store.notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary
public class EmailNotificationService implements NotificationService {

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("Recipient: " + recipientEmail);
        System.out.println("Message: " + message);
    }

}
