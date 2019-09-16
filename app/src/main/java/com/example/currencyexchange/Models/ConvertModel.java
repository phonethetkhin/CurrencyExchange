package com.example.currencyexchange.Models;

public class ConvertModel {
    private String FromValue,ToValue;
    private double Amount;

    public ConvertModel(String fromValue, String toValue, double amount) {
        FromValue = fromValue;
        ToValue = toValue;
        Amount = amount;
    }

    public String getFromValue() {
        return FromValue;
    }

    public String getToValue() {
        return ToValue;
    }

    public double getAmount() {
        return Amount;
    }
}
