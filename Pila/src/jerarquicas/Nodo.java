
package jerarquicas;

public class Nodo {
    private NodoGen elem;
    private Nodo enlace;
    public Nodo(NodoGen elem, Nodo enlace){
        this.elem = elem;
        this.enlace= enlace;
    }
    public Nodo(NodoGen elemN){
        this.elem=elemN;
        this.enlace=null;
    }
    public NodoGen getElem(){
        return elem;
    }
    public void setElem(NodoGen elem){
        this.elem=elem;
    }
    public Nodo getEnlace(){
        return enlace;
    }
    public void setEnlace(Nodo enlaceN){
        this.enlace=enlaceN;
    }
}
