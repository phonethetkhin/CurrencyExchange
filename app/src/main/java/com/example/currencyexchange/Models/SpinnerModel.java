package com.example.currencyexchange.Models;

import java.util.List;

public class SpinnerModel {
private String CurrencyCode;
private int CountryFlag;

    public SpinnerModel(String currencyCode, int countryFlag) {
        CurrencyCode = currencyCode;
        CountryFlag = countryFlag;
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public int getCountryFlag() {
        return CountryFlag;
    }
}

