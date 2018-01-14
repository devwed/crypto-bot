package com.devwed.io.crypto.chatbot.util;

import com.devwed.io.crypto.chatbot.model.coinmarketcap.Currency;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Locale;

public class GainsComparator implements Comparator<Currency> {

    @Override
    public int compare(Currency c1, Currency c2) {

        Double currency1 = Double.parseDouble(c1.getPercent_change_day());
        Double currency2 = Double.parseDouble(c2.getPercent_change_day());

        int result = 0;
        if(currency1 < currency2) result = 1;
        if(currency1 > currency2) result = -1;

        return result;
    }
}
