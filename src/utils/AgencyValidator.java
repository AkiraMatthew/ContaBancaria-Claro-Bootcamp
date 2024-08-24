package utils;

public class AgencyValidator {
    private AgencyValidator() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String validateAgency(String agency) {
        if(agency.length() != 4)
            throw new IllegalArgumentException("O número da agência deve conter 4 dígitos");

        return agency;
    }
}
