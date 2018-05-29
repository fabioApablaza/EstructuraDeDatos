
package lineales.dinamicas;


public class ListaChar {
    private NodoChar cabecera;
    public ListaChar(){
        this.cabecera=null;
    }
    public boolean insertar(char elem,int pos){
        boolean exito=true;
        
        
        if(pos<1||pos>this.longitud()+1)
            exito=false;
        else{
            if(pos==1){
                this.cabecera=new NodoChar(elem,this.cabecera);
                
            }
            else{
                NodoChar temp=this.cabecera;
                int i=1;
                
                while(i<pos-1){
                temp=temp.getEnlace();
                i++;
                }
                NodoChar Nodo=new NodoChar(elem,temp.getEnlace());
                temp.setEnlace(Nodo);
            }
        }
        
        return exito;
    }
    public boolean eliminar(int pos){
        boolean exito=true;
        int i=1;
        NodoChar temp;
        if((this.cabecera==null)||(pos<1||pos>this.longitud())){
            exito=false;
        }
        else{
            if(pos==1){
                this.cabecera=this.cabecera.getEnlace();
            }
            else{
                temp=this.cabecera;
                while(i<pos-1){
                    temp=temp.getEnlace();
                    i++;
                }
                temp.setEnlace(temp.getEnlace().getEnlace());
            }
            
        }
        return exito;
    }
    public int recuperar(int pos){
        int i=1;
        char elemento;
        NodoChar temp=this.cabecera;
        if(pos<1||pos>this.longitud()){
            elemento=Character.MIN_VALUE;
        }
        else{
            while(i!=pos){
                temp=temp.getEnlace();
                i++;
            }
            elemento=temp.getElem();
        }
        return elemento;
    }
    public int longitud(){
        int cant;
        NodoChar temp;
        if(this.cabecera!=null){
            temp=this.cabecera;
            cant=1;
            while(temp.getEnlace()!=null){
                cant++;
                temp=temp.getEnlace();
            }
            
            
        }
        else
            cant=0;
        return cant;
    }
    public int localizar(char elem){
        int pos=-1;
        NodoChar temp=this.cabecera;
        if(temp!=null){
            pos=1;
            while(temp.getEnlace()!=null&&temp.getElem()!=elem){
                temp=temp.getEnlace();
                pos++;
            }
        }
        
          
        
        return pos;
    }
    public void vaciar(){
        this.cabecera=null;
    }
    public boolean esVacia(){
        boolean exito=true;
        if(this.cabecera!=null){
            exito=false;
        }
        return exito;
    }
    public ListaChar clonar(){
        ListaChar temp=new ListaChar();
        temp.recClonar(temp,this.cabecera);
        
    
        return temp;
    }
    private void recClonar(ListaChar temp,NodoChar Nodo){
        if(Nodo!=null){
            this.recClonar(temp, Nodo.getEnlace());
        }
        temp.cabecera=Nodo;
        
    }
    @Override
    public String toString(){
        String cadena="";
        
        if(esVacia()){
            cadena="Lista vacia";
        }
        else{
            NodoChar temp=this.cabecera;
            while(temp.getEnlace()!=null){
                cadena=cadena+temp.getElem();
                temp=temp.getEnlace();
                cadena=cadena+" ";
            }
            cadena=cadena+temp.getElem();
        }
            
        return cadena;
    }

    
}
