import java.io.*;

public class LeitorArquivos {
    public void lerArquivo() {
        File file = new File("src/formulario.txt");
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("IO exeption");
        }
    }
}