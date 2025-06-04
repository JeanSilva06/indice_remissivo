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
                        String normalizada = palavraSingular(palavra.toLowerCase());
                        tabela.inserirPalavra(normalizada, numeroLinha);
                    }
                }
                numeroLinha++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return tabela;
    }

    private static String palavraSingular(String palavra) {
        if (palavra.endsWith("ões")) {
            return palavra.substring(0, palavra.length() - 3) + "ão";
        }
        if (palavra.endsWith("ães")) {
            return palavra.substring(0, palavra.length() - 3) + "ão";
        }
        if (palavra.endsWith("s") && palavra.length() > 3) {
            return palavra.substring(0, palavra.length() - 1);
        }
        return palavra;
    }
}