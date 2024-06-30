package com.tracker.expense_tracker_application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Currency;
import java.util.Set;

@Controller
public class CurrencyConverterController {
    @Autowired
    private CurrencyConverterService currencyConverterService;

    @GetMapping("/currency-converter")
    public String showCurrencyConverterForm(Model model) {
        Set<String> supportedCurrencies = currencyConverterService.getSupportedCurrencies();
        model.addAttribute("supportedCurrencies", supportedCurrencies);
        return "currency-converter";
    }
    @PostMapping("/currency-converter")
    public String convertCurrency(@RequestParam String fromCurrency, @RequestParam String toCurrency, @RequestParam double amount, Model model) {
        double convertedAmount = currencyConverterService.convert(fromCurrency, toCurrency, amount);
        model.addAttribute("convertedAmount", convertedAmount);
        Set<String> supportedCurrencies = currencyConverterService.getSupportedCurrencies();
        model.addAttribute("supportedCurrencies", supportedCurrencies);
        return "currency-converter";

}
