package model;

public class Lista<T> {

    No<T> primeiro;

    public Lista() {
        primeiro = null;
    }

    public boolean isEmpty() {
        return primeiro == null;
    }

    public int size() {
        int cont = 0;
        No<T> auxiliar = primeiro;

        while (auxiliar != null) {
            cont++;
            auxiliar = auxiliar.proximo;
        }

        return cont;
    }

    private No<T> getNo(int pos) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }

        int tamanho = size();

        if (pos < 0 || pos >= tamanho) {
            throw new Exception("Posição Inválida");
        }

        No<T> auxiliar = primeiro;
        int cont = 0;

        while (cont < pos) {
            auxiliar = auxiliar.proximo;
            cont++;
        }

        return auxiliar;
    }

    public void addFirst(T valor) {
        No<T> elemento = new No<>(valor);
        elemento.proximo = primeiro;
        primeiro = elemento;
    }

    public void addLast(T valor) throws Exception {
        if (isEmpty()) {
            addFirst(valor);
            return;
        }

        No<T> elemento = new No<>(valor);

        No<T> ultimo = getNo(size() - 1);
        ultimo.proximo = elemento;
    }

    public void add(T valor, int posicao) throws Exception {

        int tamanho = size();

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
        }
    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }

        primeiro = primeiro.proximo;
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }

        int tamanho = size();

        if (tamanho == 1) {
            removeFirst();
        } else {
            No<T> penultimo = getNo(tamanho - 2);
            penultimo.proximo = null;
        }
    }

    public void remove(int pos) throws Exception {

        int tamanho = size();

        if (pos < 0 || pos >= tamanho) {
            throw new Exception("Posição inválida");
        }

        if (pos == 0) {
            removeFirst();
        } else if (pos == tamanho - 1) {
            removeLast();
        } else {
            No<T> anterior = getNo(pos - 1);
            No<T> atual = getNo(pos);

            anterior.proximo = atual.proximo;
        }
    }

    public T get(int pos) throws Exception {

        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }

        int tamanho = size();

        if (pos < 0 || pos >= tamanho) {
            throw new Exception("Posição inválida");
        }

        return getNo(pos).dado;
    }
}
