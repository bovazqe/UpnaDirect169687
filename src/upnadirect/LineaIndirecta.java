package upnadirect;

public class LineaIndirecta implements Aseguradora{
    
    private static final String NOMBRE = "LINEA INDIRECTA";
    
    @Override
    public Oferta calcularOferta(Cliente cliente, Bien bien){
        
        double importe;
        int valorBien = bien.getValor();
        
        importe = valorBien * 0.03;
        
        if((bien.getTipo() == Bien.TipoBien.VEHICULO && valorBien < 20000) || (bien.getTipo() == Bien.TipoBien.VIVIENDA && valorBien < 150000)){
            importe = valorBien * 0.04;
        }
        
        if(bien.getTipo() == Bien.TipoBien.VEHICULO && valorBien >= 20000 && cliente.calcularEdad() > 60) {
            importe = valorBien * 0.06;
        }
        
        double comisionBruta;
        if(importe <= 1000){
            comisionBruta = importe * 0.01;
        } else {
            comisionBruta = importe * 0.04;
        }
        int comisionRedondeada = (int)Math.floor(comisionBruta);
        
        return new Oferta(NOMBRE, importe, comisionRedondeada);
    }
}
