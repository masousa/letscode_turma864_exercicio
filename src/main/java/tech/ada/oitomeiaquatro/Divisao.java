package tech.ada.oitomeiaquatro;

import java.util.Scanner;

public class Divisao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            dividir(scanner);
            System.out.println(" Divisão realizada com sucesso");
        }catch (ArithmeticException arithmeticException){
            System.out.println("Tente novamente");

        }finally {
            System.out.println("Sempre executarei");
        }

    }

    private static void dividir(Scanner scanner) throws ArithmeticException{

        System.out.println("Informe um numero");
        int numero = scanner.nextInt();;
        System.out.println("Informe outro numero");
        int numero2 = scanner.nextInt();

        final int x = numero / numero2;

        System.out.printf("O resultado "+x);
    }
}
