/**
 * Clase NodoArbol
 */
public class NodoArbol<T> {
  private T dato;
  private boolean esBinario = false;
  private NodoArbol<T> primerHijo;
  private NodoArbol<T> siguienteHermano;

  /**
   * Constructor de nuestra clase NodoArbol, donde definimos que nuestra variable
   * primerHijo y siguienteHermano son nulos, o sea que no tienen hijos ni
   * hermanos
   * 
   * @param dato
   */
  public NodoArbol(T dato) {
    this.dato = dato;
    primerHijo = null;
    siguienteHermano = null;
  }

  /**
   * Metodo para agregar un hijo a nuestro nodo actual.
   * 
   * Logica del método: Si nuestro arbol no tiene ningún nodo "Primer Hijo" se le
   * asigna al nodo actual el valor de hijo
   * en caso de haber un hijo, a ese Nuevo "Primer hijo", se le asigna el valor de
   * hermano de nuestro nodo primer hijo
   * original.
   * 
   * Ahora se evalua la variable "esBinario", al ser booleana, solo tiene dos
   * estados (True o False), para el caso de que
   * sea True, verifica si el primer hijo ya tiene un hermano, de ser así, arroja
   * el mensaje de error para decir que no
   * se puede seguir agregando más, de no ser así agrega un hermano al nodo.
   * 
   * @param hijo
   */
  public void agregarHijo(NodoArbol<T> hijo) {
    if (primerHijo == null) {
      primerHijo = hijo;
    } else {
      NodoArbol<T> hermano = this.primerHijo;

      if (esBinario) {
        if (hermano.siguienteHermano != null) {
          System.err.println("El nodo ya tiene un hijo, no se debe agregar " + hijo.getDato());
        } else {
          hermano.siguienteHermano = hijo;
        }
      } else {
        while (hermano.siguienteHermano != null) {
          hermano = hermano.siguienteHermano;
        }
        hermano.siguienteHermano = hijo;
      }
    }
  }

  /**
   * Metodo para obtejer el valor del nuestro nodo actual "Primer hijo"
   * 
   * @return : primerHijo
   */
  public NodoArbol<T> obtenerPrimerHijo() {
    return primerHijo;
  }

  /**
   * Metodo para obtener el siguiente hermano de nuestro nodo "Hijo" actual
   * 
   * @return : siguienteHermano
   */
  public NodoArbol<T> obtenerSiguienteHermano() {
    return siguienteHermano;
  }

  /**
   * Metodo para obtener el dato de nuestro nodo
   * 
   * @return : dato
   */
  public T getDato() {
    return dato;
  }

  /**
   * Metodo para saber si es binario o no
   * 
   * @return : esBinario
   */
  public boolean esBinario() {
    return esBinario;
  }

  /**
   * Metodo para hacer que nuestro arbol sea binario
   * 
   * @param esBinario
   */
  public void setEsBinario(boolean esBinario) {
    this.esBinario = esBinario;
  }

  /**
   * Impresión en recorrido Prefijo
   */
  public void imprimirEnPrefijo() {
    System.out.print(dato + "\t");
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPrefijo();
      hijo = hijo.siguienteHermano;
    }
  }

  /**
   * Impresión en recorrido Infijo
   */
  public void imprimirEnInfijo() {
    NodoArbol<T> hijo = primerHijo;

    if (hijo != null) {
      hijo.imprimirEnInfijo();
    }

    System.out.print(dato + "\t");
    while (hijo != null) {
      hijo = hijo.siguienteHermano;
      if (hijo != null) {
        hijo.imprimirEnInfijo();
      }
    }
  }

  /**
   * Impresión en Posfijo
   */
  public void imprimirEnPosfijo() {
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPosfijo();
      hijo = hijo.siguienteHermano;
    }

    System.out.print(dato + "\t");
  }
}
