
package jerarquicas;




public class Cola {
    private NodoObject frente;
    private NodoObject fin;
    public Cola(){
    this.frente=null;
    this.fin=null;
}
    public boolean poner(Object tipoElemento){
        boolean exito;
        NodoObject Nodo;
        Nodo=new NodoObject(tipoElemento);
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
    public Object obtenerFrente(){
        Object elemento;
        if(esVacia()){
            elemento=Integer.MIN_VALUE;
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
    public Cola clonar(){
        Cola clon=new Cola();
        clon.colaRec(clon, this.frente);
        return clon;
    }
    private void colaRec(Cola cola,NodoObject nodo){
        if(nodo!=null){
            this.colaRec(cola, nodo.getEnlace());
        }
        this.frente=nodo;
    }
    @Override
    public String toString(){
        String cadena="";
        NodoObject aux=this.frente;
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
