package upnadirect;

public class Mafro implements Aseguradora{
    
    private static final String NOMBRE = "MAFRO";
    
    @Override
    public Oferta calcularOferta(Cliente cliente, Bien bien){
        
        double importe;
        int valorBien = bien.getValor();
        
        importe = valorBien * 0.03;
        
        if(bien.getTipo() == Bien.TipoBien.VEHICULO){
            if(cliente.calcularEdad() < 20){
                importe = valorBien * 0.05;
            }
        }
        if(bien.getTipo() == Bien.TipoBien.VIVIENDA){
            if(valorBien > 200000 && cliente.getSalario() < 20000){
                importe = valorBien * 0.02;
            }
        }
        
        double comisionBruta;
        if(importe <= 1000){
            comisionBruta = importe * 0.01;
        } else {
            comisionBruta = importe * 0.03;
        }
        int comisionRedondeada = (int)Math.floor(comisionBruta);
        
        return new Oferta(NOMBRE, importe, comisionRedondeada);
    }
}
