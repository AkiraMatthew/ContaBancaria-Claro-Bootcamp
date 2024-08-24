package utils;
import java.util.Scanner;

public class InputUtils {
    // Private constructor to prevent instantiation
    private InputUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }


    public static String getInput(Scanner scanner, String prompt){
        System.out.println(prompt);
        var input = scanner.nextLine();

        System.out.println("Informaçao salva com sucesso: " + input + "!");

        return input;
    }
    

    public static void providedData(Object data){
        System.out.println("Os dados fornecidos precisam ser do tipo " + data);
    }
}
