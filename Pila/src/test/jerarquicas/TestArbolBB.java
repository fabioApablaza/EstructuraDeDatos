
package test.jerarquicas;
import jerarquicas.ArbolBB;
import jerarquicas.ListaComp;
public class TestArbolBB {
    public static void main(String[]args){
        ArbolBB arbol= new ArbolBB();
        
        ListaComp lista;
        
        arbol.insertar(45);
        arbol.insertar(34);
        arbol.insertar(65);
        arbol.insertar(13);
        arbol.insertar(55);
        arbol.insertar(73);
        arbol.insertar(96);
        lista=arbol.listar();
        System.out.println(lista.toString());
        
    }
}
