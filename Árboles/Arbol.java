/**
 * CLase Arbol
 */
public class Arbol<T> {
  private NodoArbol<T> raiz;
  private boolean esBinario = false;
  boolean estaVacio = false;

  /**
   * Constructor de la clase arbol, donde definimos nuestra raíz y revisamos si es
   * binario
   * 
   * @param dato
   * @param esBinario
   */
  public Arbol(T dato, boolean esBinario) {
    raiz = new NodoArbol<T>(dato);
    raiz.setEsBinario(esBinario);
    this.esBinario = esBinario;
  }

  /**
   * Metodo para obtener la raíz de nuestro arbol
   * 
   * @return : raiz
   */
  public NodoArbol<T> obtenerRaiz() {
    return raiz;
  }

  public boolean esBinario() {
    return esBinario;
  }

  /**
   * Con este método podemos agregar un nodo a nuestro arbol
   * 
   * @param nodoRaiz     : raiz
   * @param nodoAgregado : agregarHijo
   */
  public void agregarNodoArbol(NodoArbol<T> nodoRaiz, NodoArbol<T> nodoAgregado) {
    if (esBinario) {
      nodoAgregado.setEsBinario(esBinario);
    }

    nodoRaiz.agregarHijo(nodoAgregado);
  }

  /**
   * Método para imprimir nuestro arbol dependiendo del recorrido deseado
   * 
   * @param recorrido
   */
  public void imprimirArbol(Recorrido recorrido) {
    switch (recorrido.ordinal()) {
      case 0:

        // Impresión en recorrido Prefijo
        System.out.println("Prefijo: ");
        raiz.imprimirEnPrefijo();
        break;

      // Impresión en recorrido Infijo
      case 1:
        System.out.println("\nInfijo: ");
        raiz.imprimirEnInfijo();
        break;

      // Impresión en recorrido Posfijo
      case 2:
        System.out.println("\nPosfijo: ");
        raiz.imprimirEnPosfijo();
        break;

      default:
        break;
    }
  }

  /**
   * Metodo para saber si el arbol esta vacio
   * 
   * @return estaVacio
   */
  public boolean estaVacio() {
    return estaVacio;
  }

  public void imprimirSubArbol(NodoArbol<T> nodoSubArbol) {
    System.out.println("Impresión en Prefijo: ");
    nodoSubArbol.imprimirEnPrefijo();
    System.out.println();

    System.out.println("Impresión en Infijo: ");
    nodoSubArbol.imprimirEnInfijo();
    System.out.println();

    System.out.println("Impresión en Posfijo");
    nodoSubArbol.imprimirEnPosfijo();

  }

  /**
   * Calcula la altura del árbol de manera recursiva.
   *
   * @return La altura del árbol.
   */
  public int obtenerAltura() {
    return obtenerAlturaRecursivo(raiz);
  }

  private int obtenerAlturaRecursivo(NodoArbol<T> nodo) {
    if (nodo == null) {
      return 0;
    } else {
      int alturaMaxima = 0;

      // Considerar el primer hijo
      NodoArbol<T> primerHijo = nodo.obtenerPrimerHijo();
      while (primerHijo != null) {
        int alturaPrimerHijo = obtenerAlturaRecursivo(primerHijo);
        alturaMaxima = Math.max(alturaMaxima, alturaPrimerHijo);
        primerHijo = primerHijo.obtenerSiguienteHermano();
      }

      // Devolver la altura máxima más 1 (por el nodo actual)
      return alturaMaxima + 1;
    }
  }
}