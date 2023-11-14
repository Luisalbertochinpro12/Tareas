public class Main {
    public static void main(String[] args) {
        // Crear un objeto de la clase Arbol con tipo de datos String y configurarlo
        // como no binario
        Arbol<String> arbol = new Arbol<>("A", false);

        // Crear nodos para el árbol
        NodoArbol<String> nodoRaiz = arbol.obtenerRaiz();
        NodoArbol<String> nodoHijo0 = new NodoArbol<>("B");
        NodoArbol<String> nodoHijo1 = new NodoArbol<>("C");
        NodoArbol<String> nodoHijo2 = new NodoArbol<>("D");
        NodoArbol<String> nodoHijo3 = new NodoArbol<>("E");
        NodoArbol<String> nodoHijo4 = new NodoArbol<>("F");
        NodoArbol<String> nodoHijo5 = new NodoArbol<>("G");
        NodoArbol<String> nodoHijo6 = new NodoArbol<>("H");
        NodoArbol<String> nodoHijo7 = new NodoArbol<>("I");
        NodoArbol<String> nodoHijo8 = new NodoArbol<>("J");
        NodoArbol<String> nodoHijo9 = new NodoArbol<>("K");
        NodoArbol<String> nodoHijo10 = new NodoArbol<>("L");
        NodoArbol<String> nodoHijo11 = new NodoArbol<>("M");
        NodoArbol<String> nodoHijo12 = new NodoArbol<>("N");
        NodoArbol<String> nodoHijo13 = new NodoArbol<>("O");
        NodoArbol<String> nodoHijo14 = new NodoArbol<>("P");
        NodoArbol<String> nodoHijo15 = new NodoArbol<>("Q");

        // Nodo A y su descendencia
        arbol.agregarNodoArbol(nodoRaiz, nodoHijo0);
        arbol.agregarNodoArbol(nodoRaiz, nodoHijo1);
        arbol.agregarNodoArbol(nodoRaiz, nodoHijo2);
        // Nodo B y su descendencia
        arbol.agregarNodoArbol(nodoHijo0, nodoHijo3);
        arbol.agregarNodoArbol(nodoHijo0, nodoHijo4);
        // Nodo F y su descendencia
        arbol.agregarNodoArbol(nodoHijo4, nodoHijo8);
        arbol.agregarNodoArbol(nodoHijo4, nodoHijo9);
        arbol.agregarNodoArbol(nodoHijo4, nodoHijo10);
        // Nodo D y su descendencia
        arbol.agregarNodoArbol(nodoHijo2, nodoHijo5);
        arbol.agregarNodoArbol(nodoHijo2, nodoHijo6);
        arbol.agregarNodoArbol(nodoHijo2, nodoHijo7);
        // Nodo G y su descendencia
        arbol.agregarNodoArbol(nodoHijo5, nodoHijo11);
        // Nodo I y su descendencia
        arbol.agregarNodoArbol(nodoHijo7, nodoHijo12);
        arbol.agregarNodoArbol(nodoHijo7, nodoHijo13);
        // Nodo M y su descendencia
        arbol.agregarNodoArbol(nodoHijo11, nodoHijo14);
        arbol.agregarNodoArbol(nodoHijo11, nodoHijo15);

        // Imprimir el árbol en diferentes recorridos
        System.out.println("Árbol Ordinario:");

        System.out.println();
        arbol.imprimirArbol(Recorrido.PREFIJO);

        System.out.println();
        arbol.imprimirArbol(Recorrido.INFIJO);

        System.out.println();
        arbol.imprimirArbol(Recorrido.POSFIJO);

        System.out.println();
        System.out.println("Altura del árbol: " + arbol.obtenerAltura());

        System.out.println("Subarbol F ");
        arbol.imprimirSubArbol(nodoHijo4);
        System.out.println();

        // Verificar si el árbol está vacío
        System.out.println("¿El árbol está vacío?");
        if (arbol.estaVacio()) {
            System.out.println("Si");
        } else {
            System.out.println("No");
        }

        String raiz = nodoRaiz.getDato();
        System.out.println("Raíz del árbol: " + raiz);

        System.out.println("Árbol Binario:");
        // Crear un objeto de la clase Arbol con tipo de datos String y configurarlo
        // como binario
        Arbol<String> arbolBinario = new Arbol<String>("A", true);

        NodoArbol<String> raizBinaria = arbolBinario.obtenerRaiz();
        NodoArbol<String> nodoBinarioB = new NodoArbol<>("B");
        NodoArbol<String> nodoBinarioC = new NodoArbol<>("C");
        NodoArbol<String> nodoBinarioD = new NodoArbol<>("D");
        NodoArbol<String> nodoBinarioE = new NodoArbol<>("E");
        NodoArbol<String> nodoBinarioF = new NodoArbol<>("F");
        NodoArbol<String> nodoBinarioG = new NodoArbol<>("G");
        NodoArbol<String> nodoBinarioH = new NodoArbol<>("H");
        NodoArbol<String> nodoBinarioI = new NodoArbol<>("I");
        NodoArbol<String> nodoBinarioJ = new NodoArbol<>("J");
        NodoArbol<String> nodoBinarioK = new NodoArbol<>("K");
        NodoArbol<String> nodoBinarioL = new NodoArbol<>("L");
        NodoArbol<String> nodoBinarioM = new NodoArbol<>("M");
        NodoArbol<String> nodoBinarioN = new NodoArbol<>("N");
        NodoArbol<String> nodoBinarioO = new NodoArbol<>("O");
        NodoArbol<String> nodoBinarioP = new NodoArbol<>("P");
        NodoArbol<String> nodoBinarioQ = new NodoArbol<>("Q");

        arbolBinario.agregarNodoArbol(raizBinaria, nodoBinarioB);
        arbolBinario.agregarNodoArbol(nodoBinarioB, nodoBinarioE);
        arbolBinario.agregarNodoArbol(nodoBinarioB, nodoBinarioC);
        arbolBinario.agregarNodoArbol(nodoBinarioE, nodoBinarioF);
        arbolBinario.agregarNodoArbol(nodoBinarioF, nodoBinarioJ);
        arbolBinario.agregarNodoArbol(nodoBinarioJ, nodoBinarioK);
        arbolBinario.agregarNodoArbol(nodoBinarioK, nodoBinarioL);
        arbolBinario.agregarNodoArbol(nodoBinarioC, nodoBinarioD);
        arbolBinario.agregarNodoArbol(nodoBinarioD, nodoBinarioG);
        arbolBinario.agregarNodoArbol(nodoBinarioG, nodoBinarioM);
        arbolBinario.agregarNodoArbol(nodoBinarioG, nodoBinarioH);
        arbolBinario.agregarNodoArbol(nodoBinarioM, nodoBinarioP);
        arbolBinario.agregarNodoArbol(nodoBinarioP, nodoBinarioQ);
        arbolBinario.agregarNodoArbol(nodoBinarioH, nodoBinarioI);
        arbolBinario.agregarNodoArbol(nodoBinarioI, nodoBinarioN);
        arbolBinario.agregarNodoArbol(nodoBinarioN, nodoBinarioO);

        System.out.println();
        arbolBinario.imprimirArbol(Recorrido.PREFIJO);

        System.out.println();
        arbolBinario.imprimirArbol(Recorrido.INFIJO);

        System.out.println();
        arbolBinario.imprimirArbol(Recorrido.POSFIJO);

        System.out.println();

        System.out.println("Altura del arbol binario: " + arbolBinario.obtenerAltura());
        String nombreDelNodo = nodoBinarioE.getDato();
        System.out.println("Subarbol " + nombreDelNodo);

        String raizArbolBinario = raizBinaria.getDato();
        System.out.println("Raíz del arbol binario " + raizArbolBinario);

        arbolBinario.imprimirSubArbol(nodoBinarioJ);
    }
}
