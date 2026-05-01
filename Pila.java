public class Pila {

    private Nodo cima;

    public Pila() {
        cima = null;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void push(String cliente) {
        Nodo nuevo = new Nodo(cliente);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public String pop() {
        if (estaVacia()) {
            return null;
        }

        String cliente = cima.cliente;
        cima = cima.siguiente;
        return cliente;
    }

    public String peek() {
        if (estaVacia()) {
            return null;
        }
        return cima.cliente;
    }

    public void mostrarHistorial() {
        if (estaVacia()) {
            System.out.println("Historial vacío.");
            return;
        }

        Nodo actual = cima;
        while (actual != null) {
            System.out.println(actual.cliente);
            actual = actual.siguiente;
        }
    }
}