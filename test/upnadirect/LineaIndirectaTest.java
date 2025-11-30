package upnadirect;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.Year;

public class LineaIndirectaTest {
    
    @Test
    public void un_cliente_de_35_anos_asegura_un_vehiculo_de_35k() {
        LineaIndirecta lineaIndirecta = new LineaIndirecta();
        int anoNacimiento = Year.now().getValue() - 35;
        int salario = 35000;
        Cliente cliente = new Cliente(anoNacimiento, salario);
        
        Bien.TipoBien tipo = Bien.TipoBien.VEHICULO;
        int valor = 35000;
        Bien bien = new Bien(tipo, valor);
        
        double importeEsperado = 1050.00; // (35000 * 0.03)
        int comisionEsperada = (int) Math.floor(importeEsperado * 0.04); //(1050 * 0.04) (importe > 1000)
        
        // Cuando calculo la oferta
        Oferta oferta = lineaIndirecta.calcularOferta(cliente, bien);
        
        // Debe devolver
        assertEquals("Debe haber usado 3%",importeEsperado, oferta.getImporte(), 0.001);
        assertEquals("La comision es de 4%",comisionEsperada, oferta.getComision());
    }
    
    @Test
    public void un_cliente_de_35_anos_asegura_un_vehiculo_de_5k() {
        LineaIndirecta lineaIndirecta = new LineaIndirecta();
        int anoNacimiento = Year.now().getValue() - 35;
        int salario = 35000;
        Cliente cliente = new Cliente(anoNacimiento, salario);
        
        Bien.TipoBien tipo = Bien.TipoBien.VEHICULO;
        int valor = 5000;
        Bien bien = new Bien(tipo, valor);
        
        double importeEsperado = 200.00; // (5000 * 0.04)
        int comisionEsperada = (int) Math.floor(importeEsperado * 0.01); //(200 * 0.01) (importe < 1000)
        
        // Cuando calculo la oferta
        Oferta oferta = lineaIndirecta.calcularOferta(cliente, bien);
        
        // Debe devolver
        assertEquals("Debe haber usado 4%",importeEsperado, oferta.getImporte(), 0.001);
        assertEquals("La comision es de 1%",comisionEsperada, oferta.getComision());
    }
    
    @Test
    public void un_cliente_de_65_anos_asegura_un_vehiculo_de_50k() {
        LineaIndirecta lineaIndirecta = new LineaIndirecta();
        int anoNacimiento = Year.now().getValue() - 65;
        int salario = 35000;
        Cliente cliente = new Cliente(anoNacimiento, salario);
        
        Bien.TipoBien tipo = Bien.TipoBien.VEHICULO;
        int valor = 50000;
        Bien bien = new Bien(tipo, valor);
        
        double importeEsperado = 3000.00; // (50000 * 0.06)
        int comisionEsperada = (int) Math.floor(importeEsperado * 0.04); //(3000 * 0.01) (importe > 1000)
        
        // Cuando calculo la oferta
        Oferta oferta = lineaIndirecta.calcularOferta(cliente, bien);
        
        // Debe devolver
        assertEquals("Debe haber usado 6%",importeEsperado, oferta.getImporte(), 0.001);
        assertEquals("La comision es de 4%",comisionEsperada, oferta.getComision());
    }
}
