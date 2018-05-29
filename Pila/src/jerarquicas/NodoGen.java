
package jerarquicas;


public class NodoGen {
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    public NodoGen(Object elemento){
        this.elem=elemento;
        this.hermanoDerecho=null;
        this.hijoIzquierdo=null;
    }
    public NodoGen(Object elemento ,NodoGen hijoIzq ,NodoGen hermanoDer){
        this.elem=elemento;
        this.hijoIzquierdo=hijoIzq;
        this.hermanoDerecho=hermanoDer;
    }
    public Object getElem(){
        return elem;
    }
    public NodoGen getHijoIzquierdo(){
        return hijoIzquierdo;
    }
    public NodoGen getHermanoDerecho(){
        return hermanoDerecho;
    }
    public void setElem(Object elemento){
        this.elem=elemento;
    }
    public void setHijoIzquierdo(NodoGen hijoIzq){
        this.hijoIzquierdo=hijoIzq;
    }
    public void setHermanoDerecho(NodoGen hermanoDer){
        this.hermanoDerecho=hermanoDer;
    }
    
}
