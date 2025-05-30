public class ABB {
    private NoABB raiz;

    public ABB() {
        this.raiz = null;
    }

    public void inserirPalavra(String palavra, int linha) {
        Palavra novaPalavra = new Palavra(palavra);
        novaPalavra.adicionarOcorrencia(linha);
        
        raiz = inserirRecursivo(raiz, novaPalavra);
    }

    private NoABB inserirRecursivo(NoABB no, Palavra palavra) {
        if (no == null) {
            return new NoABB(palavra);
        }

        int comparacao = palavra.getTexto().compareToIgnoreCase(no.getPalavra().getTexto());
        
        if (comparacao < 0) {
            no.setEsquerda(inserirRecursivo(no.getEsquerda(), palavra));
        } else if (comparacao > 0) {
            no.setDireita(inserirRecursivo(no.getDireita(), palavra));
        } else {
            no.getPalavra().adicionarOcorrencia(Integer.parseInt(palavra.getOcorrencias().getHead().getPalavra()));
        }

        return no;
    }

    public Palavra buscarPalavra(String palavra) {
        return buscarRecursivo(raiz, palavra);
    }

    private Palavra buscarRecursivo(NoABB no, String palavra) {
        if (no == null) {
            return null;
        }

        int comparacao = palavra.compareToIgnoreCase(no.getPalavra().getTexto());

        if (comparacao < 0) {
            return buscarRecursivo(no.getEsquerda(), palavra);
        } else if (comparacao > 0) {
            return buscarRecursivo(no.getDireita(), palavra);
        } else {
            return no.getPalavra();
        }
    }
}
