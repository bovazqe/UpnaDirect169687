package upnadirect;

public class Bien {
    
    public enum TipoBien {
        VEHICULO, 
        VIVIENDA
    }
    private final TipoBien tipo;
    private final int valor;
    
    public Bien(TipoBien tipo, int valor){
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public static boolean esValido(TipoBien tipo, int valor){
        if (tipo == null) {
            return false; 
        }
        
        if(valor <= 0){
            return false;
        }
        
        if(tipo == TipoBien.VEHICULO){
            return valor <= 50000;
        } else if (tipo == TipoBien.VIVIENDA){
            return valor >= 50000;
        }
        
        return false;
    }
    
    public TipoBien getTipo(){
        return tipo;
    }
    
    public int getValor(){
        return valor;
    }
    
}
