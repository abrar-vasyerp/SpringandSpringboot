package com.abrar.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("igstStrategy")
@ConfigurationProperties("billing.igst")
public class IGSTStrategy implements TaxStrategy {
    private double rate;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void applyTax() {
        System.out.println("Inter State GST is applied... "+rate);
    }
}
