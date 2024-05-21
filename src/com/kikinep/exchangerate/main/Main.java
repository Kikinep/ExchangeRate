package com.kikinep.exchangerate.main;

import com.kikinep.exchangerate.models.CurrencyConversion;
import com.kikinep.exchangerate.models.ExchangeRateRequest;

public class Main {
    public static void main(String[] args) {
        new CurrencyConversion(new ExchangeRateRequest().convertCurrency("USD", "MXN", "10.53"));
    }
}
