package com.example.currencyexchange.Models;

public class CurrencyModel {
    private String CurrencyCode;
    private String CurrencyName;
    private int CountryImage;
    private String Value;

    public CurrencyModel(String currencyCode, String currencyName, int countryImage, String value) {
        CurrencyCode = currencyCode;
        CurrencyName = currencyName;
        CountryImage = countryImage;
        Value = value;
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public String getCurrencyName() {
        return CurrencyName;
    }

    public int getCountryImage() {
        return CountryImage;
    }

    public String getValue() {
        return Value;
    }
}
