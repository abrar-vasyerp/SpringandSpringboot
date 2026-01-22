package com.abrar.demo;

import org.springframework.stereotype.Component;

@Component("igstStrategy")
public class IGSTStrategy implements TaxStrategy {
    @Override
    public void applyTax() {
        System.out.println("Inter State GST is applied...");
    }
}
