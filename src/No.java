public class No {

    private String palavra;
    private No proximo;
    private No anterior;

    public No(String palavra) {
        this.palavra = palavra;
        this.proximo = null;
        this.anterior = null;
    }

    public String getPalavra() { return palavra; }
    public void setPalavra(String palavra) { this.palavra = palavra; }

    public No getProximo() { return proximo; }
    public void setProximo(No proximo) { this.proximo = proximo; }

    public No getAnterior() { return anterior; }
    public void setAnterior(No anterior) { this.anterior = anterior; }
}
