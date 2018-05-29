
package lineales.dinamicas;


public class TestPila {
    public static void main(String[]args){
        PilaInt pila= new PilaInt();
        PilaInt clon;
        
        pila.apilar(1);
        pila.apilar(2);
        clon=pila.clonar();
        System.out.println(pila.toString());
        System.out.println(clon.toString());
        
        
    }
    
}
