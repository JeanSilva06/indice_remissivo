import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorIndiceRemissivo {
    public static void gerarIndice(String nomeTexto, String nomePalavras, String nomeSaida, int tamanhoTabela) {
        TabelaHash tabela = LeitorTexto.processarTexto(nomeTexto, tamanhoTabela);
        ListaDuplamenteEncadeada palavrasChave = LeitorPalavrasChave.lerPalavras(nomePalavras);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeSaida))) {
            writer.write("Índice Remissivo:\n");
            writer.write("\n");

            No atual = palavrasChave.getHead();
            while (atual != null) {
                String palavra = atual.getPalavra();
                Palavra resultado = tabela.buscarPalavra(palavra);
                
                if (resultado != null) {
                    writer.write(palavra + " ");

                    No ocorrencia = resultado.getOcorrencias().getHead();
                    while (ocorrencia != null) {
                        writer.write(ocorrencia.getPalavra() + " ");
                        ocorrencia = ocorrencia.getProximo();
                    }
                    writer.write("\n");
                }
                atual = atual.getProximo();
            }

            System.out.println("Arquivo '" + nomeSaida + "' gerado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}