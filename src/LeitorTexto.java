import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorTexto {
    public static TabelaHash processarTexto(String nomeArquivo, int tamanhoTabela) {
        TabelaHash tabela = new TabelaHash(tamanhoTabela);
        int numeroLinha = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] palavras = linha.toLowerCase().replaceAll("[^\\p{L}-]", " ").split("\\s+");

                for (String palavra : palavras) {
                    if (!palavra.isEmpty()) {
                        tabela.inserirPalavra(palavra, numeroLinha);
                    }
                }
                numeroLinha++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return tabela;
    }
}