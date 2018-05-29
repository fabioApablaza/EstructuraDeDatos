package jerarquicas;


public class NodoComp {
    private Comparable elem;
    private NodoComp enlace;
    public NodoComp(Comparable elem, NodoComp enlace){
        this.elem = elem;
        this.enlace= enlace;
    }
    public NodoComp(Comparable elemN){
        this.elem=elemN;
        this.enlace=null;
    }
    public Comparable getElem(){
        return elem;
    }
    public void setElem(Comparable elem){
        this.elem=elem;
    }
    public NodoComp getEnlace(){
        return enlace;
    }
    public void setEnlace(NodoComp enlaceN){
        this.enlace=enlaceN;
    }
}
