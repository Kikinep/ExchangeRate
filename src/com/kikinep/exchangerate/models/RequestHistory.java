package com.kikinep.exchangerate.models;

import java.util.ArrayList;

public class RequestHistory {
    private final ArrayList<CurrencyConversion> history;
    private int conversions = 0;

    public RequestHistory() {
        this.history = new ArrayList<>();
    }

    public ArrayList<CurrencyConversion> getHistory() {
        return history;
    }

    public int getConversions() {
        return conversions;
    }

    public void addConversion(CurrencyConversion conversion) {
        this.history.add(conversion);
        this.conversions++;
    }
}
