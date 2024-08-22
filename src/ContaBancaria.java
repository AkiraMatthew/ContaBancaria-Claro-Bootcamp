import java.util.Scanner;
import java.util.logging.Logger;

public class ContaBancaria {
    Logger logger = Logger.getLogger(getClass().getName());

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

    private static boolean validatedData(String numberAcc, String agency, String name, String balance){
        return numberAcc != null && agency != null && name != null && balance != null;
    }
    public static void main(String[] args) {
        // Define the variables outside the switch statement
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        String numberAcc = null;
        String agency = null;
        String name = null;
        String balance = null;

        while (running){
            menu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1 -> {
                    numberAcc = getInput(scanner, "Digite o número da sua conta corrente: ");
                }
                case 2 -> { 
                    agency = getInput(scanner, "Digite o número de sua agência: ");
                }
                case 3 -> {
                    name = getInput(scanner, "Digite seu nome completo: ");
                }
                case 4 -> {
                    balance = getInput(scanner, "Digite seu saldo disponível que deseja utilizar: ");
                }
                case 5 -> { 
                    if(validatedData(numberAcc, agency, name, balance)) {
                        System.out.println("----FINALIZANDO CADASTRO---");
                        running = false;
                    } else {
                        System.out.println("Todos os campos devem ser preenchidos antes de finalizar o cadastro.");
                    }
                }
                default -> System.out.println("Wrong option, choose again");
            }
        }

        scanner.close();
    }

        
    
}
