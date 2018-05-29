
package test.jerarquicas;
import jerarquicas.ArbolHeap;

public class TestHeap {
    public static void main(String[]args){
        ArbolHeap arbol=new ArbolHeap();
        arbol.insertar(4);
        arbol.insertar(7);
        arbol.insertar(3);
        arbol.insertar(1);
        arbol.insertar(5);
        arbol.insertar(6);
        arbol.insertar(2);
        arbol.insertar(22);
        arbol.insertar(54);
        arbol.insertar(-5);
        arbol.insertar(-10);
        
        System.out.println(arbol.toString());
    }
}
