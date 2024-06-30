package com.tracker.expense_tracker_application.controller;

import com.tracker.expense_tracker_application.service.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 * This is a controller class for currency conversion operations.
 * It handles HTTP GET and POST requests for the "/currency-converter" endpoint.
 * It uses the CurrencyConverterService to perform currency conversion and to get the supported currencies.
 */
@Controller
public class CurrencyConverterController {

    @Autowired
    private CurrencyConverterService currencyConverterService;

    /**
     * This method handles the HTTP GET request for the "/currency-converter" endpoint.
     * It retrieves the supported currencies from the CurrencyConverterService and adds them to the model.
     * It then returns the name of the view to be rendered, in this case "currency-converter".
     *
     * @param model the model to add attributes to for the view
     * @return the name of the view
     */
    @GetMapping("/currency-converter")
    public String showCurrencyConverterForm(Model model) {
        Set<String> supportedCurrencies = currencyConverterService.getSupportedCurrencies();
        model.addAttribute("supportedCurrencies", supportedCurrencies);
        return "currency-converter";
    }

    /**
     * This method handles the HTTP POST request for the "/currency-converter" endpoint.
     * It retrieves the "fromCurrency", "toCurrency", and "amount" parameters from the request.
     * It uses the CurrencyConverterService to convert the amount from the fromCurrency to the toCurrency.
     * It adds the converted amount and the supported currencies to the model.
     * It then returns the name of the view to be rendered, in this case "currency-converter".
     *
     * @param fromCurrency the currency to convert from
     * @param toCurrency the currency to convert to
     * @param amount the amount to convert
     * @param model the model to add attributes to for the view
     * @return the name of the view
     */
    @PostMapping("/currency-converter")
    public String convertCurrency(@RequestParam String fromCurrency, @RequestParam String toCurrency, @RequestParam double amount, Model model) {
        double convertedAmount = currencyConverterService.convert(fromCurrency, toCurrency, amount);
        model.addAttribute("convertedAmount", convertedAmount);
        Set<String> supportedCurrencies = currencyConverterService.getSupportedCurrencies();
        model.addAttribute("supportedCurrencies", supportedCurrencies);
        return "currency-converter";
    }
}