import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    int[] indexPerguntas = {1,2,3,4,5,6};
    int escolhaUsuario = 0;
    boolean isRespostaValida = false;

    public void mostrarMenu() {
        while (!isRespostaValida) {
            System.out.println("--- Menu ---");
            System.out.println("""
                    1. Cadastrar um novo pet
                    2. Alterar os dados do pet cadastrado
                    3. Deletar um pet cadastrado
                    4. Listar todos os pets cadastrados
                    5. Listar pets por algum critério (idade, nome, raça)
                    6. Sair
                    --- --- ---""");
            try {
                escolhaUsuario = scanner.nextInt();
                scanner.nextLine();
                boolean opcaoEncontrada = Arrays.stream(indexPerguntas).anyMatch(i -> i == escolhaUsuario);

                if (opcaoEncontrada) {
                    opcao();
                    isRespostaValida = true;
                }else {
                    System.out.println("resposta invalida");
                }
            } catch (InputMismatchException e) {
                System.out.println("resposta invalida");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
    public void opcao() {
        LeitorArquivos leitorArquivos = new LeitorArquivos();
        if (escolhaUsuario == 1) {
            System.out.println("--- Cadastro ---");
            leitorArquivos.lerArquivo();
            System.out.println("--- --- ---");
        }
    }
}