package jerarquicas;

public class ArbolBB {

    private NodoArbol raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public ArbolBB(NodoArbol nodo) {
        this.raiz = nodo;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoArbol(elemento);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoArbol n, Comparable elemento) {
        //precondicion:n no es nulo
        boolean exito = true;
        if (((elemento.compareTo(n.getElem()) == 0))) // Reportar error: Elemento repetido
        {
            exito = false;
        } else {
            if (elemento.compareTo(n.getElem()) < 0) {
                //elemento es menor que n.getElem()
                //si tiene HI baja a la izquierda, sino agrega elemento
                if (n.getIzquierdo() != null) {
                    exito = insertarAux(n.getIzquierdo(), elemento);
                } else {
                    n.setIzquierdo(new NodoArbol(elemento));
                }
            } else {
                //elemento es mayor que n.getElem()
                //si tiene HD baja a la derecha, sino agrega elemento
                if (n.getDerecho() != null) {
                    exito = insertarAux(n.getDerecho(), elemento);
                } else {
                    n.setDerecho(new NodoArbol(elemento));
                }
            }
        }
        return exito;
    }

    public boolean pertenece(Comparable elemento) {
        boolean res = false;
        if (this.raiz != null) {
            res = perteneceR(this.raiz, elemento);
        }
        return res;
    }

    private boolean perteneceR(NodoArbol n, Comparable elem) {
        boolean exito = false;
        if (n != null) {
            if (n.getElem().compareTo(elem) == 0) {
                exito = true;
            } else {
                if (n.getElem().compareTo(elem) > 0) {
                    exito = perteneceR(n.getIzquierdo(), elem);
                } else {
                    exito = perteneceR(n.getDerecho(), elem);
                }
            }
        }
        return exito;
    }

    public boolean esVacio() {
        boolean exito = true;
        if (this.raiz != null) {
            exito = false;
        }
        return exito;
    }

    public boolean eliminar(Comparable elemento) {
        boolean exito;
        if (this.raiz.getElem().compareTo(elemento) < 0) {
            exito = eliminarR(this.raiz.getIzquierdo(), this.raiz, elemento);
        } else {
            exito = eliminarR(this.raiz.getDerecho(), this.raiz, elemento);
        }
        return exito;
    }

    private boolean eliminarR(NodoArbol n, NodoArbol padre, Comparable elem) {
        boolean exito = false;
        if (n != null) {
            if (!exito) {
                if (n.getElem().compareTo(elem) == 0) {
                    if (n.getDerecho() == null && n.getIzquierdo() == null) {
                        if (padre.getDerecho() == n) {
                            padre.setDerecho(null);
                        } else {
                            padre.setIzquierdo(null);
                        }
                    } else {
                        if (n.getElem().compareTo(padre.getElem()) > 0) {
                            if (n.getIzquierdo() == null && n.getDerecho() != null) {
                                padre.setDerecho(n.getDerecho());
                            }
                            if (n.getIzquierdo() != null && n.getDerecho() == null) {
                                padre.setDerecho(n.getIzquierdo());
                            }
                            if (n.getIzquierdo() != null && n.getDerecho() != null) {
                                MayorDeMenores(n,padre);
                            }
                        }
                    }

                } else {
                    if (n.getElem().compareTo(elem) > 0) {

                    }
                }
            }
        }
        return exito;
    }
    private void MayorDeMenores(NodoArbol n,NodoArbol padre){
        NodoArbol nodo=n.getIzquierdo();
        if(n.getDerecho()!=null)
    }

    public ListaComp listar() {
        ListaComp lista = new ListaComp();
        if (this.raiz != null) {
            listarRec(this.raiz, lista);
        }
        return lista;
    }

    private void listarRec(NodoArbol n, ListaComp ls) {
        if (n != null) {
            listarRec(n.getIzquierdo(), ls);
            ls.insertar(n.getElem(), ls.longitud() + 1);
            listarRec(n.getDerecho(), ls);
        }

    }

    public Comparable minimoElem() {
        Comparable elem = null;
        if (this.raiz != null) {
            elem = minimoElemR(this.raiz);
        }
        return elem;
    }

    private Comparable minimoElemR(NodoArbol n) {
        Comparable elem = null;
        if (n != null) {
            if (n.getIzquierdo() == null) {
                elem = n.getElem();
            } else {
                elem = minimoElemR(n.getIzquierdo());
            }
        }
        return elem;

    }

    public Comparable maximoElem() {
        Comparable elem = null;
        if (this.raiz != null) {
            elem = maximoElemR(this.raiz);
        }
        return elem;
    }

    private Comparable maximoElemR(NodoArbol n) {
        Comparable elem = null;
        if (n != null) {
            if (n.getDerecho() == null) {
                elem = n.getElem();
            } else {
                elem = maximoElemR(n.getDerecho());
            }
        }
        return elem;

    }

}
