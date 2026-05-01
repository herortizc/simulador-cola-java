public class Cola {

    private Nodo frente;
    private Nodo finalCola;

    public Cola() {
        frente = null;
        finalCola = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(String cliente) {
        Nodo nuevo = new Nodo(cliente);

        if (estaVacia()) {
            frente = nuevo;
            finalCola = nuevo;
        } else {
            finalCola.siguiente = nuevo;
            finalCola = nuevo;
        }
    }

    public String desencolar() {
        if (estaVacia()) {
            return null;
        }

        String cliente = frente.cliente;
        frente = frente.siguiente;

        if (frente == null) {
            finalCola = null;
        }

        return cliente;
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }

        Nodo actual = frente;
        while (actual != null) {
            System.out.println(actual.cliente);
            actual = actual.siguiente;
        }
    }
}