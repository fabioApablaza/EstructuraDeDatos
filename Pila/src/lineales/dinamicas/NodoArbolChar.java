package lineales.dinamicas;


public class NodoArbolChar {
    private char elem;
    private NodoArbolChar izquierdo;
    private NodoArbolChar derecho;
    public NodoArbolChar(char elem){
        this.elem=elem;
        this.izquierdo=null;
        this.derecho=null;
    }
    public NodoArbolChar(char elem,NodoArbolChar izquierdo,NodoArbolChar derecho){
        this.elem=elem;
        this.izquierdo=izquierdo;
        this.derecho=derecho;
    }
    public char getElem(){
        return this.elem;
    }
    public NodoArbolChar getIzquierdo(){
        return this.izquierdo;
    }
    public NodoArbolChar getDerecho(){
        return this.derecho;
    }
    public void setElemen(char elem){
        this.elem=elem;
    }
    public void setIzquierdo(NodoArbolChar izquierdo){
        this.izquierdo=izquierdo;
    }
    public void setDerecho(NodoArbolChar derecho){
        this.derecho=derecho;
    }
}