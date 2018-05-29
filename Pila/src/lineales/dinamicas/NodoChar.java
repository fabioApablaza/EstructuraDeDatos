package lineales.dinamicas;




public class NodoChar {
    private char elem;
    private NodoChar enlace;
    public NodoChar(char elem, NodoChar enlace){
        this.elem = elem;
        this.enlace= enlace;
    }
    public NodoChar(char elemN){
        this.elem=elemN;
        this.enlace=null;
    }
    public char getElem(){
        return elem;
    }
    public void setElem(char elem){
        this.elem=elem;
    }
    public NodoChar getEnlace(){
        return enlace;
    }
    public void setEnlace(NodoChar enlaceN){
        this.enlace=enlaceN;
    }
}
