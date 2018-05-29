
package lineales.dinamicas;

import lineales.dinamicas.NodoChar;





public class pilaChar {
    private NodoChar tope;
    public pilaChar(){
        this.tope=null;
    }
    public boolean apilar(char nuevoElem){
        NodoChar nodoNuevo=new NodoChar(nuevoElem, this.tope);
        this.tope=nodoNuevo;
        return true;
    }
    public boolean desapilar(){
        boolean exito;
        if(this.tope==null){
            exito=false;
        }
        else{
            this.tope=this.tope.getEnlace();
            exito=true;
        }
        return exito;
    }
    public char obtenerTope(){
        char elemento;
        if(this.tope==null){
            elemento=Character.MIN_VALUE;
        }
        else
            elemento=this.tope.getElem();
        return elemento;
    }
    public boolean esVacia(){
        boolean resp;
        if(this.tope==null){
            resp=true;
        }
        else{
            resp=false;
        }
        return resp;
    }
    public void vaciar(){
        this.tope=null;
    }
    public pilaChar clonar(){
        pilaChar clon= new pilaChar();
        clon.AuxRecur(clon, this.tope);
        return clon;
    }
    private void AuxRecur(pilaChar pila,NodoChar nodo){
        if(nodo!=null){
            this.AuxRecur(pila, nodo.getEnlace());
        }
        pila.tope=nodo;
    }
    @Override
    public String toString(){
        String cadena="";
        if(this.tope==null){
            cadena="Pila vacia";
        }
        else{
            cadena="[";
            NodoChar aux=this.tope;
            while(aux!=null){
                cadena+=aux.getElem();
                aux=aux.getEnlace();
                if(aux!=null){
                    cadena+=",";
                }
            }
            cadena+="]";
        }
        return cadena;
    }
    
}
