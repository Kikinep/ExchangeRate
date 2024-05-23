package com.kikinep.exchangerate.models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateRequest {
    private HttpResponse<String> response;

    public ExchangeRateKeys convertCurrency(String fromCurrency, String toCurrency, double amount) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/84cf85662c139e5872cf2990/pair/"
                        + fromCurrency + "/" + toCurrency + "/" + amount))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.body(), ExchangeRateKeys.class);
    }
}
