import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pet {
    Scanner scanner = new Scanner(System.in);
    private static final String campoVazio = "NÂO INFORMADO";
    boolean opcaoValida = false;
    String nome;
    TipoPet tipo;
    SexoPet sexo;
    String numero_casa;
    String cidade;
    String rua;
    String idade;
    String peso;
    String raça;

    public void cadastrarPet () {
        while (!opcaoValida) {
            try {
                System.out.println("Nome e sobrenome:");
                setNome(scanner.nextLine());

                System.out.println("Tipo (digite 1 para cachorro, 2 para gato): ");
                int tipoDigitado = scanner.nextInt();
                scanner.nextLine();
                setTipo(tipoDigitado);

                System.out.println("Sexo (digite 1 para macho, 2 para fêmea)");
                int sexoDigitado = scanner.nextInt();
                scanner.nextLine();
                setSexo(sexoDigitado);

                System.out.println("Endereço (Número, Cidade, Rua): ");
                setEndereço(scanner.nextLine());

                System.out.println("Idade aproximada do pet: ");
                setIdade(scanner.nextLine());

                System.out.println("Peso aproximado do pet: ");
                setPeso(scanner.nextLine());

                System.out.println("Raça: ");
                setRaça(scanner.nextLine());

                opcaoValida = true;

            } catch (IllegalArgumentException e) {
                System.err.println("Erro ao cadastrar pet: " + e.getMessage());


            } catch (InputMismatchException e) {
                System.err.println("Erro: Entrada inválida. Digite um número valido.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public void setNome(String nome) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+\\s+[a-zA-Z\\s]+$");
        Matcher matcher = pattern.matcher(nome);

        if (matcher.matches()) {
            this.nome = nome;
        } else if (nome.isEmpty()) {
            this.nome = campoVazio;
        }else {
            throw new IllegalArgumentException("Nome invalido.");
        }
    }

    public void setTipo(int tipoDigitado) throws IllegalArgumentException{
        if (tipoDigitado == TipoPet.CACHORRO.valor) {
            this.tipo = TipoPet.CACHORRO;
        } else if (tipoDigitado == TipoPet.GATO.valor) {
            this.tipo = TipoPet.GATO;
        } else {
            throw new IllegalArgumentException("Opcão de tipo invalida.");
        }
    }

    public void setSexo(int sexoDigitado) throws IllegalArgumentException{
        if (sexoDigitado == SexoPet.MACHO.valor) {
            this.sexo = SexoPet.MACHO;
        } else if (sexoDigitado == SexoPet.FEMEA.valor) {
            this.sexo = SexoPet.FEMEA;
        } else {
            throw new IllegalArgumentException("Opcão de sexo invalida.");
        }
    }

    public void setEndereço(String endereço) throws IllegalArgumentException{
        if (endereço.split(",").length == 2) {
            this.numero_casa = campoVazio;
            this.cidade = endereço.split(",")[0].strip();
            this.rua = endereço.split(",")[1].strip();

        } else if (endereço.split(",").length == 3) {
            this.numero_casa = endereço.split(",")[0];
            this.cidade = endereço.split(",")[1].strip();
            this.rua = endereço.split(",")[2].strip();
        }else {
            throw new IllegalArgumentException("Digite um endereço valido");
        }
    }

    public void setIdade(String idade) {
        try {
            if (idade.isEmpty()) {
                this.idade = campoVazio;
            }else {
                idade = idade.replace(",", ".");
                float parsedIdade;
                parsedIdade = Float.parseFloat(idade);
                if (parsedIdade > 20) {
                    throw new IllegalArgumentException("Idade não pode ser maior que 20");
                }
                this.idade = Float.toString(parsedIdade);
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("Digite um numero");
        }
    }

    public void setPeso(String peso) {
        try {
            if (peso.isEmpty()) {
                this.peso = campoVazio;
            }else {
                peso = peso.replace(",", ".");
                float parsedPeso = Float.parseFloat(peso);
                if (parsedPeso < 0.5) {
                    throw new IllegalArgumentException("Peso não pode ser menor que 0,5 kg");
                }
                if (parsedPeso > 60) {
                    throw new IllegalArgumentException("Peso não pode ser maior que 60 kg");
                }
                this.peso = Float.toString(parsedPeso);
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("Digite um numero");
        }
    }

    public void setRaça(String raça) {
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$");
        Matcher matcher = pattern.matcher(raça);

        if (matcher.matches()) {
            this.raça = raça;
        } else if (raça.isEmpty()) {
            this.raça = campoVazio;
        }else {
            throw new IllegalArgumentException("raça invalido.");
        }
    }
}
