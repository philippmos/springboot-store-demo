package de.philippmoser.store;

import de.philippmoser.store.notification.NotificationManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(StoreApplication.class, args);

        var orderService = context.getBean(OrderService.class);
        orderService.placeOrder();

        var notificationManager = context.getBean(NotificationManager.class);
        notificationManager.sendNotification("Test Notification");
    }

}
