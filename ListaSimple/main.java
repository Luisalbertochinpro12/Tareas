public class main {

    public static void main(String[] args) {
        System.out.println("Lista simplemente enlazada");
        ListaSimplementeEnlazada lista = new ListaSimplementeEnlazada();

        lista.insertar(5);
        lista.insertar(59);
        lista.insertar(91);
        lista.insertar(-17);
        lista.insertar(73);
        lista.insertar(34);
        lista.insertar(40);

        lista.eliminar(2);
        lista.eliminar(3);

        System.out.println("Indice 3 es: " + lista.obtener(3));
    }
}