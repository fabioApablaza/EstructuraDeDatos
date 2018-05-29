/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;




public class Lista {
    private NodoObject cabecera;
    public Lista(){
        this.cabecera=null;
    }
    public boolean insertar(Object elem,int pos){
        boolean exito=true;
        
        
        if(pos<1||pos>this.longitud()+1)
            exito=false;
        else{
            if(pos==1){
                this.cabecera=new NodoObject(elem,this.cabecera);
                
            }
            else{
                NodoObject temp=this.cabecera;
                int i=1;
                
                while(i<pos-1){
                temp=temp.getEnlace();
                i++;
                }
                NodoObject Nodo=new NodoObject(elem,temp.getEnlace());
                temp.setEnlace(Nodo);
            }
        }
        
        return exito;
    }
    public boolean eliminar(int pos){
        boolean exito=true;
        int i=1;
        NodoObject temp;
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
    public Object recuperar(int pos){
        Object elemento;
        int i=1;
        NodoObject temp=this.cabecera;
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
        NodoObject temp;
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
    public Object localizar(Object elem){
        int pos=-1;
        NodoObject temp=this.cabecera;
        if(temp!=null){
            pos=1;
            while(temp.getEnlace()!=null&&!temp.getElem().equals(elem)){
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
    public Lista clonar(){
        Lista temp=new Lista();
        temp.recClonar(temp,this.cabecera);
        
    
        return temp;
    }
    private void recClonar(Lista temp,NodoObject Nodo){
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
            NodoObject temp=this.cabecera;
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
