
package lineales.dinamicas;


public class TestLista {
    public static void Menu(){
        System.out.println("          Menu:");
        System.out.println("(1)Insertar un elemento.");
        System.out.println("(2)Eliminar un elemento.");
        System.out.println("(3)Recuperar un elemento.");
        System.out.println("(4)Ingresar un elemento y recibir una posicion. ");
        System.out.println("(5)Retornar la longitud de la lista.");
        System.out.println("(6)Vaciar la Lista.");
        System.out.println("(7)Concatenar.");
        System.out.println("(8)Recibir una cadena de los elementos de la lista.");
        System.out.println("(9)Invertir.");
        System.out.println("(0)Terminar");
        System.out.print("   Ingrese una opcion: ");
        
        
        
    }
    public static ListaChar generar(ColaChar q1,int k){
        ListaChar l1=new ListaChar();
        int m,i=1;
        pilaChar pila=new pilaChar();
        ColaChar cola= new ColaChar();
        while(!q1.esVacia()){
            m=1;
            while(m<=k){
                l1.insertar(q1.obtenerFrente(), i);
                pila.apilar(q1.obtenerFrente());
                cola.poner(q1.obtenerFrente());
                q1.sacar();
                i++;
                m++;
            }
            m=1;
            while(m<=k){
                l1.insertar(cola.obtenerFrente(), i);
                cola.sacar();
                i++;
                m++;
            }
            m=1;
            while(m<=k){
                l1.insertar(pila.obtenerTope(), i);
                pila.desapilar();
                m++;
                i++;
            }
            if(!q1.esVacia())
                l1.insertar('#', i);
            i++;
        }
        return l1;
    }
   
    public static ListaInt concatenar(ListaInt lista1,ListaInt lista2){
        ListaInt temp=new ListaInt();
        int i=1,j=1;
        while(i<=lista1.longitud()){
            temp.insertar(lista1.recuperar(i), i);
            
            i++;
            
        }
        while(j<=lista2.longitud()){
            temp.insertar(lista2.recuperar(j), i);
            i++;
            j++;
        }
        return temp;
    }
    public static ListaInt invertir(ListaInt lista){
        ListaInt temp=new ListaInt();
        PilaInt pila=new PilaInt();
        int i=1;
        while(i<=lista.longitud()){
            pila.apilar(lista.recuperar(i));
            i++;
        }
        i=1;
        while(!pila.esVacia()){
            temp.insertar(pila.obtenerTope(), i);
            pila.desapilar();
            i++;
        }
        return temp;
    }
    public static void main(String[]args){
        ListaInt temp,lista=new ListaInt(),lista1= new ListaInt();
        ListaChar aux,l1=new ListaChar();
        ColaChar cola=new ColaChar();
        char c;
        int opcion,pos, elemento;
        do{
           Menu();
           opcion=TecladoIn.readLineInt();
           switch(opcion){
               case 1:{
                   System.out.print("Ingrese el elemento que desea ingresar a la lista: ");
                   c=TecladoIn.readLineNonwhiteChar();
                   //elemento=TecladoIn.readLineInt();
                   System.out.print("Ingrese la posicion: ");
                   pos=TecladoIn.readLineInt();
                   System.out.println(l1.insertar(c, pos));
                   //lista1.insertar(elemento+10, pos);
                   break;
               }
               case 2:{
                   System.out.print("Ingrese la posicion del elemento que desea eliminar: ");
                   pos=TecladoIn.readLineInt();
                   System.out.println(lista.eliminar(pos));
                   break;
               }
               case 3:{
                   System.out.print("Ingrese la posicion: ");
                   pos=TecladoIn.readLineInt();
                   System.out.println(lista.recuperar(pos));
                   break;
               }
               case 4:{
                   System.out.print("Ingrese el elemento: ");
                   elemento=TecladoIn.readLineInt();
                   System.out.println(lista.localizar(elemento));
                   break;
               }
               case 5:{
                   System.out.println("La longitud de la lista es "+lista.longitud());
                   break;
               }
               case 6:{
                   lista.vaciar();
                   break;
               }
               case 7:{
                   temp=concatenar(lista,lista1);
                   System.out.println(temp.toString());
                   break;
               }
               case 8:{
                   
                   System.out.print("Ingrese la variable K: ");
                   pos=TecladoIn.readLineInt();
                   cola.poner('A');
                   cola.poner('B');
                   cola.poner('C');
                   cola.poner('D');
                   cola.poner('E');
                   cola.poner('F');
                   cola.poner('G');
                   cola.poner('H');
                   aux=generar(cola,pos);
                   System.out.println(aux.toString());
                  // System.out.println(lista.toString());
                   //System.out.print("Ingrese la x");
                   //pos=TecladoIn.readLineInt();
                   //lista.compactar(pos);
                   //lista.eliminarApariciones(3);
                   //lista.insertarPromedio();
                   //System.out.println(lista.toString());
                   //System.out.println(lista1.toString());
                   break;
               }
               case 9:{
                   temp=invertir(lista);
                   System.out.println(temp.toString());
                   break;
               }
           }
        }while(opcion!=0);
    }
}
