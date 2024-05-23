package com.kikinep.exchangerate.models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateRequest {
    private HttpResponse<String> response = null;

    public ExchangeRateRequest(String fromCurrency, String toCurrency, String amount) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/84cf85662c139e5872cf2990/pair/"
                        + fromCurrency + "/" + toCurrency + "/" + amount))
                .build();

        try {
            this.response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<String> getResponse() {
        return response;
    }

    public ExchangeRateKeys convertCurrency() {
        return new Gson().fromJson(this.response.body(), ExchangeRateKeys.class);
    }
}
