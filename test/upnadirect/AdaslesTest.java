package upnadirect;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.Year;

public class AdaslesTest {

    @Test
    public void un_cliente_de_25_años_asegura_vivienda_de_150k() {
        // Dado un cliente de 25 años que asegura una vivienda de 150000
        // debe aplicarse la tasa general de 2%
        Adasles adasles = new Adasles();
        int anoNacimiento = Year.now().getValue() - 25;
        int salario = 35000;
        Cliente cliente = new Cliente(anoNacimiento, salario);
        
        Bien.TipoBien tipo = Bien.TipoBien.VIVIENDA;
        int valor = 150000;
        Bien bien = new Bien(tipo, valor);
        
        double importeEsperado = 3000.00; // (150000 * 0.02)
        int comisionEsperada = (int) Math.floor(importeEsperado * 0.05); //(3000 * 0.05) (importe > 1000)
        
        // Cuando calculo la oferta
        Oferta oferta = adasles.calcularOferta(cliente, bien);
        
        // Debe devolver
        assertEquals("Debe haber usado 2%",importeEsperado, oferta.getImporte(), 0.001);
        assertEquals("La comision es de 5%",comisionEsperada, oferta.getComision());
    }
    
    @Test
    public void un_cliente_de_25_años_asegura_vehiculo_de_10k() {
        // Dado un cliente de 25 años que asegura un vehiculo de 10000
        // debe aplicarse la tasa general de 2%
        Adasles adasles = new Adasles();
        int anoNacimiento = Year.now().getValue() - 25;
        int salario = 35000;
        Cliente cliente = new Cliente(anoNacimiento, salario);
        
        Bien.TipoBien tipo = Bien.TipoBien.VEHICULO;
        int valor = 10000;
        Bien bien = new Bien(tipo, valor);
        
        double importeEsperado = 200.00; // (10000 * 0.02)
        int comisionEsperada = (int) Math.floor(importeEsperado * 0.01); //(200 * 0.01) (importe <= 1000)
        
        // Cuando calculo la oferta
        Oferta oferta = adasles.calcularOferta(cliente, bien);
        
        // Debe devolver
        assertEquals("Debe haber usado 2%",importeEsperado, oferta.getImporte(), 0.001);
        assertEquals("La comision es de 1%",comisionEsperada, oferta.getComision());
    }
    
    @Test
    public void un_cliente_de_19_años_asegura_vehiculo_de_20k() {
        // Dado un cliente de 25 años que asegura un vehiculo de 20000
        // debe aplicarse la tasa superior de 6%
        Adasles adasles = new Adasles();
        int anoNacimiento = Year.now().getValue() - 19;
        int salario = 35000;
        Cliente cliente = new Cliente(anoNacimiento, salario);
        
        Bien.TipoBien tipo = Bien.TipoBien.VEHICULO;
        int valor = 20000;
        Bien bien = new Bien(tipo, valor);
        
        double importeEsperado = 1200.00; // (20000 * 0.06)
        int comisionEsperada = (int) Math.floor(importeEsperado * 0.05); //(1200 * 0.05) (importe > 1000)
        
        // Cuando calculo la oferta
        Oferta oferta = adasles.calcularOferta(cliente, bien);
        
        // Debe devolver
        assertEquals("Debe haber usado 6%",importeEsperado, oferta.getImporte(), 0.001);
        assertEquals("La comision es de 5%",comisionEsperada, oferta.getComision());
    }
    
    @Test
    public void un_cliente_de_70_años_asegura_vehiculo_de_30k() {
        // Dado un cliente de 25 años que asegura un vehiculo de 20000
        // debe aplicarse la tasa superior de 6%
        Adasles adasles = new Adasles();
        int anoNacimiento = Year.now().getValue() - 70;
        int salario = 35000;
        Cliente cliente = new Cliente(anoNacimiento, salario);
        
        Bien.TipoBien tipo = Bien.TipoBien.VEHICULO;
        int valor = 30000;
        Bien bien = new Bien(tipo, valor);
        
        double importeEsperado = 1800.00; // (30000 * 0.06)
        int comisionEsperada = (int) Math.floor(importeEsperado * 0.05); //(1800 * 0.05) (importe > 1000)
        
        // Cuando calculo la oferta
        Oferta oferta = adasles.calcularOferta(cliente, bien);
        
        // Debe devolver
        assertEquals("Debe haber usado 6%",importeEsperado, oferta.getImporte(), 0.001);
        assertEquals("La comision es de 5%",comisionEsperada, oferta.getComision());
    }
    
    @Test
    public void un_cliente_de_60_años_asegura_vehiculo_de_10k() {
        // Dado un cliente de 60 años que asegura un vehiculo de 10000
        // debe aplicarse la tasa general de 2% ya que no es > 60 años
        Adasles adasles = new Adasles();
        int anoNacimiento = Year.now().getValue() - 60;
        int salario = 35000;
        Cliente cliente = new Cliente(anoNacimiento, salario);
        
        Bien.TipoBien tipo = Bien.TipoBien.VEHICULO;
        int valor = 10000;
        Bien bien = new Bien(tipo, valor);
        
        double importeEsperado = 200.00; // (10000 * 0.02)
        int comisionEsperada = (int) Math.floor(importeEsperado * 0.01); //(200 * 0.01) (importe <= 1000)
        
        // Cuando calculo la oferta
        Oferta oferta = adasles.calcularOferta(cliente, bien);
        
        // Debe devolver
        assertEquals("Debe haber usado 2%",importeEsperado, oferta.getImporte(), 0.001);
        assertEquals("La comision es de 1%",comisionEsperada, oferta.getComision());
    }
    
}
