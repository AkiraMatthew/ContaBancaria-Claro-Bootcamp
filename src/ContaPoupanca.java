import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaPoupanca {

    private static void menu(){
        System.out.println("----MENU DE CADASTRO de Conta Poupança----");
        System.out.println("--Digite a opçao para prosseguir--");
        System.out.println("1. Número de Conta");
        System.out.println("2. Número da Agência");
        System.out.println("3. Nome do Cliente");
        System.out.println("4. Saldo para análise");
        System.out.println("5. Para finalizar o cadastro.");
    }

    private static String getInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        String input = scanner.nextLine();

        System.out.println("Informaçao salva com sucesso: " + input + "!");

        return input;
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
    private static boolean validatedData(Integer numberAcc, Integer agency, String name, Double balance){
        return numberAcc != null && agency != null && name != null && balance != null;
    }

    private static void providedData(Object data){
        System.out.println("Os dados fornecidos precisam ser do tipo " + data);
    }


    public static void main(String[] args) {
        boolean running = true;
        // Instead of using int and double
        // we use the wrapped classes to solve the null variables since int and double cannot be null.
        Scanner scanner = new Scanner(System.in);
        Integer numberAcc = null;
        Integer agency = null;
        String name = null;
        Double balance = null;

        while (running){
            menu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1 -> {
                    try {
                        numberAcc = Integer.parseInt(getInput(scanner, "Digite o número da sua conta corrente: "));
                    } catch (NumberFormatException e) {
                        providedData("Inteiro");
                    }
                }
                case 2 -> { 
                    try {
                        agency = Integer.parseInt(getInput(scanner, "Digite o número de sua agência: "));
                    } catch (NumberFormatException e) {
                        providedData("Inteiro");
                    }
                }
                case 3 -> {
                    try {
                        name = getInput(scanner, "Digite seu nome completo: ");
                        validateName(name);
                    } catch (InputMismatchException e) {
                        providedData("String");
                    }
                }
                case 4 -> {
                    try {
                        balance = Double.parseDouble(getInput(scanner, "Digite seu saldo disponível que deseja utilizar: "));
                    } catch (NumberFormatException e) {
                        providedData("Double");
                    }
                }
                case 5 -> { 
                    if(validatedData(numberAcc, agency, name, balance)) {
                        System.out.println("----FINALIZANDO CADASTRO---");
                        System.out.println(
                            "Conta: " + numberAcc + "\n" +
                            "Agência: " + agency + "\n" +
                            "Nome Completo: " + name + "\n" +
                            "Saldo depositado: " + balance
                            );
                        running = false;
                    } else {
                        System.out.println("Todos os campos devem ser preenchidos antes de finalizar o cadastro.");
                    }
                }
                default -> System.out.println("Esta opçao nao existe.");
            }
        }

        scanner.close();
    }

        
    
}
