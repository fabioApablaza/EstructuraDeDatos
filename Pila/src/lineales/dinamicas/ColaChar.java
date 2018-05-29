
package lineales.dinamicas;


public class ColaChar {
    private NodoChar frente;
    private NodoChar fin;
    public ColaChar(){
    this.frente=null;
    this.fin=null;
}
    public boolean poner(char tipoElemento){
        boolean exito;
        NodoChar Nodo;
        Nodo=new NodoChar(tipoElemento);
        if(this.frente==null){
            
            this.frente=Nodo;
            this.fin=Nodo;
            exito=true;
        }
        else{
            this.fin.setEnlace(Nodo);
            this.fin=Nodo;
            
            exito=true;
            
        }
        return exito;
    }
    public boolean sacar(){
        boolean exito =true;
        if(this.frente==null){
            exito=false;
        }
        else{
            this.frente=this.frente.getEnlace();
            if(this.frente==null)
                this.fin=null;
        }
        return exito;
    }
    public char obtenerFrente(){
        char elemento;
        if(esVacia()){
            elemento=Character.MIN_VALUE;
        }
        else{
            elemento=this.frente.getElem();
        }
        return elemento;
    }
    public boolean esVacia(){
        boolean resp=false;
        if(this.frente==null){
            resp=true;
        }
        return resp;
    }
    public void vaciar(){
        this.frente=null;
        this.fin=null;
    }
    public ColaChar clonar(){
        ColaChar clon=new ColaChar();
        clon.colaRec(clon, this.frente);
        return clon;
    }
    private void colaRec(ColaChar cola,NodoChar nodo){
        if(nodo!=null){
            this.colaRec(cola, nodo.getEnlace());
        }
        this.frente=nodo;
    }
    @Override
    public String toString(){
        String cadena="";
        NodoChar aux=this.frente;
        if(esVacia()){
            cadena="Cola vacia";
        }else{
            while(aux!=this.fin){
            cadena=cadena+aux.getElem();
            aux=aux.getEnlace();
        }
        cadena=cadena+aux.getElem();
        }
        
        return cadena;
        
    }
    
}
