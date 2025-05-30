public class TabelaHash {
    private ABB[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new ABB[tamanho];

        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ABB();
        }
    }

    private int funcaoHash(String palavra) {
        int soma = 0;
        for (char c : palavra.toCharArray()) {
            soma += c;
        }
        return soma % tamanho;
    }

    public void inserirPalavra(String palavra, int linha) {
        int indice = funcaoHash(palavra);
        tabela[indice].inserirPalavra(palavra, linha);
    }

    public Palavra buscarPalavra(String palavra) {
        int indice = funcaoHash(palavra);
        return tabela[indice].buscarPalavra(palavra);
    }
}