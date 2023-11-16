class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.izquierda = None
        self.derecha = None
        self.altura = 1

class AVL:
    def __init__(self):
        self.raiz = None

    def altura(self, nodo):
        if nodo is None:
            return 0
        return nodo.altura

    def actualizar_altura(self, nodo):
        if nodo is not None:
            nodo.altura = 1 + max(self.altura(nodo.izquierda), self.altura(nodo.derecha))

    def rotar_derecha(self, y):
        x = y.izquierda
        T2 = x.derecha

        x.derecha = y
        y.izquierda = T2

        self.actualizar_altura(y)
        self.actualizar_altura(x)

        return x

    def rotar_izquierda(self, x):
        y = x.derecha
        T2 = y.izquierda

        y.izquierda = x
        x.derecha = T2

        self.actualizar_altura(x)
        self.actualizar_altura(y)

        return y

    def balance(self, nodo):
        if nodo is None:
            return 0
        return self.altura(nodo.izquierda) - self.altura(nodo.derecha)

    def insertar(self, valor):
        if not self.raiz:
            self.raiz = Nodo(valor)
        else:
            self.raiz = self._insertar(valor, self.raiz)

    def _insertar(self, valor, nodo):
        if not nodo:
            return Nodo(valor)

        if valor <= nodo.valor:
            nodo.izquierda = self._insertar(valor, nodo.izquierda)
        else:
            nodo.derecha = self._insertar(valor, nodo.derecha)

        self.actualizar_altura(nodo)

        balance = self.balance(nodo)

        # Caso de desequilibrio izquierda-izquierda
        if balance > 1 and valor <= nodo.izquierda.valor:
            return self.rotar_derecha(nodo)

        # Caso de desequilibrio derecha-derecha
        if balance < -1 and valor > nodo.derecha.valor:
            return self.rotar_izquierda(nodo)

        # Caso de desequilibrio izquierda-derecha
        if balance > 1 and valor > nodo.izquierda.valor:
            nodo.izquierda = self.rotar_izquierda(nodo.izquierda)
            return self.rotar_derecha(nodo)

        # Caso de desequilibrio derecha-izquierda
        if balance < -1 and valor <= nodo.derecha.valor:
            nodo.derecha = self.rotar_derecha(nodo.derecha)
            return self.rotar_izquierda(nodo)

        return nodo

    def buscar(self, valor):
        if self.raiz:
            return self._buscar(valor, self.raiz)
        else:
            return False

    def _buscar(self, valor, nodo):
        if not nodo:
            return False

        if valor == nodo.valor:
            return True
        elif valor < nodo.valor:
            return self._buscar(valor, nodo.izquierda)
        else:
            return self._buscar(valor, nodo.derecha)

    def eliminar(self, valor):
        if self.raiz:
            self.raiz = self._eliminar(valor, self.raiz)

    def _eliminar(self, valor, nodo):
        if not nodo:
            return nodo

        if valor < nodo.valor:
            nodo.izquierda = self._eliminar(valor, nodo.izquierda)
        elif valor > nodo.valor:
            nodo.derecha = self._eliminar(valor, nodo.derecha)
        else:
            # Nodo con un solo hijo o sin hijos
            if not nodo.izquierda:
                temp = nodo.derecha
                nodo = None
                return temp
            elif not nodo.derecha:
                temp = nodo.izquierda
                nodo = None
                return temp

            # Nodo con dos hijos, obtener el sucesor inorden (el más pequeño
            # en el subárbol derecho)
            temp = self._nodo_minimo(nodo.derecha)
            nodo.valor = temp.valor
            nodo.derecha = self._eliminar(temp.valor, nodo.derecha)

        if not nodo:
            return nodo

        self.actualizar_altura(nodo)

        balance = self.balance(nodo)

        # Caso de desequilibrio izquierda-izquierda
        if balance > 1 and self.balance(nodo.izquierda) >= 0:
            return self.rotar_derecha(nodo)

        # Caso de desequilibrio izquierda-derecha
        if balance > 1 and self.balance(nodo.izquierda) < 0:
            nodo.izquierda = self.rotar_izquierda(nodo.izquierda)
            return self.rotar_derecha(nodo)

        # Caso de desequilibrio derecha-derecha
        if balance < -1 and self.balance(nodo.derecha) <= 0:
            return self.rotar_izquierda(nodo)

        # Caso de desequilibrio derecha-izquierda
        if balance < -1 and self.balance(nodo.derecha) > 0:
            nodo.derecha = self.rotar_derecha(nodo.derecha)
            return self.rotar_izquierda(nodo)

        return nodo

    def _nodo_minimo(self, nodo):
        while nodo.izquierda is not None:
            nodo = nodo.izquierda
        return nodo

    def imprimir_en_orden(self, nodo):
        if nodo:
            self.imprimir_en_orden(nodo.izquierda)
            print(nodo.valor, end=" ")
            self.imprimir_en_orden(nodo.derecha)

    def esta_vacio(self):
        return self.raiz is None

# Menú interactivo
if __name__ == "__main__":
    arbol_avl = AVL()

    while True:
        print("\nMenú:")
        print("1. Agregar nodo")
        print("2. Eliminar nodo")
        print("3. Imprimir en orden")
        print("4. ¿Está vacío el árbol?")
        print("5. Buscar nodo específico")
        print("6. Salir")

        opcion = input("Ingrese el número de la opción deseada: ")

        if opcion == "1":
            valor = int(input("Ingrese el valor del nodo a agregar: "))
            arbol_avl.insertar(valor)
            print(f"Nodo con valor {valor} agregado correctamente.")

        elif opcion == "2":
            valor = int(input("Ingrese el valor del nodo a eliminar: "))
            arbol_avl.eliminar(valor)
            print(f"Nodo con valor {valor} eliminado correctamente.")

        elif opcion == "3":
            print("Árbol AVL en orden:")
            arbol_avl.imprimir_en_orden(arbol_avl.raiz)

        elif opcion == "4":
            if arbol_avl.esta_vacio():
                print("El árbol está vacío.")
            else:
                print("El árbol no está vacío.")

        elif opcion == "5":
            valor = int(input("Ingrese el valor del nodo a buscar: "))
            if arbol_avl.buscar(valor):
                print(f"El nodo con valor {valor} está en el árbol.")
            else:
                print(f"El nodo con valor {valor} no está en el árbol.")

        elif opcion == "6":
            print("Saliendo del programa. ¡Hasta luego!")
            break

        else:
            print("Opción no válida. Por favor, ingrese un número del 1 al 6.")
