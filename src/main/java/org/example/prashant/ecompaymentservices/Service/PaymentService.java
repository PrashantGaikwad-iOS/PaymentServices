package org.example.prashant.ecompaymentservices.Service;

import com.razorpay.RazorpayException;
import org.example.prashant.ecompaymentservices.DTO.PaymentResponse;

public interface PaymentService {
    String doPayment(String email, String phoneNumber, Long amount, String orderId) throws RazorpayException;
}
