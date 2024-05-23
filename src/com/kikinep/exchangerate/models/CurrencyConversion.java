package com.kikinep.exchangerate.models;

public class CurrencyConversion {
    private final String fromCurrency;
    private final String toCurrency;
    private final double amount;
    private final double convertedAmount;

    public CurrencyConversion(ExchangeRateKeys keys, double amount) {
        this.fromCurrency = keys.base_code();
        this.toCurrency = keys.target_code();
        this.convertedAmount = keys.conversion_result();
        this.amount = amount;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    @Override
    public String toString() {
        return this.amount + " " + this.fromCurrency
                + " is equal to "
                + this.convertedAmount + " " + this.toCurrency;
    }
}
