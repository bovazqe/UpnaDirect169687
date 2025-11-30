package upnadirect;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.Year;

public class MafroTest {

    @Test
    public void un_cliente_de_27_anos_asegura_un_vehiculo() {
        // Dado un cliente de 27 años, que asegura un vehiculo
        // de valor 40000, debe aplicarse el 3% de tasa
        
        Mafro mafro = new Mafro();
        int anoNacimiento = Year.now().getValue() - 27;
        int salario = 35000;
        Cliente cliente = new Cliente(anoNacimiento, salario);
        
        Bien.TipoBien tipo = Bien.TipoBien.VEHICULO;
        int valor = 4000;
        Bien bien = new Bien(tipo, valor);
        
        double importeEsperado = 120.00; // (4000 * 0.03)
        int comisionEsperada = (int) Math.floor(importeEsperado * 0.01); //(120 * 0.01) (importe < 1000)
        
        // Cuando calculo la oferta
        Oferta oferta = mafro.calcularOferta(cliente, bien);
        
        // Debe devolver
        assertEquals("Debe haber usado 3%",importeEsperado, oferta.getImporte(), 0.001);
        assertEquals("La comision es de 1%",comisionEsperada, oferta.getComision());
    }

    @Test
    public void un_cliente_de_18_anos_asegura_un_vehiculo() {
        // Dado un cliente menor a 20 años, 18 años, que asegura un vehiculo
        // de valor 40000
        
        Mafro mafro = new Mafro();
        int anoNacimiento = Year.now().getValue() - 18;
        int salario = 35000;
        Cliente cliente = new Cliente(anoNacimiento, salario);
        
        Bien.TipoBien tipo = Bien.TipoBien.VEHICULO;
        int valor = 40000;
        Bien bien = new Bien(tipo, valor);
        
        double importeEsperado = 2000.00; // (40000 * 0.05)
        int comisionEsperada = (int) Math.floor(importeEsperado * 0.03); //(2000 * 0.03) (importe > 1000)
        
        // Cuando calculo la oferta
        Oferta oferta = mafro.calcularOferta(cliente, bien);
        
        // Debe devolver
        assertEquals("Debe haber usado 5%",importeEsperado, oferta.getImporte(), 0.001);
        assertEquals("La comision es de 3%",comisionEsperada, oferta.getComision());
    }
    
    @Test
    public void un_cliente_de_27_anos_asegura_una_vivienda_de_250k_y_cobra_15k() {
        // Dado un cliente de 27 años, que asegura una vivienda de 250000 y que
        // su salario es de 15000, debe aplicarse la reduccion al 2%
        
        Mafro mafro = new Mafro();
        int anoNacimiento = Year.now().getValue() - 27;
        int salario = 15000;
        Cliente cliente = new Cliente(anoNacimiento, salario);
        
        Bien.TipoBien tipo = Bien.TipoBien.VIVIENDA;
        int valor = 250000;
        Bien bien = new Bien(tipo, valor);
        
        double importeEsperado = 5000.00; // (250000 * 0.02)
        int comisionEsperada = (int) Math.floor(importeEsperado * 0.03); //(5000 * 0.03) (importe > 1000)
        
        // Cuando calculo la oferta
        Oferta oferta = mafro.calcularOferta(cliente, bien);
        
        // Debe devolver
        assertEquals("Debe haber usado 2%",importeEsperado, oferta.getImporte(), 0.001);
        assertEquals("La comision es de 3%",comisionEsperada, oferta.getComision());
    }
}
