package upnadirect;

import org.junit.Test;
import static org.junit.Assert.*;

public class BienTest {

    @Test
    public void un_vehiculo_con_valor_entre_los_limites() {
        // Dado un vehiculo, cuyo valor es 20000, es valido ya que es
        // menor o igual a 50000 y mayor a 0 (Considero que un bien siempre tiene valor positivo).
        Bien.TipoBien tipo = Bien.TipoBien.VEHICULO;
        int valor = 20000;
        // Cuando ejecuto el metodo que comprueba su validez
        boolean valido = Bien.esValido(tipo, valor);
        // Debe devolver true
        assertTrue(valido);
    }
    
    @Test
    public void un_vehiculo_con_valor_en_limite_superior() {
        // Dado un vehiculo, cuyo valor es 50000, es valido ya que es
        // igual a 50000 y mayor a 0 (Considero que un bien siempre tiene valor positivo).
        Bien.TipoBien tipo = Bien.TipoBien.VEHICULO;
        int valor = 50000;
        // Cuando ejecuto el metodo que comprueba su validez
        boolean valido = Bien.esValido(tipo, valor);
        // Debe devolver true
        assertTrue(valido);
    }
    
    @Test
    public void un_vehiculo_con_valor_mayor_al_maximo() {
        // Dado un vehiculo, cuyo valor es 50001, no es valido ya que es
        // supera a 50000
        Bien.TipoBien tipo = Bien.TipoBien.VEHICULO;
        int valor = 50001;
        // Cuando ejecuto el metodo que comprueba su validez
        boolean valido = Bien.esValido(tipo, valor);
        // Debe devolver false
        assertFalse(valido);
    }
    
    @Test
    public void un_vehiculo_con_valor_negativo() {
        // Dado un vehiculo, cuyo valor es -1, no es valido ya que es
        // iferior a 0
        Bien.TipoBien tipo = Bien.TipoBien.VEHICULO;
        int valor = -1;
        // Cuando ejecuto el metodo que comprueba su validez
        boolean valido = Bien.esValido(tipo, valor);
        // Debe devolver false
        assertFalse(valido);
    }
    
    @Test
    public void una_vivienda_con_valor_entre_los_limites() {
        // Dado una vivienda, con valor 120000, es valido, ya que se encuentra
        // dentro de los limites, mayor o igual a 50000
        Bien.TipoBien tipo = Bien.TipoBien.VIVIENDA;
        int valor = 120000;
        // Cuando ejecuto el metodo que comprueba su validez
        boolean valido = Bien.esValido(tipo, valor);
        // Debe devolver true
        assertTrue(valido);
    }
    
    @Test
    public void una_vivienda_con_valor_igual_al_limite_inferior() {
        // Dado una vivienda, con valor 50000, es valido, ya que se encuentra
        // dentro de los limites, mayor o igual a 50000
        Bien.TipoBien tipo = Bien.TipoBien.VIVIENDA;
        int valor = 50000;
        // Cuando ejecuto el metodo que comprueba su validez
        boolean valido = Bien.esValido(tipo, valor);
        // Debe devolver true
        assertTrue(valido);
    }
    
    @Test
    public void una_vivienda_con_valor_menor_al_limite() {
        // Dado una vivienda, con valor 1200, no es valido, ya que su valor es 
        // menor a 50000
        Bien.TipoBien tipo = Bien.TipoBien.VIVIENDA;
        int valor = 12000;
        // Cuando ejecuto el metodo que comprueba su validez
        boolean valido = Bien.esValido(tipo, valor);
        // Debe devolver false
        assertFalse(valido);
    }
}
