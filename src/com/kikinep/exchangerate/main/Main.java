package com.kikinep.exchangerate.main;

import com.kikinep.exchangerate.models.CurrencyConversion;
import com.kikinep.exchangerate.models.ExchangeRateRequest;
import com.kikinep.exchangerate.models.RequestHistory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int selection = 0;
        RequestHistory history = new RequestHistory();

        String mainMenu = """

                ****************************************************
                Welcome to the Currency Conversion System!

                What would you like to do?

                1) Convert Currency
                2) Show Conversion History
                3) Exit

                ****************************************************

                """;

        String currencyCodeMenu = """

                ****************************************************
                From which currency code would you like to convert?
                
                Example currency codes:

                ARS - Argentine Peso
                BOB - Bolivian Boliviano
                BRL - Brazilian Real
                CLP - Chilean Peso
                COP - Colombian Peso
                USD - United States Dollar
                MXN - Mexican Peso

                ****************************************************

                """;

        while (selection != 3) {
            System.out.println(mainMenu);
            try {
                selection = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                selection = 0;
            }

            if (selection == 1) {
                System.out.println(currencyCodeMenu);
                System.out.println("From which currency code would you like to convert?");
                String fromCurrency = scanner.nextLine();
                System.out.println("To which currency code would you like to convert?");
                String toCurrency = scanner.nextLine();
                System.out.println("Input the amount of " + fromCurrency + " you would like to convert to " + toCurrency + ":");
                String amount = scanner.nextLine();

                ExchangeRateRequest request = new ExchangeRateRequest(fromCurrency, toCurrency, amount);

                if (request.getResponse().statusCode() == 200) {
                    CurrencyConversion newConversion = new CurrencyConversion(request.convertCurrency(), amount);
                    history.addConversion(newConversion);
                    System.out.println(newConversion);
                } else {
                    System.out.println("Unable to make conversion due to an error in currency codes or amount!");
                }

            } else if (selection == 2) {
                if (history.getConversions() > 0) {
                    System.out.println("Conversion History:");
                    for (CurrencyConversion conversion : history.getHistory()) {
                        System.out.println(conversion);
                        }
                } else {
                    System.out.println("Your haven't converted any currencies yet!");
                }
            } else if (selection < 1 || selection > 3) {
                System.out.println("Please select a valid option from the menu!");
            }
        }

        System.out.println("Thank you for using the Currency Conversion System!");
    }
}