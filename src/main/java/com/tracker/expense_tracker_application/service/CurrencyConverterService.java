package com.tracker.expense_tracker_application.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This is a service class for currency conversion.
 * It uses the ExchangeRate-API to get conversion rates and supported currencies.
 */
@Service
public class CurrencyConverterService {
    @Value("${exchangerate.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * This method converts an amount from one currency to another.
     *
     * @param fromCurrency the currency to convert from
     * @param toCurrency the currency to convert to
     * @param amount the amount to convert
     * @return the converted amount
     * @throws RuntimeException if the conversion rate cannot be retrieved
     */
    public double convert(String fromCurrency, String toCurrency, double amount) {
        String urlString = String.format(
                "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s",
                apiKey, fromCurrency, toCurrency
        );
        Map<String, Object> response = restTemplate.getForObject(urlString, Map.class);
        if (response != null && response.get("conversion_rate") != null) {
            double conversionRate = (double) response.get("conversion_rate");
            return amount * conversionRate;
        }
        throw new RuntimeException("Failed to get conversion rate");
    }

    /**
     * This method retrieves the set of currencies supported by the ExchangeRate-API.
     *
     * @return a set of supported currency codes
     * @throws RuntimeException if the supported currencies cannot be retrieved
     */
    public Set<String> getSupportedCurrencies() {
        String urlString = String.format(
                "https://v6.exchangerate-api.com/v6/%s/codes",
                apiKey
        );
        Map<String, Object> response = restTemplate.getForObject(urlString, Map.class);
        if (response != null && response.get("supported_codes") != null) {
            return ((List<List<String>>) response.get("supported_codes")).stream()
                    .map(code -> code.get(0))
                    .collect(Collectors.toSet());
        }
        throw new RuntimeException("Failed to get supported currencies");
    }
}