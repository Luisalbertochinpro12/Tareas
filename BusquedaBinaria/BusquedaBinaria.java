import java.util.Arrays; // para que sirva mi quick sort y la impresion de cadenas
import java.util.Random; // para la generación de numeros aleatorios.
import java.util.Scanner; // para leer la peticion del usuario

public class BusquedaBinaria {

    public static void main(String args[]) {

        Scanner peticion = new Scanner(System.in);

        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            int numeroAleatorio = (int) (Math.random() * 100);
            arr[i] = numeroAleatorio;
        }

        System.out.println("Arreglo con Numeros Aleatorios " + Arrays.toString(arr));

        int[] arrQuickSort = quickSort(arr);
        System.out.println("Arreglo Ordenado:" + Arrays.toString(arrQuickSort));
        System.out.println();

        System.out.println("Que numeros deseas buscar: ");
        int x = peticion.nextInt();

        busquedaBinaria(arr, x);

    }

    public static void busquedaBinaria(int[] elementos, int x) {
        int izquierda = 0, derecha = elementos.length - 1;
        boolean encontrado = false;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (elementos[medio] == x) {
                System.out.println("Tu elemento está en la posición: " + medio);
                encontrado = true;
                break;
            }
            if (elementos[medio] < x)
                izquierda = medio + 1;
            else
                derecha = medio - 1;
        }
        if (!encontrado) {
            System.out.println("El elemento no se encuentra en el arreglo.");
        }
    }

    public static int[] quickSort(int array[]) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static int[] quickSort(int array[], int primero, int ultimo) {
        int i, j, central;
        double pivote;
        central = (primero + ultimo) / 2;
        pivote = array[central];
        i = primero;
        j = ultimo;

        do {
            while (array[i] < pivote)
                i++;
            while (array[j] > pivote)
                j--;
            if (i <= j) {
                int aux = array[i];
                array[i] = array[j];
                array[j] = aux;

                i++;
                j--;
            }
        } while (i <= j);

        if (primero < j)
            quickSort(array, primero, j);
        if (i < ultimo)
            quickSort(array, i, ultimo);
        return array;
    }

}