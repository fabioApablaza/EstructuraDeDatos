package lineales.estaticas;

public class PilaInt {

    private int[] pila;
    private int tope;
    private static final int T = 5;

    public PilaInt() {
        this.pila = new int[T];
        this.tope = -1;
    }

    public boolean apilar(int nuevoElem) {
        boolean exito;
        if (this.tope + 1 >= this.T) {
            exito = false;
        } else {
            this.tope++;
            this.pila[tope] = nuevoElem;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        boolean exito;
        if (this.tope == -1) {
            exito = false;
        } else {

            this.tope--;
            exito = true;
        }
        return exito;
    }

    public int obtenerTope() {
        int elemento;
        if (this.tope == -1) {
            elemento = Integer.MIN_VALUE;
        } else {
            elemento = this.pila[tope];
        }

        return elemento;
    }

    public boolean esVacia() {
        boolean exito;
        if (this.tope == -1) {
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    public void vaciar() {
        this.tope = -1;
    }

    public PilaInt clonar() {
        PilaInt clon = new PilaInt() ;
       
       for(int i=0;i<=this.tope;i++){
           clon.apilar(this.pila[i]);
       }
        
        return clon;
    }

    @Override
    public String toString() {
        String cadena = "";
        if (!esVacia()) {
            for (int i = 0; i <= this.tope; i++) {
                cadena = cadena + this.pila[i];
            }
            
        }else{
            cadena="pila vacia";
        }
        return cadena;
    }

}
