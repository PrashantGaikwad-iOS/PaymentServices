package org.example.prashant.ecompaymentservices.Service;

import org.example.prashant.ecompaymentservices.DTO.PaymentResponse;
import org.springframework.stereotype.Service;

@Service("stripe")
public class StripePaymentServiceImpl implements PaymentService {
    @Override
    public String doPayment(String email, String phoneNumber, Long amount, String orderId) {
        return null;
    }
}
