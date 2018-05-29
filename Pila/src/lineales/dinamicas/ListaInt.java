
package lineales.dinamicas;


public class ListaInt {
    private NodoInt cabecera;
    public ListaInt(){
        this.cabecera=null;
    }
    public boolean insertar(int elem,int pos){
        boolean exito=true;
        
        
        if(pos<1||pos>this.longitud()+1)
            exito=false;
        else{
            if(pos==1){
                this.cabecera=new NodoInt(elem,this.cabecera);
                
            }
            else{
                NodoInt temp=this.cabecera;
                int i=1;
                
                while(i<pos-1){
                temp=temp.getEnlace();
                i++;
                }
                NodoInt Nodo=new NodoInt(elem,temp.getEnlace());
                temp.setEnlace(Nodo);
            }
        }
        
        return exito;
    }
    public boolean eliminar(int pos){
        boolean exito=true;
        int i=1;
        NodoInt temp;
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
        int elemento,i=1;
        NodoInt temp=this.cabecera;
        if(pos<1||pos>this.longitud()){
            elemento=Integer.MIN_VALUE;
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
        NodoInt temp;
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
    public int localizar(int elem){
        int pos=-1;
        NodoInt temp=this.cabecera;
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
    public ListaInt clonar(){
        ListaInt temp=new ListaInt();
        temp.recClonar(temp,this.cabecera);
        
    
        return temp;
    }
    private void recClonar(ListaInt temp,NodoInt Nodo){
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
            NodoInt temp=this.cabecera;
            while(temp.getEnlace()!=null){
                cadena=cadena+temp.getElem();
                temp=temp.getEnlace();
                cadena=cadena+" ";
            }
            cadena=cadena+temp.getElem();
        }
            
        return cadena;
    }
    public void insertarPromedio(){
        int promedio=0,i=0;
        NodoInt temp=this.cabecera;
        while(temp.getEnlace()!=null){
            promedio=promedio+temp.getElem();
            temp=temp.getEnlace();
            i++;
        }
        i++;
        promedio=promedio+temp.getElem();
        promedio=promedio/i;
        NodoInt nodo=new NodoInt(promedio);
        temp.setEnlace(nodo);
    }
    public void eliminarApariciones(int x){
        NodoInt temp,aux;
        if(this.cabecera!=null){
            temp=this.cabecera;
            aux=this.cabecera;
            while(aux==this.cabecera&&aux!=null){
                if(aux.getElem()==x){
                    this.cabecera=aux.getEnlace();
                    aux=aux.getEnlace();
                    temp=this.cabecera;
                }
                else{
                    
                    aux=aux.getEnlace();
                }
            }
            while(aux!=null){
                if(aux.getElem()==x){
                    temp.setEnlace(aux.getEnlace());
                    aux=aux.getEnlace();
                }
                else{
                    temp=aux;
                    aux=aux.getEnlace();
                }
            }
            
            
        }
        }
    public void compactar(int x){
        NodoInt nodo=this.cabecera,temp=this.cabecera;
        int m,s;
        if(this.longitud()%x==0){
            while(nodo!=null){
                m=1;
                s=1;
                while(m<=x){
                    s=s*nodo.getElem();
                    m++;
                    nodo=nodo.getEnlace();
                }
                temp.setElem(s);
                if(nodo!=null){
                    temp=temp.getEnlace();
                }
                else{
                    temp.setEnlace(nodo);
                }
            }
        }
    }
}
