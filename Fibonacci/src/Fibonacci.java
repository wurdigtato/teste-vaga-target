//1) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores
// (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci
// e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
//
//IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código;

import java.util.Scanner;

public class Fibonacci {

    public static boolean isFibonacci(int num) {
        if (num < 0) {
            return false;
        }

        int num1 = 0, num2 = 1;

        if (num == num1 || num == num2) {
            return true;
        }

        int sum = num1 + num2;
        while (sum <= num){
            if (sum == num) {
                return true;
            }
            num1 = num2;
            num2 = sum;
            sum = num1 + num2;
        }

        return false;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe um número: ");
        int num = scanner.nextInt();

        isFibonacci(num);

        if(isFibonacci(num)) {
            System.out.println("O número " + num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + num + " não pertence à sequência de Fibonacci");
        }
        scanner.close();
    }

}
