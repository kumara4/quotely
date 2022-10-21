package com.example;

public class QuotelyGenerator {
    public static void main(String[] args) {
        if (args.length >= 1 && !args[0].equalsIgnoreCase("english") && !args[0].equalsIgnoreCase("russian")) {
            System.out.println(args + " is not a valid input. Valid inputs are: \"English\" or \"Russian\" (case insensitive)");
            return;
        }
        String language = "en";
        if (args.length > 0 && args[0].equalsIgnoreCase("russian")) {
            language = "ru";
        }
        System.out.println(QuoteService.getQuote(language));
    }
}
