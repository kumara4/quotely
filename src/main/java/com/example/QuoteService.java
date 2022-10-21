package com.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QuoteService {
    private static final String FORISMATIC_URI = "http://forismatic.com/api/1.0/";
    private static final String ERROR_MESSAGE = "Unable to generate quote at this time.";

    public static String getQuote(String language) {
        HttpResponse<String> response;
        try {
            byte[] requestBody = ("method=getQuote&format=json&param=ms&lang=" + language).getBytes();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(FORISMATIC_URI))
                    .headers("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofByteArray(requestBody))
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            return ERROR_MESSAGE;
        }

        if (response.statusCode() != 200 || !response.body().contains("quoteText")) {
            return ERROR_MESSAGE;
        }

        Gson g = new Gson();
        Quote quote = g.fromJson(response.body(), Quote.class);
        return "Quote: " + quote.getQuoteText() + "- " + quote.getQuoteAuthor();
    }
}
