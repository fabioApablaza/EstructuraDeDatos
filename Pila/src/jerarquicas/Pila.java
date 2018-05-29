
package jerarquicas;




public class Pila {
    private NodoObject tope;
    public Pila(){
        this.tope=null;
    }
    public boolean apilar(Object nuevoElem){
        NodoObject nodoNuevo=new NodoObject(nuevoElem, this.tope);
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
    public Object obtenerTope(){
        Object elemento;
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
    public Pila clonar(){
        Pila clon= new Pila();
        clon.AuxRecur(clon, this.tope);
        return clon;
    }
    private void AuxRecur(Pila pila,NodoObject nodo){
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
            NodoObject aux=this.tope;
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
