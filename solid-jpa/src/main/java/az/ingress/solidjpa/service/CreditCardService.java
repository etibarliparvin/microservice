package az.ingress.solidjpa.service;

public class CreditCardService {
    private Double balance = 100D;

    public Double getBalance() {
        return 0.0;
    }

    public void charge(Double amount) {
        balance -= amount;
    }
}
