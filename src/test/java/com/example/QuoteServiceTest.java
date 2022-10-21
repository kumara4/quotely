package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class QuoteServiceTest {

    @Test
    public void testLanguageNotSupported() {
        String output = QuoteService.getQuote("es");
        Assertions.assertEquals("Unable to generate quote at this time.", output);
    }

    @Test
    public void testSupportedLanguageEN() {
        String output = QuoteService.getQuote("en");
        Assertions.assertTrue(output.contains("Quote:"));
    }

    @Test
    public void testSupportedLanguageRU() {
        String output = QuoteService.getQuote("ru");
        Assertions.assertTrue(output.contains("Quote:"));
    }

}