package de.philippmoser.store;

import de.philippmoser.store.payment.PaymentService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


public class OrderService {

    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService created");
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("OrderService PreDestroy");
    }

    public void placeOrder() {
        paymentService.processPayment(10);
    }

}
