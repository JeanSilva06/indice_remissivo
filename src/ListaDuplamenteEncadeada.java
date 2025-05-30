import java.util.NoSuchElementException;

public class ListaDuplamenteEncadeada {

    private No head;
    private No tail;
    private int numeroElementos;

    public ListaDuplamenteEncadeada() {
        this.head = null;
        this.tail = null;
        this.numeroElementos = 0;
    }

    public boolean estaVazia() {
        return head == null;
    }

    public void insereInicio(String palavra) {
        No novoNo = new No(palavra);
        if (estaVazia()) {
            head = tail = novoNo;
        } else {
            novoNo.setProximo(head);
            head.setAnterior(novoNo);
            head = novoNo;
        }
        numeroElementos++;
    }

    public void insereFinal(String palavra) {
        No novoNo = new No(palavra);

        if (estaVazia()) {
            head = novoNo;
            tail = novoNo;
        } else {
            tail.setProximo(novoNo);
            novoNo.setAnterior(tail);
            tail = novoNo;
        }
        numeroElementos++;
    }

    public void inserirNaPosicao(int posicao, String palavra) {
        if (posicao < 0 || posicao > numeroElementos) {
            throw new IndexOutOfBoundsException("Posição inválida, tente novamente");
        }

        No novoNo = new No(palavra);

        if (posicao == 0) {
            insereInicio(palavra);
            return;
        } else if (posicao == numeroElementos) {
            insereFinal(palavra);
            return;
        }

        No atual = head;
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.getProximo();
        }

        novoNo.setProximo(atual.getProximo());
        novoNo.setAnterior(atual);

        if (atual.getProximo() != null) {
            atual.getProximo().setAnterior(novoNo);
        }
        atual.setProximo(novoNo);

        numeroElementos++;
    }

    public void removeInicio() {
        if (estaVazia()) {
            throw new NoSuchElementException("A lista está vazia");
        } else {
            head = head.getProximo();
            if (head != null) {
                head.setAnterior(null);
            } else {
                tail = null;
            }
            numeroElementos--;
        }
    }

    public void removeFinal() {
        if (estaVazia()) {
            throw new NoSuchElementException("A lista está vazia");
        } else if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.getAnterior();
            if (tail != null) {
                tail.setProximo(null);
            } else {
                head = null;
            }
        }
        numeroElementos--;
    }

    public void insereOrdenado(String palavra) {
        No novoNo = new No(palavra);

        if (estaVazia()) {
            head = novoNo;
            numeroElementos++;
            return;
        }

        No atual = head;
        No anterior = null;

        while (atual != null && atual.getPalavra().compareToIgnoreCase(palavra) < 0) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (anterior == null) {
            novoNo.setProximo(head);
            head.setAnterior(novoNo);
            head = novoNo;
        } else {
            novoNo.setProximo(atual);
            novoNo.setAnterior(anterior);
            anterior.setProximo(novoNo);

            if (atual != null) {
                atual.setAnterior(novoNo);
            } else {
                tail = novoNo;
            }
        }
        numeroElementos++;
    }

    public void imprime() {
        No atual = head;
        while (atual != null) {
            System.out.print(atual.getPalavra());
            if (atual.getProximo() != null) {
                System.out.print(" <--> ");
            }
            atual = atual.getProximo();
        }
        System.out.println();
    }

    public void imprimeReverso() {
        No atual = tail;
        while (atual != null) {
            System.out.print(atual.getPalavra());
            if (atual.getAnterior() != null) {
                System.out.print(" <--> ");
            }
            atual = atual.getAnterior();
        }
        System.out.println();
    }

    public boolean buscar(String palavra) {
        No atual = head;
        while (atual != null) {
            if (atual.getPalavra().equalsIgnoreCase(palavra)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    public No getHead() { return head; }

    public No getTail() { return tail; }

    public int getNumeroElementos() { return numeroElementos; }

    public static void main(String[] args) throws Exception {

    }
}
