package com.bank.financial.service;

public class AgencyValidatorService {
    private AgencyValidatorService() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String validateAgency(String agency) {
        // Clean the input to keep only digits
        String cleanedAgency = agency.replaceAll("[^\\d]", "");
    
        if(cleanedAgency.length() != 4)
            throw new IllegalArgumentException("O número da agência deve conter 4 dígitos");
    
        return cleanedAgency;
    }

    public static class NumberAccValidator {
        // Private constructor to prevent instantiation
        private NumberAccValidator() {
            throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
        }

        public static String validateAndFormatNumberAcc(String numberAcc) {
            // Removing any non-digit characters(hyphen)
            String cleanedNumber = numberAcc.replaceAll("[^\\d]", "");

            // Check if the account number corresponds to an acceptable length
            if(cleanedNumber.length() != 9)
                throw new IllegalArgumentException("A conta bancária deve ter 9 dígitos");

            // Format as "xxxxxxxx-x"
            return cleanedNumber.substring(0, 8) + "-" + cleanedNumber.substring(8);
        }
    }
}
