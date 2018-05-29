
package lineales.dinamicas;


public class Testcola {
     public static ColaChar generar(ColaChar c1){
        ColaChar aux=new ColaChar(),aux1=new ColaChar();
        pilaChar temp=new pilaChar();
        if(!c1.esVacia()){
            while(!c1.esVacia()){
                if(c1.obtenerFrente()!='#'){
                    aux.poner(c1.obtenerFrente());
                    temp.apilar(c1.obtenerFrente());
                    aux1.poner(c1.obtenerFrente());
                }
                else{
                    while(!temp.esVacia()){
                        aux.poner(temp.obtenerTope());
                        temp.desapilar();
                    }
                    while(!aux1.esVacia()){
                        aux.poner(aux1.obtenerFrente());
                        aux1.sacar();
                    }
                    aux.poner('#');
                }
                c1.sacar();
            }
            while(!temp.esVacia()){
                aux.poner(temp.obtenerTope());
                temp.desapilar();
            }
            while(!aux1.esVacia()){
                aux.poner(aux1.obtenerFrente());
                aux1.sacar();
            }
        }
        return aux;
    }
    public static void main(String[]args){
        /**/
        ColaChar c1= new ColaChar(),c2;
        int opcion=1;
        char c;
        while(opcion!=0){
            c=TecladoIn.readLineNonwhiteChar();
            c1.poner(c);
            System.out.println("¿Desea continuar?");
            opcion=TecladoIn.readLineInt();
        }
        System.out.println(c1.toString());
        c2=generar(c1);
        System.out.println(c2.toString());
        
        
    }
    
}
