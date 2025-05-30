import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorPalavrasChave {
    public static ListaDuplamenteEncadeada lerPalavras(String nomeArquivo) {
        ListaDuplamenteEncadeada palavras = new ListaDuplamenteEncadeada();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                palavras.insereOrdenado(linha.trim());
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return palavras;
    }
}
