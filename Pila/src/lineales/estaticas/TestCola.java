package lineales.estaticas;

public class TestCola {
    public static void main(String[]args){
        ColaInt cola=new ColaInt();
        ColaInt clon;
        cola.poner(1);
        cola.poner(2);
        cola.poner(3);
        cola.poner(4);
        System.out.println(cola.poner(5));
        
        cola.sacar();
        System.out.println(cola.poner(7));
        cola.poner(5);
        
        System.out.println(cola.toString());
    }
    
}
