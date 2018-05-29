
package test.jerarquicas;
import jerarquicas.ArbolGen;
import jerarquicas.Lista;
import jerarquicas.Pila;

public class TestArbolGen {
    public static void main(String[]args){
        Lista lista;
        ArbolGen arbol=new ArbolGen();
        arbol.insertar('A', 'A');
        arbol.insertar('B', 'A');
        arbol.insertar('C', 'A');
        arbol.insertar('D', 'A');
        arbol.insertar('E', 'B');
        arbol.insertar('F', 'B');
        arbol.insertar('J', 'F');
        arbol.insertar('K', 'F');
        arbol.insertar('L', 'F');
        arbol.insertar('G', 'D');
        arbol.insertar('H', 'D');
        arbol.insertar('I', 'D');
        arbol.insertar('M', 'G');
        arbol.insertar('P', 'M');
        arbol.insertar('Q', 'M');
        arbol.insertar('N', 'I');
        arbol.insertar('O', 'I');
        System.out.println(arbol.padre('Q'));
        
    }
}
