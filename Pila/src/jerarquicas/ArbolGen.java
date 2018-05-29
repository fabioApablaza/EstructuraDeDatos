package jerarquicas;

public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object ElemPadre) {
        // "elemNuevo" es el elemento y ElemPadre el padre del elemento
        boolean exito;
        if (this.raiz == null) {
            this.raiz = new NodoGen(elemNuevo);
            exito = true;
        } else {
            NodoGen nodoPadre = obtenerNodo(this.raiz, ElemPadre);
            if (nodoPadre != null) {
                if (nodoPadre.getHijoIzquierdo() == null) {
                    nodoPadre.setHijoIzquierdo(new NodoGen(elemNuevo));
                    exito = true;
                } else {
                    nodoPadre = nodoPadre.getHijoIzquierdo();
                    while (nodoPadre.getHermanoDerecho() != null) {
                        nodoPadre = nodoPadre.getHermanoDerecho();
                    }
                    nodoPadre.setHermanoDerecho(new NodoGen(elemNuevo));
                    exito = true;
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoGen obtenerNodo(NodoGen n, Object buscado) {
        NodoGen resultado = null, h = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                resultado = n;
            } else {
                h = n.getHijoIzquierdo();
                while (h != null && resultado == null) {
                    resultado = obtenerNodo(h, buscado);
                    h = h.getHermanoDerecho();
                }
            }
        }
        return resultado;
    }

    public boolean pertenece(Object elemento) {
        boolean exito = false;
        NodoGen n = obtenerNodo(this.raiz, elemento);
        if (n != null) {
            exito = true;
        }
        return exito;
    }

    public Lista listarPosorden() {
        Lista ls = new Lista();
        listarPosordenAux(this.raiz, ls);
        return ls;
    }

    private void listarPosordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            if (n.getHijoIzquierdo() != null) {
                listarPosordenAux(n.getHijoIzquierdo(), ls);
            }
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null && ls.esVacia()) {
                    listarPosordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }

            }
            ls.insertar(n.getElem(), ls.longitud() + 1);
        }
    }

    public Lista listarInorden() {
        Lista salida = new Lista();
        listarInordenAux(this.raiz, salida);
        return salida;
    }

    private void listarInordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            if (n.getHijoIzquierdo() != null) {
                listarInordenAux(n.getHijoIzquierdo(), ls);
            }
            ls.insertar(n.getElem(), ls.longitud() + 1);
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarPreorden() {
        Lista ls = new Lista();
        listarPreordenAux(this.raiz, ls);
        return ls;
    }

    private void listarPreordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            ls.insertar(n.getElem(), ls.longitud() + 1);
            if (n.getHijoIzquierdo() != null) {
                listarPreordenAux(n.getHijoIzquierdo(), ls);
            }
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarPreordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarPorNiveles() {
        Lista ls = new Lista();
        ColaNodo cl = new ColaNodo();
        cl.poner(this.raiz);
        while (!cl.esVacia()) {
            NodoGen nodo = cl.obtenerFrente();
            cl.sacar();

            ls.insertar(nodo.getElem(), ls.longitud() + 1);

            NodoGen hijo = nodo.getHijoIzquierdo();

            while (hijo != null) {
                cl.poner(hijo);
                hijo = hijo.getHermanoDerecho();
            }

        }
        return ls;
    }

    public Lista ancestros(Object elem) {
        Lista ls = new Lista();

        if (this.raiz != null) {
            ancestrosRec(this.raiz, elem, ls);
        }
        ls.eliminar(ls.longitud());
        return ls;
    }

    private void ancestrosRec(NodoGen n, Object elem, Lista ls) {
        if (n != null) {

            if (n.getHijoIzquierdo() != null) {
                ancestrosRec(n.getHijoIzquierdo(), elem, ls);
            }
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null && ls.esVacia()) {
                    ancestrosRec(hijo, elem, ls);
                    hijo = hijo.getHermanoDerecho();
                }

            }
            if (n.getElem().equals(elem) || !ls.esVacia()) {
                ls.insertar(n.getElem(), 1);
            }
        }
    }

    public int altura() {

        return alturaRec(this.raiz);
    }

    private int alturaRec(NodoGen n) {
        int max = -1;
        int altHijo = 0;
        if (n != null) {
            max = altHijo;
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                altHijo = alturaRec(hijo) + 1;
                if (altHijo > max) {
                    max = altHijo;
                }
                hijo = hijo.getHermanoDerecho();
            }

        }

        return max;
    }

    public int nivel(Object elemento) {

        return nivelRec(this.raiz, elemento);
    }

    private int nivelRec(NodoGen n, Object elemento) {
        int nivel = -1;
        NodoGen hijo;
        if (n != null) {
            if (n.getElem().equals(elemento)) {
                nivel = 0;
            } else {
                hijo = n.getHijoIzquierdo();
                while (hijo != null && nivel == -1) {
                    nivel = nivelRec(hijo, elemento);
                    hijo = hijo.getHermanoDerecho();
                }
                if (nivel != -1) {
                    nivel++;
                }
            }

        }
        return nivel;
    }

    public Object padre(Object elemento) {
        Object resultado = "No existe";
        NodoGen res;
        if (this.raiz != null) {
            res = padreRec(this.raiz, elemento);
            if(res!=null)
                resultado = res.getElem();
        }
        return resultado;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
    }

    private NodoGen padreRec(NodoGen n, Object elem) {
        NodoGen resultado = null;
        if (n != null) {
            if (n.getElem().equals(elem)) {
                resultado = n;
            } else {
                NodoGen hijo = n.getHijoIzquierdo();
                while (hijo != null && resultado == null) {
                    resultado = padreRec(hijo, elem);
                    if (resultado != null && resultado.getElem().equals(elem)) {
                        resultado = n;
                    }
                    hijo = hijo.getHermanoDerecho();
                }
            }

        }
        return resultado;
    }

    public void vaciar() {
        raiz = null;
    }

    public boolean esVacio() {
        boolean resp = true;
        if (this.raiz != null) {
            resp = false;
        }
        return resp;
    }

    public ArbolGen clonar() {
        ArbolGen clon = new ArbolGen();
        if (this.raiz != null) {
            clon.raiz = clonarRec(this.raiz);
        }
        return clon;
    }

    private NodoGen clonarRec(NodoGen n) {
        NodoGen nodo = null;
        if (n != null) {
            nodo = new NodoGen(n.getElem(), clonarRec(n.getHijoIzquierdo()), clonarRec(n.getHermanoDerecho()));
        }
        return nodo;
    }

    @Override
    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n) {
        String s = "";
        if (n != null) {
            s += n.getElem().toString() + " -> ";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }
}
