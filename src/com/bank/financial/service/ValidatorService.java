package com.bank.financial.service;

public class ValidatorService {
    // Private constructor to prevent instantiation
    private ValidatorService() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }


    // Here we validate if the data given by the user is a real name
    public static void validateName(Object name) {
        if (name == null) {
            throw new IllegalArgumentException("O campo nao pode estar vazio");
        }

        if (!(name instanceof String)) {
            throw new IllegalArgumentException("O nome precisa ser do tipo String");
        }

        String nameStr = (String) name;
        if (!nameStr.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("O nome precisa ser composto de caracteres alfabéticos");
        }
    }

    // Here we validate if all data was provided to proceed with the end of the user registration on its Savings Accounts
    public static boolean validatedData(String numberAcc, String agency, String name, Double balance){
        return numberAcc != null && agency != null && name != null && balance != null;
    }
}
