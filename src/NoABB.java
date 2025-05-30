public class NoABB {
    private Palavra palavra;
    private NoABB esquerda;
    private NoABB direita;

    public NoABB(Palavra palavra) {
        this.palavra = palavra;
        this.esquerda = null;
        this.direita = null;
    }

    public Palavra getPalavra() { return palavra; }
    public void setPalavra(Palavra palavra) { this.palavra = palavra; }

    public NoABB getEsquerda() { return esquerda; }
    public void setEsquerda(NoABB esquerda) { this.esquerda = esquerda; }

    public NoABB getDireita() { return direita; }
    public void setDireita(NoABB direita) { this.direita = direita; }
}
