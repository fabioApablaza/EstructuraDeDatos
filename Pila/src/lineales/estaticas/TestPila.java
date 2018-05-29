
package lineales.estaticas;
import lineales.dinamicas.PilaInt;

public class TestPila {
    public static boolean capicua(PilaInt pila){
        
        PilaInt clon;
        clon=new PilaInt();
        boolean resp=true;
        String cadena=pila.toString();
        int i=cadena.length()-1;
        while(i>=0){
            clon.apilar(pila.obtenerTope());
            pila.desapilar();
            i--;
        }
        resp=clon.toString().equalsIgnoreCase(cadena);
        return resp;
    }
    public static void main(String[]args){
        PilaInt pila;
        pila= new PilaInt();
        PilaInt clon;
        clon = new PilaInt();
        
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(2);
        pila.apilar(1);
        System.out.println(capicua(pila));
        
        //System.out.println(pila.toString());
        //System.out.println(clon.toString());
        
        
    }
    
}
