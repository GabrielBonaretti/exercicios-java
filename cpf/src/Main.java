import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
    // Função para calcular os últimos dois digitos de um CPF fornecido.
    public static String caculoCpf(String cpfEntrada) {
        StringBuilder cpfEntradaBuilder = new StringBuilder(cpfEntrada);
        for (int i = 0; i < 2; i++) {
            String[] listaCPF = cpfEntradaBuilder.toString().split("");
            int count = listaCPF.length + 1;
            int soma = 0;

            // Calcula a soma ponderada dos dígitos do CPF.
            for (String numero : listaCPF) {
                int numeroInteiro = Integer.parseInt(numero);
                int multi = numeroInteiro * count;
                soma = soma + multi;
                count--;
            }

            // Calcula o primeiro e o segundo dígito verificador (D1 e D2).
            int numeroD1 = 11 - (soma % 11);

            if (numeroD1 > 9) {
                numeroD1 = 0;
            }

            // Adiciona o dígito verificador calculado ao CPF.
            cpfEntradaBuilder.append(numeroD1);
        }
        cpfEntrada = cpfEntradaBuilder.toString();
        return cpfEntrada;
    }

    // Função para formatar uma string de CPF no formato padrão XXX.XXX.XXX-XX.
    public static String arrumarCPF(String cpfEntrada){
        String[] listaCPF = cpfEntrada.split("");
        StringBuilder cpfPadrao = new StringBuilder();
        int count = 0;
        for (String numero: listaCPF) {
            try {
                Integer.parseInt(numero);
                cpfPadrao.append(numero);
                count ++;

                if (count == 3 || count == 6) {
                    cpfPadrao.append(".");
                } else if (count == 9) {
                    cpfPadrao.append("-");
                }
            }catch (Exception ignored){}

            if (count >= 11){
                break;
            }
        }

        return cpfPadrao.toString();
    }

    // Função para verificar a validade de um CPF fornecido.
    public static boolean verificacaoCpf(String cpfEntrada){
        String verificarCpf9 = cpfEntrada.substring(0,9);
        String cpfCorreto = caculoCpf(verificarCpf9);

        // Verifica se os os ultimos dois digitos calculados correspondem ao CPF fornecido.
        return cpfCorreto.equalsIgnoreCase(cpfEntrada);
    }

    // Função para exibir o menu e retornar a escolha do usuário.
    public static int menu(Scanner sc) {
        while (true) {
            try {
                System.out.println("\n=============================\n");
                System.out.println("Gerenciador de CPF:");
                System.out.println("\n=============================\n");
                System.out.println("1) Gerar CPF");
                System.out.println("2) Verificar CPF");
                System.out.println("3) Sair");
                System.out.print("Escolha uma opção: ");
                return sc.nextInt();
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Escolha uma opção válida");
            }
        }
    }

    // Função para receber um input válido do usuario e gerar um CPF.
    public static void gerarCPF(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite os 9 primeiros digitos para gerar um CPF: ");
                String cpfScanner = sc.nextLine().substring(0,9);
                String cpf = caculoCpf(cpfScanner);
                String cpfArrumado = arrumarCPF(cpf);
                System.out.println("O cpf gerado é: " + cpfArrumado);
                break;
            } catch (Exception e) {
                System.out.println("Erro! Coloque nove numeros para gerar um CPF!");
            }

        }
    }

    // Função para receber um input válido do usuario e validar um CPF.
    public static void verificarCPF(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite apenas os numeros de um cpf para ver se o mesmo é válido: ");
                String cpfInteiroScanner = sc.nextLine().substring(0,11);

                String cpfArrumado2 = arrumarCPF(cpfInteiroScanner);
                boolean cpfBool = verificacaoCpf(cpfInteiroScanner);
                if (cpfBool) {
                    System.out.printf("O cpf %s é válido", cpfArrumado2);
                } else {
                    System.out.printf("O cpf %s não é válido", cpfArrumado2);
                }
                break;
            } catch (Exception e) {
                System.out.println("Erro! Coloque onze numeros para gerar um CPF!");
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continueGame = "S";
        while(continueGame.equals("S")) {
            int choosedOption = menu(sc);
            switch (choosedOption) {
                case 1:
                    sc.nextLine();
                    gerarCPF(sc);
                    break;
                case 2:
                    sc.nextLine();
                    verificarCPF(sc);
                    break;
                case 3:
                    sc.nextLine();
                    continueGame = "N";
                    break;
                default:
                    sc.nextLine();
                    System.out.println("Escolha uma opção válida.");
                    break;
            }

        }




    }
}
