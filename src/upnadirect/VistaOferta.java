package upnadirect;

import java.util.Scanner;

public class VistaOferta {
    private final PresentadorOferta presentador;
    private Scanner scanner = new Scanner(System.in);

    public VistaOferta(PresentadorOferta presentador) {
        this.presentador = presentador;
    }
    
    public int solicitarAnoNacimiento(){
        int valor = -1;

        do{
            System.out.print("Introduce el Año de Nacimiento del Cliente: ");
            while(!scanner.hasNextInt()){
                mostrarMensaje("Debe introducir un entero positivo");
                scanner.next();
                System.out.print("Introduce el Año de Nacimiento del Cliente: ");
            }
            
            valor = scanner.nextInt();
            scanner.nextLine();
            
            if(valor < 0){
                mostrarMensaje("El valor debe ser positivo.");
            }
        } while(valor < 0);
        return valor;
    }
    
    public int solicitarSalario(){
        int valor = -1;

        do{
            System.out.print("Introduce el Salario Anual del Cliente: ");
            while(!scanner.hasNextInt()){
                mostrarMensaje("Debe introducir un entero positivo");
                scanner.next();
                System.out.print("Introduce el Salario Anual del Cliente: ");
            }
            
            valor = scanner.nextInt();
            scanner.nextLine();
            
            if(valor < 0){
                mostrarMensaje("El valor debe ser positivo.");
            }
        } while(valor < 0);
        return valor;
    }
    
    public int solicitarValor(){
        int valor = -1;

        do{
            System.out.print("Introduce el Valor del Bien: ");
            while(!scanner.hasNextInt()){
                mostrarMensaje("Debe introducir un entero positivo");
                scanner.next();
                System.out.print("Introduce el Valor del Bien: ");
            }
            
            valor = scanner.nextInt();
            scanner.nextLine();
            
            if(valor <= 0){
                mostrarMensaje("El valor debe ser positivo.");
            }
        } while(valor <= 0);
        return valor;
    }
    
    public Bien.TipoBien solicitarTipo(){
        int opcion;
        Bien.TipoBien tipo = null;
        boolean valido = false;
        
        while(!valido){
            System.out.println("Seleccione el tipo de bien: ");
            System.out.print("1. VEHICULO \n2.VIVIENDA\nOpcion (1 | 2): ");
            
            if(!scanner.hasNextInt()){
                mostrarMensaje("Debe introducir 1 o 2.");
                scanner.next();
                scanner.nextLine();
                continue;
            }
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            if(opcion == 1){
                tipo = Bien.TipoBien.VEHICULO;
                valido = true;
                break;
            } else if(opcion == 2){
                tipo = Bien.TipoBien.VIVIENDA;
                valido = true;
                break;
            } else {
                System.out.println("Opcion no valida. Introduce 1 o 2.");
            }
        }
        return tipo;
    }
    
    public void imprimirOferta(Oferta oferta){
        System.out.println("MEJOR OFERTA: ");
        System.out.printf(" %s | %.2f | %d \n", oferta.getAseguradora(), oferta.getImporte(), oferta.getComision());
    }
    
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}
