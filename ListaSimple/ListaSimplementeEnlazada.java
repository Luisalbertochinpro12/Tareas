public class ListaSimplementeEnlazada {
    // private Nodo frente;
    private int longitud;
    private Nodo primerNodo;

    public ListaSimplementeEnlazada() {
        primerNodo = null;
        longitud = 0;
    }

    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (primerNodo == null) {
            primerNodo = nuevoNodo;
        } else {
            Nodo nodoActual = primerNodo;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }
        longitud++;
    }

    public int obtener(int indice) {
        if (indice < 0 || indice >= longitud) {
            System.err.println("Indice fuera de rango");
            return -1;
        }

        Nodo actualNodo = primerNodo;

        for (int i = 0; i < indice; i++) {
            actualNodo = actualNodo.getSiguiente();
        }
        return actualNodo.getDato();
    }

    public void longitud() {

    }

    public void eliminar(int indice) {
        if (indice < 0 || indice >= longitud) {
            System.err.println("Indice fuera de rango");
            return;
        }

        if (indice == 0) {
            // Si el indice es 0, el nodo a elminiar es el primer nodo.
            primerNodo = primerNodo.getSiguiente();
        } else {
            // Si el indice no es 0, encontramos el nodo anterior al nodo a elminar
            Nodo nodoAnterior = primerNodo;
            for (int i = 0; i < indice - 1; i++) {
                nodoAnterior = nodoAnterior.getSiguiente();
            }
            Nodo nodoEliminar = nodoAnterior.getSiguiente();
            nodoAnterior.setSiguiente(nodoEliminar.getSiguiente());
        }
        longitud--;
    }

    public boolean estaVacia() {
        return primerNodo == null;
    }

    public Nodo getFrente() {
        if (estaVacia()) {
            // throw new NoSuchElementException();
        }
        return primerNodo;
    }

    public int getLongitud() {
        return longitud;
    }
}