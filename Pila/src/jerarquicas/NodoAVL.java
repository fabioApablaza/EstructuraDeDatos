
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
        
        return this.altura;
    }
    public void recalcularAltura(){
        int altIzq,altDer;
        if(this.izquierdo!=null)
            altIzq=this.izquierdo.getAltura();
        else
            altIzq=-1;
        if(this.derecho!=null)
            altDer=this.derecho.getAltura();
        else
            altDer=-1;
        this.altura=Math.max(altIzq, altDer)+1;
    }
    public int getBalance(){        
        int altIzq,altDer;
        if(this.izquierdo!=null)
            altIzq=this.izquierdo.getAltura();
        else
            altIzq=-1;
        if(this.derecho!=null)
            altDer=this.derecho.getAltura();
        else
            altDer=-1;
        return (altIzq-altDer);
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
        if(izquierdo!=null){
            izquierdo.recalcularAltura();
        }
        this.recalcularAltura();
        
    }
    public void setDerecho(NodoAVL derecho){
        this.derecho=derecho;
        if(derecho!=null){
            derecho.recalcularAltura();
        }
        this.recalcularAltura();
        
    }
}
