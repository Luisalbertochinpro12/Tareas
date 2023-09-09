#include <iostream>
#include <stack>

using namespace std;

void pila(stack <int> miPila){
	while(!miPila.empty()){
		cout<<miPila.top()<<endl;
		
		miPila.pop();
	}
	cout<<"	"<<endl;
}

int main(){
	
	stack <int> miPila;
	miPila.push(14);
	miPila.push(27);
	miPila.push(1);
	miPila.push(15);
	miPila.push(10);
	miPila.push(90);
	miPila.push(71);
	miPila.push(37);
	miPila.push(2);
	miPila.push(48);
	
	cout<<"Los elementos iniciales de la pila son: "<<endl;
	pila(miPila);
	
	cout<<"El elemento de la cima es: "<< miPila.top()<<endl;
	
	cout<<"La pila es de tamano: "<< miPila.size() <<endl;
	
	if(!miPila.empty()){
		cout<<"La pila tiene datos"<<endl;
	}
	
	cout<<"\n";
	
	for(int i = 0; i < 4 ; i++){
		miPila.pop();
	}
	
	cout<<"Los elementos actuales de la pila son: "<<endl;
	pila(miPila);
	
	cout<<"El elemento actual de la cima es: "<< miPila.top()<<endl;
	
	cout<<"La pila es de tamano actualmente: "<< miPila.size() <<endl;
	
	if(!miPila.empty()){
		cout<<"La pila tiene datos"<<endl;
	}
	while(!miPila.empty()){
		miPila.pop();
	}
	
	cout<<"\n";
	
	cout<<"Los elementos actuales de la pila son: "<<endl;
	pila(miPila);
	
	cout<<"No hay elementos en la cima"<<endl;
	
	cout<<"La pila es de actualmente de tamano: "<< miPila.size()<<endl;
	
	cout<<"La pila esta vacia"<<endl;
	
	
	
	
}
