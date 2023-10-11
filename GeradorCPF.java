package aula;

import java.util.Scanner;

public class GeradorCPF {
    public static String caculoCpf(String cpfEntrada) {
        for (int i = 0; i < 2; i++) {
            String[] listaCPF = cpfEntrada.split("");
            int count = listaCPF.length + 1;
            int soma = 0;

            for (String numero : listaCPF) {
                int numeroInteiro = Integer.parseInt(numero);
                int multi = numeroInteiro * count;
                soma = soma + multi;
                count--;
            }
            int numeroD1 = 11 - (soma % 11);

            if (numeroD1 > 9) {
                numeroD1 = 0;
            }

            cpfEntrada = cpfEntrada + numeroD1;
        }
        return cpfEntrada;
    }

    public static String arrumarCPF(String cpfEntrada){
        String[] listaCPF = cpfEntrada.split("");
        String cpfPadrao = "";
        int count = 0;
        for (String numero: listaCPF) {
            try {
                Integer.parseInt(numero);
                cpfPadrao = cpfPadrao + numero;
                count ++;

                if (count == 3 || count == 6) {
                    cpfPadrao = cpfPadrao + ".";
                } else if (count == 9) {
                    cpfPadrao = cpfPadrao + "-";
                }
            }catch (Exception ignored){
            }

            if (count >= 11){
                break;
            }
        }

        return cpfPadrao;
    }

    public static boolean verificacaoCpf(String cpfEntrada){
        String verificarCpf9 = cpfEntrada.substring(0,9);
        String cpfCorreto = caculoCpf(verificarCpf9);
        return cpfCorreto.equalsIgnoreCase(cpfEntrada);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite os 9 primeiros digitos para gerar um CPF: ");
        String cpfScanner = sc.nextLine();

        String cpf = caculoCpf(cpfScanner);
        String cpfArrumado = arrumarCPF(cpf);
        System.out.println(cpfArrumado);

        System.out.println("Digite apenas os numeros de um cpf para ver se o mesmo é válido: ");
        String cpfInteiroScanner = sc.nextLine();

        String cpfArrumado2 = arrumarCPF(cpfInteiroScanner);
        boolean cpfBool = verificacaoCpf(cpfInteiroScanner);
        if (cpfBool) {
            System.out.printf("O cpf %s é válido", cpfArrumado2);
        } else {
            System.out.printf("O cpf %s não é válido", cpfArrumado2);
        }
    }
}
