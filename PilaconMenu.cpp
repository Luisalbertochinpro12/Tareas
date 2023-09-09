#include <iostream>
#include <math.h>
#include <stdlib.h>
#include <conio.h>
#include <windows.h>

using namespace std;

struct Nodo{
	int dato;
	Nodo *siguiente;
};


void agregarPila(Nodo *&pila,int);
void sacarPila(Nodo *&pila, int);
void menu(int);

	Nodo *pila = NULL;	
	int n0 = 14, n1 = 27, n2 = 1, n3 = 15, n4 = 10, n5 = 90, n6 = 71, n7 = 37, n8 = 2, n9 = 48, i = 10;
	int opcion, dato;

int main(){
	
	agregarPila(pila, n0);
	agregarPila(pila, n1);
	agregarPila(pila, n2);
	agregarPila(pila, n3);
	agregarPila(pila, n4);
	agregarPila(pila, n5);
	agregarPila(pila, n6);
	agregarPila(pila, n7);
	agregarPila(pila, n8);
	agregarPila(pila, n9);
	
	menu(opcion);
	
		
}

void agregarPila(Nodo *&pila, int n){
	Nodo *nuevo_nodo = new Nodo();
	nuevo_nodo-> dato = n;
	nuevo_nodo->siguiente = pila;
	pila = nuevo_nodo;
	
}

void sacarPila(Nodo *&pila, int n){
	Nodo *aux = pila;	
	n = aux->dato;
	pila = aux->siguiente;
	delete aux;
	
	cout<<"Sacamos exitosamente a "<< n <<" de la pila "<<endl;
}

void menu(int opcion){
	
	cout<<"1. Agregar algo a la pila."<<endl;
	cout<<"2. Elimiminar ultimo caracter de la pila."<<endl;
	cout<<"3. Comprobar si esta vacia la pila."<<endl;
	cout<<"4. Vaciar la pila."<<endl;
	cout<<"5. Obtener el ultimo elemento de la pila."<<endl;
	cout<<"6. Obtener el tamano de la pila."<<endl;
	cout<<"Que opcion eliges: ";
	cin>>opcion;
	
	switch(opcion){
		case 1:
		 		cout<<"Digite un caracter: ";
		 		cin>>dato;
		 		agregarPila(pila, dato);
		 		cout<<"Se agrego " <<dato<<" correctamente a la cima de la pila"<<endl;
		 		i ++;
		 		cout<<"\n"<<endl;
		 		menu(opcion);
		 		
			break;
		case 2:
				while(pila != NULL){
				sacarPila(pila, dato);
				if(pila == NULL){
				cout<<"No hay mas elementos por borrar"<<endl;
				}			
				i --;
				if(i < 0){
					i = 0;
				}
				cout<<"\n"<<endl;
				menu(opcion);
			break;
		case 3: 
			if(pila != NULL){
				cout<<"La pila tiene datos guardados"<<endl;
			}
			if(pila == NULL){
				cout<<"La pila no tiene nada guardado"<<endl;
		}
		    cout<<"\n"<<endl;
			menu(opcion);
		break;
		case 4:
				pila = NULL;
				i = 0;
				cout<<"La pila fue vaciada exitosamente."<<endl;
		 	
		 		
	 			cout<<"\n"<<endl;
		 		menu(opcion);
				}
		 		
		break;
		case 5:
				cout<<"El ultimo dato en la cima de la pila es: "<<endl;
					if(i >= 11){
						cout<<dato<<endl;
					}
					if(i == 10){
						cout<<n9<<endl;
					}
					if(i == 9){
						cout<<n8<<endl;
					}if(i == 8){
						cout<<n7<<endl;
					}if(i == 7){
						cout<<n6<<endl;
					}if(i == 6){
						cout<<n5<<endl;
					}if(i == 5){
						cout<<n4<<endl;
					}if(i == 4){
						cout<<n3<<endl;
					}if(i == 3){
						cout<<n2<<endl;
					}if(i == 2){
						cout<<n1<<endl;
					}if(i == 1){
						cout<<n0<<endl;
					}
				cout<<"\n"<<endl;		
				menu(opcion);
		break;
		case 6:
			
				cout<<"La pila es de tamano: "<<i<<endl;
					
				if(i == 11){
				cout<<dato<<", "<<n9<<", "<<n8<<", "<<n7<<", "<<n6<<", "<<n5<<", "<<n4<<", "<<n3<<", "<<n2<<", "<<n1<<", "<<n0<<", "<<endl;	
				}
				if(i == 10){
				cout<<n9<<", "<<n8<<", "<<n7<<", "<<n6<<", "<<n5<<", "<<n4<<", "<<n3<<", "<<n2<<", "<<n1<<", "<<n0<<", "<<endl;
				}
				if(i == 9){
				cout<<n8<<", "<<n7<<", "<<n6<<", "<<n5<<", "<<n4<<", "<<n3<<", "<<n2<<", "<<n1<<", "<<n0<<", "<<endl;
				}
				if(i == 8){
				cout<<n7<<", "<<n6<<", "<<n5<<", "<<n4<<", "<<n3<<", "<<n2<<", "<<n1<<", "<<n0<<", "<<endl;
				}
				if(i == 7){
				cout<<n6<<", "<<n5<<", "<<n4<<", "<<n3<<", "<<n2<<", "<<n1<<", "<<n0<<", "<<endl;
				}
				if(i == 6){
				cout<<n5<<", "<<n4<<", "<<n3<<", "<<n2<<", "<<n1<<", "<<n0<<", "<<endl;
				}
				if(i == 5){
				cout<<n4<<", "<<n3<<", "<<n2<<", "<<n1<<", "<<n0<<endl;
				}
				if(i == 4){
				cout<<n3<<", "<<n2<<", "<<n1<<", "<<n0<<endl;
				}
				if(i == 3){
				cout<<n2<<", "<<n1<<", "<<n0<<endl;
				}
				if(i == 2){
				cout<<n1<<", "<<n0<<endl;
				}
				if(i == 1){
				cout<<n0<<endl;
				}
				if(pila == NULL){
					cout<<"La pila no contiene nada, por favor introduce algun dato"<<endl;
				}
				cout<<"\n"<<endl;
				menu(opcion);
		break;
	}
	
}
