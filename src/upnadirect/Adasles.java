package upnadirect;

public class Adasles implements Aseguradora{
    
    private static final String NOMBRE = "ADASLES";
    
    @Override
    public Oferta calcularOferta(Cliente cliente, Bien bien){
        
        double importe;
        int valorBien = bien.getValor();
        
        importe = valorBien * 0.02;
        if(bien.getTipo() == Bien.TipoBien.VEHICULO){
            if(cliente.calcularEdad() < 20 || cliente.calcularEdad() > 60){
                importe = valorBien * 0.06;
            }
        }
        
        double comisionBruta;
        
        if(importe <= 1000){
            comisionBruta = importe * 0.01;
        } else {
            comisionBruta = importe * 0.05;
        }
        int comisionRedondeada = (int)Math.floor(comisionBruta);
        
        return new Oferta(NOMBRE, importe, comisionRedondeada);

    }
}
