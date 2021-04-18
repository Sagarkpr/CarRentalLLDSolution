package com.lld.providers;

import com.lld.models.Receipt;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    private Map<String, Double> bookingPaymentMap;
    public PaymentService() {
        this.bookingPaymentMap = new HashMap<>();
    }
    public void pay(String bookingId, double price) {
        System.out.println("Paid SuccessFully Amount " + price);
        bookingPaymentMap.put(bookingId, price);
    }

    public String refund(String bookingId) {
        if(!bookingPaymentMap.containsKey(bookingId)) {
            return "InvalidBookingId";
        }
        System.out.println("Refund SuccessFully Amount " + bookingPaymentMap.get(bookingId));
        return "Successful";
    }
}
