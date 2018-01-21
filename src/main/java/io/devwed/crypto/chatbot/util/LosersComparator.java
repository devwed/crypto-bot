package io.devwed.crypto.chatbot.util;

import io.devwed.crypto.chatbot.model.coinmarketcap.Currency;

import java.util.Comparator;

public class LosersComparator implements Comparator<Currency> {

    @Override
    public int compare(Currency c1, Currency c2) {

        Double currency1 = Double.parseDouble(c1.getPercent_change_day());
        Double currency2 = Double.parseDouble(c2.getPercent_change_day());

        int result = 0;
        if(currency1 > currency2) result = 1;
        if(currency1 < currency2) result = -1;

        return result;
    }
}
