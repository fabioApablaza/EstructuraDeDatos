
package lineales.estaticas;


public class ColaInt {
    private static final int TAM=5;
    private int[] cola;
    private int frente;
    private int fin;
    public ColaInt(){
        this.cola= new int[TAM];
        this.frente=0;
        this.fin=0;
    }
    public boolean poner(int nuevoElem){
        boolean exito;
        if(((this.fin+1)%this.TAM)==this.frente){
            exito=false;
        }
        else{
            this.cola[this.fin]=nuevoElem;
            this.fin=this.fin+1;
            exito=true;
        }
        return exito;
    }
    public boolean sacar(){
        boolean exito=true;
        if(this.esVacia()){
            exito=false;
        }
        else{
            this.frente=(this.frente+1)%this.TAM;
        }
        return exito;
    }
    public int obtenerFrente(){
        int elemento;
        if(this.esVacia()){
            elemento=Integer.MIN_VALUE;
        }
        else{
            elemento=this.cola[this.frente];
        }
        return elemento;
    }
    public boolean esVacia(){
        boolean resp;
        if(this.frente==this.fin){
            resp=true;
        }
        else{
            resp=false;
        }
        return resp;
    }
    public void vaciar(){
        this.fin=0;
        this.frente=0;
    }
    public ColaInt clonar(){
        ColaInt clon=new ColaInt();
        for(int i=0;i<this.TAM;i++){
            clon.poner(this.cola[i]);
        }
        return clon;
    }
    @Override
    public String toString(){
        String cadena="";
        int aux=this.frente;
        
        if(esVacia()){
            cadena="Cola Vacia";
        }
        else{
            cadena=cadena+"[";
            while(aux!=this.fin){
                cadena=cadena+this.cola[aux];
                aux++;
                if(aux== this.fin){
                    cadena=cadena+"]";
                }
            }
        }
        return cadena;
    }
}
