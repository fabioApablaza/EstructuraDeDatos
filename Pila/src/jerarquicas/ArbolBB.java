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
            if (this.raiz.getElem().compareTo(elemento) == 0) {
                if(this.raiz.getDerecho()!=null&&this.raiz.getIzquierdo()!=null){
                    MayorDeMenores(this.raiz.getIzquierdo(), this.raiz, this.raiz);
                    exito = true;
                }
                else{
                    if(this.raiz.getDerecho()==null&&this.raiz.getIzquierdo()!=null){
                        this.raiz=raiz.getIzquierdo();
                    }else{
                        if(this.raiz.getDerecho()!=null&&this.raiz.getIzquierdo()==null){
                            this.raiz=raiz.getDerecho();
                        }
                        else{
                            this.raiz=null;
                        }
                    }
                    
                }
                
            } else {
                if (this.raiz.getElem().compareTo(elemento) > 0) {
                    exito = eliminarR(this.raiz.getIzquierdo(), this.raiz, elemento);
                } else {
                    exito = eliminarR(this.raiz.getDerecho(), this.raiz, elemento);
                }
            }
        }
        return exito;
    }

    private boolean eliminarR(NodoArbol n, NodoArbol padre, Comparable elem) {
        boolean exito = false;
        if (n != null) {

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
                        } else {
                            if (n.getIzquierdo() != null && n.getDerecho() == null) {
                                padre.setDerecho(n.getIzquierdo());
                            } else {
                                MayorDeMenores(n.getIzquierdo(), padre, n);

                            }
                        }

                    } else if (n.getIzquierdo() == null && n.getDerecho() != null) {
                        padre.setIzquierdo(n.getDerecho());
                    } else {
                        if (n.getIzquierdo() != null && n.getDerecho() == null) {
                            padre.setIzquierdo(n.getIzquierdo());
                        } else {
                            MayorDeMenores2(n.getIzquierdo(), padre, n);

                        }
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
        return exito;
    }

    private void MayorDeMenores(NodoArbol n, NodoArbol padreE, NodoArbol padreC) {
        //Metodo para buscar el nodo con el elemento mayor entre los menores del subarbol
        //'n' es el candidato, padreE es el padre del nodo que quiero eliminar, y padreC es el padre del candidato
        
        if (n.getDerecho() == null) {//Verifico que mi candidato sea el mayor de los menores
            if (padreE == this.raiz) {
                padreE.setElemen(n.getElem());
            } else {
                padreE.getDerecho().setElemen(n.getElem());//modifico el elemento que quiero eliminar por mi candidato
            }                        
            
            if (padreC == padreE.getDerecho())//Verifico que el padre del candidato no sea el mismo elemento que quiero eliminar
            {
                padreC.setIzquierdo(n.getIzquierdo());//en este caso el candidato es hijo del elemento que quiero eliminar
            } else {
                padreC.setDerecho(n.getIzquierdo());//en este otro caso el candidato no es hijo del que quiero eliminar
            }

        } else {

            MayorDeMenores(n.getDerecho(), padreE, n);
        }
    }

    private void MayorDeMenores2(NodoArbol n, NodoArbol padreE, NodoArbol padreC) {
        //Metodo para buscar el nodo con el elemento mayor entre los menores del subarbol
        //'n' es el candidato, padreE es el padre del nodo que quiero eliminar, y padreC es el padre del candidato
        //System.out.println("MAYOR DE MENORES 2");
        if (n.getDerecho() == null) {//Verifico que mi candidato sea el mayor de los menores            
            padreE.getIzquierdo().setElemen(n.getElem());//modifico el elemento que quiero eliminar por mi candidato
            //System.out.println("Este es el padre del que quiero eliminar "+padreE.getElem());
            //System.out.println("El candidato es "+n.getElem());            
            //System.out.println("Este es el padre de el candidato "+padreC.getElem());
            if (padreC == padreE.getIzquierdo())//Verifico que el padre del candidato no sea el mismo elemento que quiero eliminar
            {
                padreC.setIzquierdo(n.getIzquierdo());//en este caso el candidato es hijo del elemento que quiero eliminar
            } else {
                padreC.setDerecho(n.getIzquierdo());//en este otro caso el candidato no es hijo del que quiero eliminar
            }

        } else {

            MayorDeMenores2(n.getDerecho(), padreE, n);
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

    public ListaComp listarRango(Comparable elemMinimo, Comparable elemMaximo) {
        ListaComp lista = new ListaComp();
        if (!this.esVacio()) {
            listarRangoR(this.raiz, elemMinimo, elemMaximo, lista);
        }
        return lista;
    }

    private void listarRangoR(NodoArbol n, Comparable elemMin, Comparable elemMax, ListaComp lista) {

        if (n != null) {
            System.out.println("Nodos visitados " + n.getElem());
            if (n.getElem().compareTo(elemMin) >= 0 && n.getElem().compareTo(elemMax) <= 0) {//verifica si el nodo esta dentro del rango
                if(n.getElem().compareTo(elemMin) > 0 && n.getElem().compareTo(elemMax) < 0){//
                    listarRangoR(n.getIzquierdo(), elemMin, elemMax, lista);
                    lista.insertar(n.getElem(), lista.longitud()+1);
                    listarRangoR(n.getDerecho(), elemMin, elemMax, lista);
                }
                else{
                    if(n.getElem().compareTo(elemMin)==0){
                        lista.insertar(n.getElem(), lista.longitud()+1);
                        listarRangoR(n.getDerecho(), elemMin, elemMax, lista);
                    }
                    else{
                        listarRangoR(n.getIzquierdo(), elemMin, elemMax, lista);    
                        lista.insertar(n.getElem(), lista.longitud()+1);                                            
                    }                        
                }
            } else {
                if (n.getElem().compareTo(elemMax) > 0) {
                    //System.out.println("elementos mayores a " + elemMax + " " + n.getElem());
                    listarRangoR(n.getIzquierdo(), elemMin, elemMax, lista);
                } else {

                    //System.out.println("elementos menores a " + elemMin + " " + n.getElem());
                    listarRangoR(n.getDerecho(), elemMin, elemMax, lista);

                }
            }
        }
    }

    //SIMULACRO
    public void eliminarMinimo() {
        if (!this.esVacio()) {
            if (this.raiz.getIzquierdo() == null) {
                this.raiz = this.raiz.getDerecho();
            } else {
                eliminarMinimoR(this.raiz, this.raiz.getIzquierdo());
            }
        }
    }

    private void eliminarMinimoR(NodoArbol p, NodoArbol n) {
        if (n != null) {
            if (n.getIzquierdo() == null) {
                p.setIzquierdo(n.getDerecho());
            } else {
                eliminarMinimoR(n, n.getIzquierdo());
            }
        }
    }

    public ArbolBB clonarParteInvertida(Comparable elem) {
        ArbolBB clon = new ArbolBB();
        NodoArbol nodo = null;
        if (!this.esVacio()) {
            nodo = obtenerNodo(this.raiz, elem);
            if (nodo != null) {
                clon.raiz = clonarParteInvertidaR(nodo);
            }
        }
        return clon;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Comparable elem) {
        NodoArbol res;

        if (n.getElem().compareTo(elem) == 0) {
            res = n;
        } else {
            if (n.getElem().compareTo(elem) > 0) {
                res = obtenerNodo(n.getIzquierdo(), elem);
            } else {
                res = obtenerNodo(n.getDerecho(), elem);
            }
        }
        return res;
    }

    private NodoArbol clonarParteInvertidaR(NodoArbol n) {
        NodoArbol nodo = null;
        if (n != null) {
            nodo = new NodoArbol(n.getElem(), clonarParteInvertidaR(n.getDerecho()), clonarParteInvertidaR(n.getIzquierdo()));
        }
        return nodo;
    }

    public ListaComp listarMayorIgual(Comparable elem) {
        ListaComp l1 = new ListaComp();
        NodoArbol nodo;
        if (!this.esVacio()) {
            nodo = obtenerNodo(this.raiz, elem);
            if (nodo != null) {
                listarMayorIgualR(nodo.getDerecho(), l1);
                l1.insertar(nodo.getElem(), l1.longitud() + 1);
            }
        }
        return l1;
    }

    private void listarMayorIgualR(NodoArbol n, ListaComp l1) {
        if (n != null) {
            //System.out.println(n.getElem());
            listarMayorIgualR(n.getDerecho(), l1);
            l1.insertar(n.getElem(), l1.longitud() + 1);
            listarMayorIgualR(n.getIzquierdo(), l1);
        }
    }

    public ListaComp listarMenores(Comparable elem) {
        ListaComp l1 = new ListaComp();
        NodoArbol nodo;
        if (!this.esVacio()) {
            nodo = obtenerNodo(this.raiz, elem);
            if (nodo != null) {
                listarMenoresR(nodo.getIzquierdo(), l1);
            }
        }
        return l1;
    }

    private void listarMenoresR(NodoArbol n, ListaComp l1) {
        if (n != null) {

            listarMenoresR(n.getIzquierdo(), l1);
            l1.insertar(n.getElem(), l1.longitud() + 1);
            listarMenoresR(n.getDerecho(), l1);
        }
    }

    //FIN DEL SIMULACRO
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

    @Override
    public String toString() {
        String arbol = "";

        if (this.raiz != null) {
            arbol += toStringAux(this.raiz);
        } else {
            arbol = "Arbol vacio";
        }

        return arbol;
    }

    private String toStringAux(NodoArbol nodo) {
        String listado = "";

        if (nodo != null) {
            listado += "Padre: " + nodo.getElem();
            listado += "\n";
            if (nodo.getIzquierdo() != null) {
                listado += "Hijo izquierdo: " + nodo.getIzquierdo().getElem() + " ";
            } else {
                listado += "Hijo izquierdo: No tiene ";
            }
            if (nodo.getDerecho() != null) {
                listado += "Hijo derecho: " + nodo.getDerecho().getElem() + " ";
            } else {
                listado += " Hijo derecho: No tiene ";
            }

            listado += "\n";
            listado += toStringAux(nodo.getIzquierdo());
            listado += toStringAux(nodo.getDerecho());
        }
        return listado;
    }

}
