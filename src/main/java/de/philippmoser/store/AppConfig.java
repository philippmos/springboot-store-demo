package de.philippmoser.store;

import de.philippmoser.store.payment.PayPalPaymentService;
import de.philippmoser.store.payment.PaymentService;
import de.philippmoser.store.payment.StripePaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Value("${payment.provider:paypal}")
    private String paymentProvider;

    @Bean
    public PaymentService stripe() {
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal() {
        return new PayPalPaymentService();
    }

    @Bean
    @Lazy
    @Scope("prototype")
    public OrderService orderService() {

        if (paymentProvider.equals(StripePaymentService.providerName)) {
            return new OrderService(stripe());
        }

        return new OrderService(paypal());
    }
}
