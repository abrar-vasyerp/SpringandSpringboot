package com.abrar.demo;

import org.springframework.stereotype.Component;

@Component("gstStrategy")
public class GSTStrategy implements TaxStrategy {
    @Override
    public void applyTax() {
        System.out.println("GST is applied...");
    }
}
