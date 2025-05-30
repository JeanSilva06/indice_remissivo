public class ABB {
    private NoABB raiz;

    public ABB() {
        this.raiz = null;
    }

    // Método para inserir uma palavra na ABB
    public void inserirPalavra(String palavra, int linha) {
        Palavra novaPalavra = new Palavra(palavra);
        novaPalavra.adicionarOcorrencia(linha); // Adiciona a primeira ocorrência
        
        raiz = inserirRecursivo(raiz, novaPalavra);
    }

    private NoABB inserirRecursivo(NoABB no, Palavra palavra) {
        if (no == null) {
            return new NoABB(palavra); // Cria um novo nó na árvore
        }

        int comparacao = palavra.getTexto().compareToIgnoreCase(no.getPalavra().getTexto());
        
        if (comparacao < 0) {
            no.setEsquerda(inserirRecursivo(no.getEsquerda(), palavra)); // Inserir à esquerda
        } else if (comparacao > 0) {
            no.setDireita(inserirRecursivo(no.getDireita(), palavra)); // Inserir à direita
        } else {
            no.getPalavra().adicionarOcorrencia(Integer.parseInt(palavra.getOcorrencias().getHead().getPalavra())); // Palavra já existe, adiciona a nova ocorrência
        }

        return no;
    }

    // Método para buscar uma palavra na ABB
    public Palavra buscarPalavra(String palavra) {
        return buscarRecursivo(raiz, palavra);
    }

    private Palavra buscarRecursivo(NoABB no, String palavra) {
        if (no == null) {
            return null; // Palavra não encontrada
        }

        int comparacao = palavra.compareToIgnoreCase(no.getPalavra().getTexto());

        if (comparacao < 0) {
            return buscarRecursivo(no.getEsquerda(), palavra);
        } else if (comparacao > 0) {
            return buscarRecursivo(no.getDireita(), palavra);
        } else {
            return no.getPalavra(); // Palavra encontrada
        }
    }
}