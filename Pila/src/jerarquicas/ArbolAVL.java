package jerarquicas;

public class ArbolAVL {

    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public ArbolAVL(NodoAVL nodo) {
        this.raiz = nodo;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoAVL(elemento);
        } else {
            exito = insertarAux(this.raiz, this.raiz, elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoAVL n, NodoAVL p, Comparable elemento) {
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
                    exito = insertarAux(n.getIzquierdo(), n, elemento);
                } else {
                    n.setIzquierdo(new NodoAVL(elemento));
                }
            } else {
                //elemento es mayor que n.getElem()
                //si tiene HD baja a la derecha, sino agrega elemento
                if (n.getDerecho() != null) {
                    exito = insertarAux(n.getDerecho(), n, elemento);
                } else {
                    n.setDerecho(new NodoAVL(elemento));
                }
            }

        }
        n.recalcularAltura();
        
        balanceo(n,p);
        

        return exito;
    }
    private void balanceo (NodoAVL n,NodoAVL p){
        //El nodo "p" es padre del nodo "n"
        if (n.getBalance() == 2 || n.getBalance() == -2) {
            if (n.getBalance() == 2) {//el balance es positivo
                if (n.getIzquierdo().getBalance() >= 0) {//si el balance del nodo es positivo miro el balance del hijo izquierdo
                    //si es positivo el balance la rotacion es simple
                    if (n == raiz) {//miro si la rotacion se debe hacer con la raiz
                        this.raiz = rotarDerecha(this.raiz);
                        this.raiz.recalcularAltura();
                    } else {
                        p.setIzquierdo(rotarDerecha(n));
                    }
                } else {//el signo del balance del hijo es distinto al signo del balance del padre entonces la rotacion es doble
                    if (n == raiz) {//miro si la rotacion se debe hacer con la raiz
                        n.setIzquierdo(rotarIzquierda(n.getIzquierdo()));
                        
                        this.raiz = rotarDerecha(n);
                        this.raiz.recalcularAltura();
                    } else {//entonces la rotacion no es sobre la raiz
                        if(p.getIzquierdo()==n){
                            n.setIzquierdo(rotarIzquierda(n.getIzquierdo()));
                            p.setIzquierdo(rotarDerecha(n));
                        }
                        else{
                            n.setIzquierdo(rotarIzquierda(n.getIzquierdo()));
                            p.setDerecho(rotarDerecha(n));
                        }
                    }

                }
            } else {//Entonces el balance es negativo
                if (n.getDerecho().getBalance() <= 0) {//si es negativo e balance miro el balance de su hijo derecho
                    if (n == raiz) {//miro si la rotacion se debe hacer con la raiz
                        this.raiz = rotarIzquierda(this.raiz);
                        this.raiz.recalcularAltura();
                    } else {//entonces la rotacion no es sobre la raiz
                        p.setDerecho(rotarIzquierda(n));
                    }
                } else {//el signo del balance del hijo es distinto al signo del balance del padre entonces la rotacion es doble
                    if (n == raiz) {//miro si la rotacion se debe hacer con la raiz
                        n.setDerecho(rotarDerecha(n.getDerecho()));
                        
                        this.raiz = (rotarIzquierda(n));
                        this.raiz.recalcularAltura();
                    } else {//entonces la rotacion no es sobre la raiz
                        if(p.getIzquierdo()==n){
                            n.setDerecho(rotarDerecha(n.getDerecho()));
                            p.setIzquierdo(rotarIzquierda(n));
                        }
                        else{
                            n.setDerecho(rotarDerecha(n.getDerecho()));
                            p.setDerecho(rotarIzquierda(n));
                        }
                    }
                }
            }
            
        }
        
        
    }

    private NodoAVL rotarDerecha(NodoAVL n) {
        NodoAVL h, temp;
        h = n.getIzquierdo();
        temp = h.getDerecho();
        h.setDerecho(n);
        n.setIzquierdo(temp);
        
        return h;
    }

    private NodoAVL rotarIzquierda(NodoAVL n) {
        NodoAVL h, temp;
        h = n.getDerecho();
        temp = h.getIzquierdo();
        h.setIzquierdo(n);
        n.setDerecho(temp);
        
        return h;
    }

    public boolean pertenece(Comparable elemento) {
        boolean res = false;
        if (this.raiz != null) {
            res = perteneceR(this.raiz, elemento);
        }
        return res;
    }

    private boolean perteneceR(NodoAVL n, Comparable elem) {
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
                if (this.raiz.getDerecho() != null && this.raiz.getIzquierdo() != null) {
                    MayorDeMenores(this.raiz.getIzquierdo(), this.raiz, this.raiz);
                    exito = true;
                } else {
                    if (this.raiz.getDerecho() == null && this.raiz.getIzquierdo() != null) {
                        this.raiz = raiz.getIzquierdo();
                        
                    } else {
                        if (this.raiz.getDerecho() != null && this.raiz.getIzquierdo() == null) {
                            this.raiz = raiz.getDerecho();
                        } else {
                            this.raiz = null;
                        }
                    }

                }
                this.raiz.recalcularAltura();
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

    private boolean eliminarR(NodoAVL n, NodoAVL padre, Comparable elem) {
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
            padre.recalcularAltura();
            n.recalcularAltura();
            balanceo(padre,n);
            
            
        }
        return exito;
    }
    
    private void MayorDeMenores(NodoAVL n, NodoAVL padreE, NodoAVL padreC) {
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

    private void MayorDeMenores2(NodoAVL n, NodoAVL padreE, NodoAVL padreC) {
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

    private void listarRec(NodoAVL n, ListaComp ls) {
        if (n != null) {
            listarRec(n.getIzquierdo(), ls);
            ls.insertar(n.getElem(), ls.longitud() + 1);
            listarRec(n.getDerecho(), ls);
        }

    }

    public ListaComp listarRango2(Comparable elemMinimo, Comparable elemMaximo) {
        ListaComp lista = new ListaComp();
        if (!this.esVacio()) {
            listarRangoR2(this.raiz, elemMinimo, elemMaximo, lista);
        }
        return lista;
    }

    private void listarRangoR2(NodoAVL n, Comparable elemMin, Comparable elemMax, ListaComp lista) {
        //Mejorado
        if (n != null) {
            System.out.println("Nodos visitados " + n.getElem());
            if (n.getElem().compareTo(elemMax) < 0) {
                listarRangoR2(n.getDerecho(), elemMin, elemMax, lista);
            }
            if (n.getElem().compareTo(elemMin) >= 0 && n.getElem().compareTo(elemMax) <= 0) {
                lista.insertar(n.getElem(), 1);
            }

            if (n.getElem().compareTo(elemMin) > 0) {
                listarRangoR2(n.getIzquierdo(), elemMin, elemMax, lista);
            }
        }
    }

    public ListaComp listarRango(Comparable elemMinimo, Comparable elemMaximo) {
        ListaComp lista = new ListaComp();
        if (!this.esVacio()) {
            listarRangoR(this.raiz, elemMinimo, elemMaximo, lista);
        }
        return lista;
    }

    private void listarRangoR(NodoAVL n, Comparable elemMin, Comparable elemMax, ListaComp lista) {

        if (n != null) {
            System.out.println("Nodos visitados " + n.getElem());
            if (n.getElem().compareTo(elemMin) >= 0 && n.getElem().compareTo(elemMax) <= 0) {//verifica si el nodo esta dentro del rango
                if (n.getElem().compareTo(elemMin) > 0 && n.getElem().compareTo(elemMax) < 0) {//
                    listarRangoR(n.getIzquierdo(), elemMin, elemMax, lista);
                    lista.insertar(n.getElem(), lista.longitud() + 1);
                    listarRangoR(n.getDerecho(), elemMin, elemMax, lista);
                } else {
                    if (n.getElem().compareTo(elemMin) == 0) {
                        lista.insertar(n.getElem(), lista.longitud() + 1);
                        listarRangoR(n.getDerecho(), elemMin, elemMax, lista);
                    } else {
                        listarRangoR(n.getIzquierdo(), elemMin, elemMax, lista);
                        lista.insertar(n.getElem(), lista.longitud() + 1);
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
    public boolean elim(Comparable elem) {
        boolean res = false;

        if (this.raiz != null) {
            if (this.raiz.getElem().compareTo(elem) > 0) {
                res = elimR(this.raiz, this.raiz.getIzquierdo(), elem);
            } else {
                res = elimR(this.raiz, this.raiz.getDerecho(), elem);
            }
        }
        return res;

    }

    private boolean elimR(NodoAVL p, NodoAVL n, Comparable elem) {
        boolean exito = false;
        if (n != null) {
            if (n.getElem().compareTo(elem) == 0) {

            } else {
                if (n.getElem().compareTo(elem) > 0) {
                    exito = elimR(this.raiz, this.raiz.getIzquierdo(), elem);
                } else {
                    exito = elimR(this.raiz, this.raiz.getDerecho(), elem);
                }
            }
        }

        return exito;
    }

    public void eliminarMinimo() {
        if (!this.esVacio()) {
            if (this.raiz.getIzquierdo() == null) {
                this.raiz = this.raiz.getDerecho();
            } else {
                eliminarMinimoR(this.raiz, this.raiz.getIzquierdo());
            }
        }
    }

    private void eliminarMinimoR(NodoAVL p, NodoAVL n) {
        if (n != null) {
            if (n.getIzquierdo() == null) {
                p.setIzquierdo(n.getDerecho());
            } else {
                eliminarMinimoR(n, n.getIzquierdo());
            }
        }
    }

    public ArbolAVL clonarParteInvertida(Comparable elem) {
        ArbolAVL clon = new ArbolAVL();
        NodoAVL nodo = null;
        if (!this.esVacio()) {
            nodo = obtenerNodo(this.raiz, elem);
            if (nodo != null) {
                clon.raiz = clonarParteInvertidaR(nodo);
            }
        }
        return clon;
    }

    private NodoAVL obtenerNodo(NodoAVL n, Comparable elem) {
        NodoAVL res;

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

    private NodoAVL clonarParteInvertidaR(NodoAVL n) {
        NodoAVL nodo = null;
        if (n != null) {
            nodo = new NodoAVL(n.getElem(), clonarParteInvertidaR(n.getDerecho()), clonarParteInvertidaR(n.getIzquierdo()));
        }
        return nodo;
    }

    public ListaComp listarMayorIgual(Comparable elem) {
        ListaComp l1 = new ListaComp();

        if (!this.esVacio()) {
            listarMayorIgualR(this.raiz, l1, elem);

        }
        return l1;
    }

    private void listarMayorIgualR(NodoAVL n, ListaComp l1, Comparable elem) {
        if (n != null) {
            System.out.println(n.getElem());
            if (n.getElem().compareTo(elem) > 0) {
                listarMayorIgualR(n.getDerecho(), l1, elem);
                l1.insertar(n.getElem(), l1.longitud() + 1);
                listarMayorIgualR(n.getIzquierdo(), l1, elem);

            } else {
                listarMayorIgualR(n.getDerecho(), l1, elem);
            }
            if (n.getElem().compareTo(elem) == 0) {
                l1.insertar(n.getElem(), l1.longitud() + 1);
            }
        }
    }

    public ListaComp listarMenores(Comparable elem) {
        ListaComp l1 = new ListaComp();

        if (!this.esVacio()) {
            listarMenoresR(this.raiz, l1, elem);

        }
        return l1;
    }

    private void listarMenoresR(NodoAVL n, ListaComp l1, Comparable elem) {
        if (n != null) {
            System.out.println(n.getElem());
            if (n.getElem().compareTo(elem) < 0) {

                listarMenoresR(n.getIzquierdo(), l1, elem);
                l1.insertar(n.getElem(), l1.longitud() + 1);
                listarMenoresR(n.getDerecho(), l1, elem);
            } else {
                listarMenoresR(n.getIzquierdo(), l1, elem);
            }
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

    private Comparable minimoElemR(NodoAVL n) {
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

    private Comparable maximoElemR(NodoAVL n) {
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

    private void preOrdenR(NodoAVL n) {
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

    private String toStringAux(NodoAVL nodo) {
        String listado = "";

        if (nodo != null) {
            listado += "Padre: " + nodo.getElem()+" Altura: "+nodo.getAltura();
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
