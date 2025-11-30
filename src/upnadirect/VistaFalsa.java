package upnadirect;

public class VistaFalsa implements IVistaOferta {
    
    private final int anoNacimiento;
    private final int salario;
    private final int valor;
    private final Bien.TipoBien tipo;
    
    public Oferta ofertaRecibida = null;
    
    public VistaFalsa(int anoNacimiento, int salario, Bien.TipoBien tipo, int valor){
        this.anoNacimiento = anoNacimiento;
        this.salario = salario;
        this.tipo = tipo;
        this.valor = valor;
    }
    
    @Override
    public int solicitarAnoNacimiento(){
        return anoNacimiento;
    }

    @Override
    public int solicitarSalario(){
        return salario;
    }

    @Override
    public Bien.TipoBien solicitarTipo(){
        return tipo;
    }

    @Override
    public int solicitarValor(){
        return valor;
    }

    @Override
    public void imprimirOferta(Oferta oferta){
        this.ofertaRecibida = oferta; // Capturo el objeto para verificarlo en el test
    }

    @Override
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
}
