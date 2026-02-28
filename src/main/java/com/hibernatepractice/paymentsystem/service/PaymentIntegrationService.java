package com.hibernatepractice.paymentsystem.service;



import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class PaymentIntegrationService {

    public String createOrderWithDueDate(double amount, int gracePeriodDays) throws Exception {
        // Edge Case Logic: If today is a weekend, should the due date move to Monday?
        // This is the type of challenge you discuss in professional communities.
        LocalDate dueDate = LocalDate.now().plusDays(gracePeriodDays);

        // Simulating Razorpay Client Integration
        RazorpayClient razorpay = new RazorpayClient("rzp_test_key", "rzp_test_secret");

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100); // Amount in paise
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "txn_12345");
        orderRequest.put("notes", new JSONObject().put("due_date", dueDate.toString()));

        Order order = razorpay.orders.create(orderRequest);
        return order.get("id");
    }
}