package com.training.emilylesson2.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService  {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private StorageService storageService;

    public void pay(float amount){
        LOG.info("Register payment with amount: " + amount);
        String converterText = String.valueOf(amount);
        storageService.save(converterText);

        LOG.debug("Payment registered successfully");
    }

    public float showLastPaymentAmount(){
    LOG.debug("ShowLastPaymentAmouth method called");

    String storedText = storageService.load();
    if(storedText.equals("")){
        return 0;
    }
    return Float.valueOf(storedText);
    }

}
