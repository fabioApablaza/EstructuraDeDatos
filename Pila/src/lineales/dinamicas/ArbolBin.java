
package lineales.dinamicas;


public class ArbolBin {
    private NodoArbol raiz;
    public ArbolBin(){
        this.raiz=null;
    }
    public ArbolBin(NodoArbol raiz){
        this.raiz=raiz;
    }
    public boolean insertar(int elemNuevo,int elemPadre,char lugar){
        boolean exito=true;
        if(this.raiz==null){
            this.raiz= new NodoArbol(elemNuevo);
        }
        else{
            NodoArbol nodoPadre= obtenerNodo(this.raiz,elemPadre);
            if(nodoPadre!=null){
                if((lugar=='I'||lugar=='i')&& nodoPadre.getIzquierdo()==null){
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo));
                }
                else{
                    if((lugar=='D'||lugar=='d')&&nodoPadre.getDerecho()==null){
                        nodoPadre.setDerecho(new NodoArbol(elemNuevo));
                    }
                    else{
                        exito=false;
                    }
                }
            }
            else
                exito=false;
        }
        return exito;
    }
    private NodoArbol obtenerNodo(NodoArbol n,int buscado){
        //"n" es la raiz y "buscado" es el elemento buscado
        NodoArbol resultado=null;
        if(n!=null){
            if(n.getElem()==buscado){
                resultado=n;
            }
            else{
                resultado= obtenerNodo(n.getIzquierdo(), buscado);
                if(resultado==null){
                    resultado=obtenerNodo(n.getDerecho(),buscado);
                }
            }
        }
        return resultado;
    }
    public boolean esVacio(){
        boolean exito=false;
        if(this.raiz==null){
            exito=true;
        }
        return exito;
    }
    public int padre(int elem){
        int resultado;        
        if(this.raiz.getElem()==elem){
            resultado=elem;
        }
        else{
            resultado=obtenerPadre(this.raiz,elem).getElem();
        }
        
        return resultado;
    }
    private NodoArbol obtenerPadre(NodoArbol n,int elem){
        NodoArbol padre=null;
        if(n!=null){
            if(n.getIzquierdo()!=null){
                if(n.getIzquierdo().getElem()==elem){
                    padre=n;
                }
                else{
                    padre=obtenerPadre(n.getIzquierdo(),elem);
                }
            }
            if(padre!=null){
                if(n.getDerecho()!=null){
                    if(n.getDerecho().getElem()==elem){
                        padre=n;
                    }
                    else{
                        padre=obtenerPadre(n.getDerecho(),elem);
                    }
                }
            }
        }
        return padre;
    }
    public int altura(){
        int altura=3;
        if(this.raiz==null){
            altura=-1;
        }
        else{
            if(this.raiz.getDerecho()==null&&this.raiz.getIzquierdo()==null){
                altura=0;
            }
            else{
                
            }
        }
                
        return altura;
    }
    public void preOrden(){
        preordenAux(this.raiz);
    }
    private void preordenAux(NodoArbol nodo){
        if(nodo!=null){
            System.out.print(nodo.getElem());
            preordenAux(nodo.getIzquierdo());
            preordenAux(nodo.getDerecho());
        }
    }
    public ListaInt preorden(){
        ListaInt temp= new ListaInt();
        temp=preordenAux(this.raiz,temp,1);
        return temp;
    }
    private ListaInt preordenAux(NodoArbol nodo,ListaInt L1,int i){
        if(nodo!=null){
            L1.insertar(nodo.getElem(), i);
            i++;
            preordenAux(nodo.getIzquierdo(),L1,i);
            if(nodo==this.raiz){
                i=i+i;
            }
            i++;
            preordenAux(nodo.getDerecho(),L1,i);
        }
        return L1;
    }
   /* public void inorden(){
        //Devuelve una lista con los elementos del arbol binario en el recorrido inorden
        inordenAux(this.raiz);
    }
   /* private void inordenAux(NodoArbol nodo){
        if(nodo!=null){
            
            preordenAux(nodo.getIzquierdo());
            System.out.println(nodo.getElem());
            preordenAux(nodo.getDerecho());
        }
    }*/
    public boolean verificarPatron(String lisPatron){
        boolean exito=false;
        if(this.raiz!=null){
            exito=verificarRec(lisPatron,0,this.raiz);
        }
        return exito;
    }
    
    private boolean verificarRec(String lisPatron,int i, NodoArbol nodo){
        boolean exito=true;
        if(nodo!=null){
            if(nodo.getElem()==lisPatron.charAt(i)){
                i++;
                exito=verificarRec(lisPatron,i,nodo.getIzquierdo());
                if(!exito){
                    exito=verificarRec(lisPatron,i,nodo.getDerecho());
                }
                
            }
            else{
                exito=false;
            }
        }
        return exito;
    }
    
}
