package com.abrar.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    @Autowired
    @Qualifier("gstStrategy")
    private TaxStrategy gstStrategy;

    @Autowired
    @Qualifier("igstStrategy")
    private TaxStrategy igstStrategy;

    public void billWithGST() {
        gstStrategy.applyTax();

    }

    public void billWithIGST() {
        igstStrategy.applyTax();

    }
}
