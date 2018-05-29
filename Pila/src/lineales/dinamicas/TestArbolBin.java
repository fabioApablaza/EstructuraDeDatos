
package lineales.dinamicas;


public class TestArbolBin {
    public static void main(String[]args){
        ArbolBinChar arbol=new ArbolBinChar(),arbol1=new ArbolBinChar();
        ListaChar aux;
        
        char elem='G',padre;
        int opcion=1;
        char posicion;
        arbol.insertar('A', 'A', 'I');
        arbol.insertar('B', 'A', 'I');
        arbol.insertar('E', 'A', 'D');
        arbol.insertar('C', 'B', 'I');
        arbol.insertar('D', 'B', 'D');
        arbol.insertar('F', 'E', 'I');
        arbol.insertar('G', 'E', 'D');
        arbol.insertar('H', 'G', 'I');
        arbol.insertar('I', 'G', 'D');
        aux=arbol.busquedaInOrden(elem);
        System.out.println(aux.toString());
        /*arbol1.insertar('A', 'A', 'I');
        arbol1.insertar('B', 'A', 'I');
        arbol1.insertar('C', 'A', 'D');
        arbol1.insertar('D', 'B', 'I');
        arbol1.insertar('E', 'B', 'D');
        arbol1.insertar('F', 'C', 'D');
        arbol1.insertar('G', 'D', 'D');*/
        //System.out.println(arbol.equals(arbol1));
        /*aux.insertar('A', 1);
        aux.insertar('C', 2);
        aux.insertar('E', 3);
        aux.insertar('G', 4);
        aux.insertar('H', 4);
        System.out.println(arbol.verificarPatron(aux));*/
        
        /*while(opcion!=0){
            System.out.print("Ingrese el elemento del arbol: ");
            elem=TecladoIn.readLineNonwhiteChar();
            System.out.print("Ingrese la posicion: ");
            posicion=TecladoIn.readLineNonwhiteChar();
            System.out.print("Ingrese el padre: ");
            padre=TecladoIn.readLineNonwhiteChar();
            arbol.insertar(elem, padre, posicion);
            System.out.print("¿Desea continuar? ");
            opcion=TecladoIn.readLineInt();
        }*/
        
        //aux=arbol.frontera();
        //System.out.println(aux.toString());
        /*while(opcion!=-1){
            System.out.print("Ingrese el elemento: ");
            elem=TecladoIn.readLineInt();
            System.out.println(arbol.padre(elem));
            System.out.print("¿Desea Continuar? ");
            opcion=TecladoIn.readLineInt();
        }*/
        //aux=arbol.preorden();
        //System.out.println(aux.toString());
        
    }
}
