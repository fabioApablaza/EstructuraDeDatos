
package jerarquicas;


public class NodoObject {
    private Object elem;
    private NodoObject enlace;
    public NodoObject(Object elem, NodoObject enlace){
        this.elem = elem;
        this.enlace= enlace;
    }
    public NodoObject(Object elemN){
        this.elem=elemN;
        this.enlace=null;
    }
    public Object getElem(){
        return elem;
    }
    public void setElem(Object elem){
        this.elem=elem;
    }
    public NodoObject getEnlace(){
        return enlace;
    }
    public void setEnlace(NodoObject enlaceN){
        this.enlace=enlaceN;
    }
}
