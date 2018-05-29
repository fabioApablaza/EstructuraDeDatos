
package lineales.dinamicas;


public class PilaInt {
    private NodoInt tope;
    public PilaInt(){
        this.tope=null;
    }
    public boolean apilar(int nuevoElem){
        NodoInt nodoNuevo=new NodoInt(nuevoElem, this.tope);
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
    public int obtenerTope(){
        int elemento;
        if(this.tope==null){
            elemento=Integer.MIN_VALUE;
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
    public PilaInt clonar(){
        PilaInt clon= new PilaInt();
        clon.AuxRecur(clon, this.tope);
        return clon;
    }
    private void AuxRecur(PilaInt pila,NodoInt nodo){
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
            NodoInt aux=this.tope;
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
