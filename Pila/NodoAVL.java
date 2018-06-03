
package jerarquicas;


public class NodoAVL {
    private Comparable elem;
    private int altura;
    private NodoAVL izquierdo;
    private NodoAVL derecho;
    public NodoAVL(Comparable elem){
        this.elem=elem;
        this.izquierdo=null;
        this.derecho=null;
    }
    public NodoAVL(Comparable elem,NodoAVL izquierdo,NodoAVL derecho){
        this.elem=elem;
        this.izquierdo=izquierdo;
        this.derecho=derecho;
    }
    public Comparable getElem(){
        return this.elem;
    }
    public int getAltura(){
        this.recalcularAltura();
        return this.altura;
    }
    public void recalcularAltura(){
        int altIzq,altDer;
        altIzq=recalcularAlturaR(this.izquierdo);
        altDer=recalcularAlturaR(this.derecho);
        if(altIzq>altDer)
            this.altura=altIzq+1;
        else
            this.altura=altDer+1;
    }
    private int recalcularAlturaR(NodoAVL n){
        int altHijo=0,max=-1,temp=0;
        if(n!=null){
            
            if(n.getIzquierdo()!=null){
                altHijo=recalcularAlturaR(n.getIzquierdo())+1;
            }
            if(n.getDerecho()!=null){
                temp=recalcularAlturaR(n.getDerecho())+1;
            }
            if(altHijo>temp)
                max=altHijo;
            else
                max=temp;
        }
        return max;
    }
      
    public NodoAVL getIzquierdo(){
        return this.izquierdo;
    }
    public NodoAVL getDerecho(){
        return this.derecho;
    }
    public void setElemen(Comparable elem){
        this.elem=elem;
    }
    public void setIzquierdo(NodoAVL izquierdo){
        this.izquierdo=izquierdo;
    }
    public void setDerecho(NodoAVL derecho){
        this.derecho=derecho;
    }
}
