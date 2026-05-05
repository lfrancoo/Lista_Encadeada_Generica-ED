package model;

public class TesteLista {
    public static void main(String[] args) {
        Lista<String> lista = new Lista<>();

        // Adiciona elementos
        lista.addFirst("A");
        try {
            lista.addLast("B");
            lista.add("C", 1);
            lista.add("D", 2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.print("Antes do clean(): ");
        lista.imprimir();  // ✅ [A, C, D, B]
        System.out.println();
        System.out.println("Tamanho: " + lista.size());   // 4

        // 🧹 APLICA CLEAN
        lista.clean();

        System.out.print("Depois do clean(): ");
        lista.imprimir();  // ✅ []
        System.out.println();
        System.out.println("Tamanho: " + lista.size());    // 0
        System.out.println("Está vazia? " + lista.isEmpty()); // true
    }
}