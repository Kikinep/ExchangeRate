package com.kikinep.exchangerate.models;

public record ExchangeRateKeys(String base_code, String target_code, double conversion_rate, double conversion_result) {
}
