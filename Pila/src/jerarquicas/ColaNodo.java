
package jerarquicas;


public class ColaNodo {
    private Nodo frente;
    private Nodo fin;
    public ColaNodo(){
    this.frente=null;
    this.fin=null;
}
    public boolean poner(NodoGen tipoElemento){
        boolean exito;
        Nodo Nodo;
        Nodo=new Nodo(tipoElemento);
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
    public NodoGen obtenerFrente(){
        NodoGen elemento;
        if(esVacia()){
            elemento=null;
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
    public ColaNodo clonar(){
        ColaNodo clon=new ColaNodo();
        clon.colaRec(clon, this.frente);
        return clon;
    }
    private void colaRec(ColaNodo cola,Nodo nodo){
        if(nodo!=null){
            this.colaRec(cola, nodo.getEnlace());
        }
        this.frente=nodo;
    }
    @Override
    public String toString(){
        String cadena="";
        Nodo aux=this.frente;
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
