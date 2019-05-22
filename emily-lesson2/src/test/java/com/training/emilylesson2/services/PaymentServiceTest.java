package com.training.emilylesson2.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceTest {

    @Autowired
    PaymentService paymentService;
    @Test
    public void pay() {

        paymentService.pay(123.45f);


    }

    @Test
    public void showLastPaymentAmount() {
        System.out.println("showLastPaymentAmount");
        float lastPayment = paymentService.showLastPaymentAmount();

        System.out.println("Last Payment "+ lastPayment);
    }
}