package de.philippmoser.store.payment;


public class PayPalPaymentService implements PaymentService {

    public static String providerName = "stripe";

    @Override
    public void processPayment(double amount) {
        System.out.println("PAYPAL");
        System.out.println("Amount: " + amount);
    }
}
