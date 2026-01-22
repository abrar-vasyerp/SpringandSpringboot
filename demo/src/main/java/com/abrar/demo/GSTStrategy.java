package com.abrar.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("gstStrategy")
@ConfigurationProperties(prefix = "billing.gst")
public class GSTStrategy implements TaxStrategy {
    private double rate;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void applyTax() {
        System.out.println("GST is applied..."+rate);
    }
}
