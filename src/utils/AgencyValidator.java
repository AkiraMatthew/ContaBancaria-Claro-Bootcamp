package utils;

public class AgencyValidator {
    private AgencyValidator() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String validateAgency(String agency) {
        // Clean the input to keep only digits
        String cleanedAgency = agency.replaceAll("[^\\d]", "");

        if(cleanedAgency.length() != 4)
            throw new IllegalArgumentException("O número da agência deve conter 4 dígitos");

        return cleanedAgency;
    }
}
