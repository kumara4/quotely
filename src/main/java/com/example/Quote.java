package com.example;

import lombok.Getter;

public class Quote {

    @Getter
    private String quoteText;
    @Getter
    private String quoteAuthor;
    private String quoteLink;
    private String senderLink;
    private String senderName;

    @Override
    public String toString() {
        return "Quote{" +
                "quoteText='" + quoteText + '\'' +
                ", quoteAuthor='" + quoteAuthor + '\'' +
                ", quoteLink='" + quoteLink + '\'' +
                ", senderLink='" + senderLink + '\'' +
                ", senderName='" + senderName + '\'' +
                '}';
    }
}
