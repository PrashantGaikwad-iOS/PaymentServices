package org.example.prashant.ecompaymentservices.Service.Strategy;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelectionStrategyImpl implements PaymentGatewaySelectionStrategy {
    @Override
    public int paymentGatewaySelection() {
        return 0;
    }
}
