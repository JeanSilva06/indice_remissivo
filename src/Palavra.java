public class Palavra {
    private String texto;
    private ListaDuplamenteEncadeada ocorrencias;

    public Palavra(String texto) {
        this.texto = texto;
        this.ocorrencias = new ListaDuplamenteEncadeada();
    }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public ListaDuplamenteEncadeada getOcorrencias() { return ocorrencias; }

    public void adicionarOcorrencia(int linha) {
        ocorrencias.insereOrdenado(String.valueOf(linha));
    }
}
