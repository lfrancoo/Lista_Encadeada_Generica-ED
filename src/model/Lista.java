package model;

public class Lista<T> {
    private No<T> primeiro;
    private int tamanho;

    public Lista() {
        primeiro = null;
        tamanho = 0;
    }

    public boolean isEmpty() {
        return primeiro == null;
    }

    public int size() {
        return tamanho;
    }

    public void clean() {
        primeiro = null;
        tamanho = 0;
    }

    private No<T> getNo(int pos) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        if (pos < 0 || pos >= tamanho) {
            throw new Exception("Posição Inválida");
        }

        No<T> auxiliar = primeiro;
        for (int i = 0; i < pos; i++) {
            auxiliar = auxiliar.proximo;
        }
        return auxiliar;
    }

    public void addFirst(T valor) {
        No<T> elemento = new No<>(valor);
        elemento.proximo = primeiro;
        primeiro = elemento;
        tamanho++;
    }

    public void addLast(T valor) throws Exception {
        if (isEmpty()) {
            addFirst(valor);
            return;
        }
        No<T> elemento = new No<>(valor);
        No<T> ultimo = getNo(tamanho - 1);
        ultimo.proximo = elemento;
        tamanho++;
    }

    public void add(T valor, int posicao) throws Exception {
        if (posicao < 0 || posicao > tamanho) {
            throw new Exception("Posição inválida");
        }
        if (posicao == 0) {
            addFirst(valor);
        } else if (posicao == tamanho) {
            addLast(valor);
        } else {
            No<T> elemento = new No<>(valor);
            No<T> anterior = getNo(posicao - 1);
            elemento.proximo = anterior.proximo;
            anterior.proximo = elemento;
            tamanho++;
        }
    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        primeiro = primeiro.proximo;
        tamanho--;
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        if (tamanho == 1) {
            primeiro = null;
            tamanho = 0;
        } else {
            No<T> penultimo = getNo(tamanho - 2);
            penultimo.proximo = null;
            tamanho--;
        }
    }

    public void remove(int pos) throws Exception {
        if (pos < 0 || pos >= tamanho) {
            throw new Exception("Posição inválida");
        }
        if (pos == 0) {
            removeFirst();
        } else if (pos == tamanho - 1) {
            removeLast();
        } else {
            No<T> anterior = getNo(pos - 1);
            No<T> atual = anterior.proximo;
            anterior.proximo = atual.proximo;
            tamanho--;
        }
    }

    public T get(int pos) throws Exception {
        return getNo(pos).dado;
    }

    /**
     * 🔥 MÉTODO imprimir() - Imprime conteúdo da lista no console
     */
    public void imprimir() {
        if (isEmpty()) {
            System.out.print("[]");
            return;
        }

        System.out.print("[");
        No<T> atual = primeiro;
        while (atual != null) {
            System.out.print(atual.dado);
            if (atual.proximo != null) {
                System.out.print(", ");
            }
            atual = atual.proximo;
        }
        System.out.print("]");
    }
}