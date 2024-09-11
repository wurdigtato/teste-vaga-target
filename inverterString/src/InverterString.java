import java.util.Scanner;

public class InverterString {

    public static String inverterString(String frase){
        char[] caracteres = new char[frase.length()];

        for (int i = 0; i < frase.length(); i++){
            caracteres[i] = frase.charAt(frase.length() - 1 - i);
        }

        return new String(caracteres);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a frase a ser invertida: ");
        String frase = scanner.nextLine();

        scanner.close();

        String fraseIvertida = inverterString(frase);
        System.out.println("Frase invertida: " + fraseIvertida);
    }
}