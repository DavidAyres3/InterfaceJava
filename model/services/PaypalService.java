
package model.services;

public class PaypalService implements OnlinePaymentService{

    @Override
    public Double paymentFee(Double amount) {
        return amount + amount * 0.01;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount * Math.pow(1.02, months);
    }
    
}
