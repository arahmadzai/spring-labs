package com.cydeo.tightly;

import com.cydeo.CustomerBalance;
import com.cydeo.GiftCardBalance;
import com.cydeo.loosely.Balance;

import java.math.BigDecimal;

public class BalanceService {
    Balance customerBalance;
    Balance giftCardBalance;

    public BalanceService(Balance customerBalance, Balance giftCardBalance) {
        this.customerBalance = customerBalance;
        this.giftCardBalance = giftCardBalance;
    }

    public boolean checkoutFromCustomerBalance(BigDecimal checkoutAmount){
        BigDecimal customerBalanceAmount = customerBalance.getAmount();

        return customerBalanceAmount.subtract(checkoutAmount)
                .compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean checkoutFromGiftBalance(BigDecimal checkoutAmount){
        BigDecimal giftCardBalanceAmount = giftCardBalance.getAmount();

        return giftCardBalanceAmount.subtract(checkoutAmount)
                .compareTo(BigDecimal.ZERO) > 0;
    }
}
