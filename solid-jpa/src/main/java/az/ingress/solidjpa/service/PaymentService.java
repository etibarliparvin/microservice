package az.ingress.solidjpa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentService {

    public void chargeCustomer(Chargeable charge) {
        charge.charge(10D);
    }
}
