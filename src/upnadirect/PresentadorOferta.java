package upnadirect;

public class PresentadorOferta {
    
    private final GestorUPNA modelo;
    private VistaOferta vista;
    
    public PresentadorOferta(GestorUPNA modelo){
        this.modelo = modelo;
    }
    
    public void setVista(VistaOferta vista){
        this.vista = vista;
    }
    
    public Oferta procesarNuevaOferta(){
        vista.mostrarMensaje("INICIO OFERTA MAS VENTAJOSA");
        
        Cliente cliente = gestionarNuevoCliente();
        Bien bien = gestionarNuevoBien();
        
        vista.mostrarMensaje("Calculando ofertas...");
        
        Oferta mejorOferta = modelo.obtenerMejorOferta(cliente, bien);
        
        if(mejorOferta != null){
            vista.imprimirOferta(mejorOferta);
        } else {
            vista.mostrarMensaje("No se pudo obetner una oferta valida.");
        }
    }
    
    private Cliente gestionarNuevoCliente(){        
        Cliente cliente = null;
        boolean valido = false;
        while(!valido){
            int anoNacimiento = vista.solicitarAnoNacimiento();
            int salario = vista.solicitarSalario();
            
            if(Cliente.esValido(anoNacimiento)){
                if(salario >= 0){
                    cliente = new Cliente(anoNacimiento, salario);
                    valido = true;
                } else {
                    vista.mostrarMensaje("El salario no puede ser negativo.");
                }   
            } else {
                vista.mostrarMensaje("El año de nacimiento debe ser mayor a 1900 y menor a 2025.");
            }
        }
        return cliente;
    }
    
    private Bien gestionarNuevoBien(){
        Bien bien = null;
        boolean valido = false;
        
        while(!valido){
            Bien.TipoBien tipo = vista.solicitarTipo();
            int valor = vista.solicitarValor();
            
            if(Bien.esValido(tipo, valor)){
                bien = new Bien(tipo, valor);
                valido = true;
            } else {
                vista.mostrarMensaje("Valor no valido: VEHICULO <= 50000, VIVIENDA >= 50000.");
            }
        }
        return bien;
    }
}
