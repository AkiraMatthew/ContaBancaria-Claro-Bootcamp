import java.util.InputMismatchException;
import java.util.Scanner;
import utils.AgencyValidator;
import utils.InputUtils;
import utils.NumberAccValidator;
import utils.ValidationUtils;

public class ContaPoupanca {

    private static void menu(){
        System.out.println("----MENU DE CADASTRO de Conta Poupança----");
        System.out.println("--Digite a opçao para prosseguir--");
        System.out.println("1. Número de Conta");
        System.out.println("2. Número da Agência");
        System.out.println("3. Nome do Cliente");
        System.out.println("4. Saldo para análise");
        System.out.println("5. Para finalizar o cadastro.\n");
    }


    public static void main(String[] args) {
        boolean running = true;
        // Instead of using int and double
        // we use the wrapped classes to solve the null variables since int and double cannot be null.
        Scanner scanner = new Scanner(System.in);
        String numberAcc = null;
        String agency = null;
        String name = null;
        Double balance = null;

        while (running){
            menu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1 -> {
                    try {
                        String input = InputUtils.getInput(scanner, "Digite o número da sua conta corrente: ");
                        numberAcc = NumberAccValidator.validateAndFormatNumberAcc(input);
                    } catch (IllegalArgumentException e) {
                        InputUtils.providedData("Inteiro e conter 9 dígitos");
                    }
                }
                case 2 -> { 
                    try {
                        String input = InputUtils.getInput(scanner, "Digite o número de sua agência: ");
                        agency = AgencyValidator.validateAgency(input);
                    } catch (IllegalArgumentException e) {
                        InputUtils.providedData("Inteiro e conter 4 dígitos");
                    }
                }
                case 3 -> {
                    try {
                        name = InputUtils.getInput(scanner, "Digite seu nome completo: ");
                        ValidationUtils.validateName(name);
                    } catch (InputMismatchException e) {
                        InputUtils.providedData("String");
                    }
                }
                case 4 -> {
                    try {
                        balance = Double.valueOf(InputUtils.getInput(scanner, "Digite seu saldo disponível que deseja utilizar: "));
                    } catch (NumberFormatException e) {
                        InputUtils.providedData("Double");
                    }
                }
                case 5 -> { 
                    if(ValidationUtils.validatedData(numberAcc, agency, name, balance)) {
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
                        System.out.println(
                            "Conta: " + numberAcc + "\n" +
                            "Agência: " + agency + "\n" +
                            "Nome Completo: " + name + "\n" +
                            "Saldo depositado: " + balance
                            );
                    }
                }
                default -> System.out.println("Esta opçao nao existe.");
            }
        }

        scanner.close();
    }

        
    
}
