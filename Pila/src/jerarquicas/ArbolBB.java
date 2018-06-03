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
        boolean exito = false;
        if (!this.esVacio()) {

            if (this.raiz.getElem().compareTo(elemento) > 0) {
                exito = eliminarR(this.raiz.getIzquierdo(), this.raiz, elemento);
            } else {
                exito = eliminarR(this.raiz.getDerecho(), this.raiz, elemento);
            }
        } else {
            MayorDeMenores(this.raiz.getIzquierdo(), this.raiz);

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
                                MayorDeMenores(n.getIzquierdo(), padre);
                                
                            }
                        }
                        else
                            if (n.getIzquierdo() == null && n.getDerecho() != null) {
                                padre.setIzquierdo(n.getDerecho());
                            }
                            if (n.getIzquierdo() != null && n.getDerecho() == null) {
                                padre.setIzquierdo(n.getIzquierdo());
                            }
                            if (n.getIzquierdo() != null && n.getDerecho() != null) {
                                MayorDeMenores(n.getIzquierdo(), padre);
                                
                            }
                    }

                } else {
                    if (n.getElem().compareTo(elem) > 0) {
                        exito = eliminarR(n.getIzquierdo(), n, elem);
                    } else {
                        exito = eliminarR(n.getDerecho(), n, elem);
                    }
                }
            }
        }
        return exito;
    }

    private void MayorDeMenores(NodoArbol n, NodoArbol padre) {
        //Metodo para buscar el nodo con el elemento mayor entre los menores del subarbol
        NodoArbol aux;
        if (n.getDerecho() == null) {
            
            padre.getDerecho().setElemen(n.getElem());
            System.out.println(padre.getDerecho().getElem());
            aux=padre(n.getElem());
            if (n.getIzquierdo() == null) {
                aux.setDerecho(null);
                
            } else {
                aux.setDerecho(n.getIzquierdo());
            }

        } else {

            MayorDeMenores(n.getDerecho(), padre);
        }
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

    public void preOrden() {
        if (!this.esVacio()) {
            preOrdenR(this.raiz);
        }
    }

    private void preOrdenR(NodoArbol n) {
        if (n != null) {
            System.out.print(n.getElem() + " ");
            preOrdenR(n.getIzquierdo());
            preOrdenR(n.getDerecho());
        }
    }

    private NodoArbol padre(Comparable elem) {
        NodoArbol padre = null;
        if (!this.esVacio() && this.raiz.getElem().compareTo(elem) != 0) {
            padre = padreR(this.raiz, elem);
        }
        return padre;
    }

    private NodoArbol padreR(NodoArbol n, Comparable elem) {
        NodoArbol nodo = null;
        if (n != null) {
            if (n.getElem().compareTo(elem) == 0) {
                nodo = n;
            } else {
                if (n.getElem().compareTo(elem) < 0) {
                    nodo = padreR(n.getDerecho(), elem);
                } else {
                    nodo = padreR(n.getIzquierdo(), elem);
                }

            }
            if (nodo != null && nodo.getElem().equals(elem)) {
                nodo = n;
            }
        }
        return nodo;
    }

}
