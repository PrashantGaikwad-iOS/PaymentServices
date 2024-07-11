package org.example.prashant.ecompaymentservices.Controller;

import com.razorpay.RazorpayException;
import org.example.prashant.ecompaymentservices.DTO.InitialPaymentRequestDTO;
import org.example.prashant.ecompaymentservices.DTO.PaymentResponse;
import org.example.prashant.ecompaymentservices.Service.PaymentService;
import org.example.prashant.ecompaymentservices.Service.Strategy.PaymentGatewaySelectionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private PaymentService razorpayPaymentService;
    private PaymentService stripePaymentService;

    private PaymentGatewaySelectionStrategy paymentGatewaySelectionStrategy;

    public PaymentController(@Qualifier("razorpay") PaymentService razorpayPaymentService,
                             @Qualifier("stripe") PaymentService stripePaymentService,
                             PaymentGatewaySelectionStrategy paymentGatewaySelectionStrategy
    ) {
        this.razorpayPaymentService = razorpayPaymentService;
        this.stripePaymentService = stripePaymentService;
        this.paymentGatewaySelectionStrategy = paymentGatewaySelectionStrategy;
    }

    @PostMapping("/payment")
    public String initiatePayment(@RequestBody InitialPaymentRequestDTO requestDto) throws RazorpayException {
        int paymentGatewayOption = choosePaymentGateway();
        switch (paymentGatewayOption) {
            case 1: return razorpayPaymentService.doPayment(requestDto.getEmail(), requestDto.getPhoneNumber(), requestDto.getAmount(), requestDto.getOrderId());
            case 2: return stripePaymentService.doPayment(requestDto.getEmail(), requestDto.getPhoneNumber(), requestDto.getAmount(), requestDto.getOrderId());
        }
        return null;
    }

    private int choosePaymentGateway() {
        return paymentGatewaySelectionStrategy.paymentGatewaySelection();
    }
}
