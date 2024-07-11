package org.example.prashant.ecompaymentservices.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitialPaymentRequestDTO {
    private String email;
    private String phoneNumber;
    private Long amount;
    private String orderId;
}
