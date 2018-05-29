
package lineales.dinamicas;


public class ArbolBinChar {
    private NodoArbolChar raiz;
    public ArbolBinChar(){
        this.raiz=null;
    }
    public ArbolBinChar(NodoArbolChar raiz){
        this.raiz=raiz;
    }
    public boolean insertar(char elemNuevo,char elemPadre,char lugar){
        boolean exito=true;
        if(this.raiz==null){
            this.raiz= new NodoArbolChar(elemNuevo);
        }
        else{
            NodoArbolChar nodoPadre= obtenerNodo(this.raiz,elemPadre);
            if(nodoPadre!=null){
                if((lugar=='I'||lugar=='i')&& nodoPadre.getIzquierdo()==null){
                    nodoPadre.setIzquierdo(new NodoArbolChar(elemNuevo));
                }
                else{
                    if((lugar=='D'||lugar=='d')&&nodoPadre.getDerecho()==null){
                        nodoPadre.setDerecho(new NodoArbolChar(elemNuevo));
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
    private NodoArbolChar obtenerNodo(NodoArbolChar n,char buscado){
        //"n" es la raiz y "buscado" es el elemento buscado
        NodoArbolChar resultado=null;
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
    public boolean verificarPatron(ListaChar lisPatron){
        boolean exito=false;
        if(this.raiz!=null){
            exito=verificarRec(lisPatron,1,this.raiz);
        }
        return exito;
    }
    private boolean verificarRec(ListaChar lisPatron,int i, NodoArbolChar nodo){
        boolean resultado=false;
        if(nodo!=null){
            if(nodo.getElem()==lisPatron.recuperar(i)){
                if(nodo.getIzquierdo()==null&&nodo.getDerecho()==null&lisPatron.longitud()==i){
                    resultado=true;
                }
                else{
                    i++;
                    resultado=verificarRec(lisPatron,i,nodo.getIzquierdo());
                    if(!resultado){
                        resultado=verificarRec(lisPatron,i,nodo.getDerecho());
                    }
                    
                }
                
            }
            
        }
        return resultado;
    }
    public ListaChar frontera(){
        ListaChar l1=new ListaChar();
        if(this.raiz!=null){
            fronteraRec(this.raiz,1,l1);
        }
        return l1;
    }
    private void fronteraRec(NodoArbolChar nodo, int i, ListaChar l2){
        if(nodo!=null){
            if(nodo.getIzquierdo()==null&&nodo.getDerecho()==null){
                l2.insertar(nodo.getElem(), i);
            }
            else{
                fronteraRec(nodo.getIzquierdo(),i,l2);
                i=l2.longitud()+1;
                fronteraRec(nodo.getDerecho(),i,l2);
        }
       
    }}
    public ArbolBinChar clonar(){
        ArbolBinChar clon=new ArbolBinChar();
        if(this.raiz!=null){
            clon.raiz=clonarAux(this.raiz);
        }
        return clon;
    }
    private NodoArbolChar clonarAux(NodoArbolChar nodo){
        NodoArbolChar nuevo=null;
        if(nodo!=null){
            nuevo=new NodoArbolChar(nodo.getElem(),nodo.getDerecho(),nodo.getIzquierdo());
        }
        return nuevo;
    }
    public void preOrden(){
        preordenAux(this.raiz);
    }
    private void preordenAux(NodoArbolChar nodo){
        if(nodo!=null){
            System.out.print(nodo.getElem());
            preordenAux(nodo.getIzquierdo());
            preordenAux(nodo.getDerecho());
        }
    }
    public boolean equals(ArbolBinChar otro){
        boolean resultado=false;
        if(this.raiz!=null){
            resultado=equalsRec(otro.raiz,this.raiz);
        }
        else
            if(this.raiz==otro.raiz){
                resultado=true;
            }
        return resultado;
    }
    private boolean equalsRec(NodoArbolChar nodo, NodoArbolChar actual){
        boolean res=false;
        if(nodo!=null&&actual!=null){
            if(nodo.getElem()==actual.getElem()){
                if(nodo.getIzquierdo()==null&&actual.getIzquierdo()==null){
                    if(nodo.getDerecho()==null&&actual.getDerecho()==null){
                        res=true;
                    }
                    else
                        res=equalsRec(nodo.getDerecho(),actual.getDerecho());
                }
                else{
                    res=equalsRec(nodo.getIzquierdo(),actual.getIzquierdo());
                    if((nodo.getDerecho()!=null||actual.getDerecho()!=null)&&res){
                        res=equalsRec(nodo.getDerecho(),actual.getDerecho());
                    }
                }
            }
        }
        return res;
    }
    public ListaChar busquedaInOrden(char x){
        ListaChar lista=new ListaChar();
        if(this.raiz!=null){
            inordenREc(this.raiz,x,lista,false);
        }
        return lista;
    }
    private void inordenREc(NodoArbolChar nodo,char x,ListaChar l1,boolean exito){
        if(nodo!=null){
            if(nodo.getElem()!=x){
                inordenREc(nodo.getIzquierdo(),x,l1,exito);
                if(exito)
                    l1.insertar(nodo.getElem(), l1.longitud()+1);
                inordenREc(nodo.getDerecho(),x,l1,exito);
            }
            else{
                exito=true;
                inordenREc(nodo.getIzquierdo(),x,l1,exito);
                l1.insertar(nodo.getElem(), l1.longitud()+1);
                inordenREc(nodo.getDerecho(),x,l1,exito);
            }
        }
    }
    
    
}
