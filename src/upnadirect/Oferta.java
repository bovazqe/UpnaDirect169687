package upnadirect;

public class Oferta implements Comparable<Oferta>{
    
    private final String aseguradora;
    private final int importe;
    private final int comision;
    
    public Oferta(String aseguradora, int importe, int comision){
        this.aseguradora = aseguradora;
        this.importe = importe;
        this.comision = comision;
    }
    
    public int compareTo(Oferta otraOferta){
        if(this.importe < otraOferta.importe){
            return -1;  // Esta oferta es mejor (menor importe)
        }
        if(this.importe > otraOferta.importe){
            return 1; // otraOFerta es mejor
        }
        if(this.importe == otraOferta.importe){
            if(this.comision > otraOferta.comision){
            return -1; // Esta oferta es mejor (mayor comision)
            }
            if(this.comision < otraOferta.comision){
                return 1; // otraOFerta es mejor
            }
        }
        return 0; // Si las ofertas son iguales
    }
    
    public String getAseguradora() {
        return aseguradora;
    }

    public double getImporte() {
        return importe;
    }

    public double getComision() {
        return comision;
    }
}
