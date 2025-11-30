package upnadirect;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.Year;

public class ClienteTest {

    @Test
    public void un_cliente_con_ano_nacimiento_valido() {
        // Un cliente nacido en 1970 tiene un año de nacimiento valido,
        // mayor que 1900 y menor que el actual.
        int anoNacimiento = 1970;
        
        // Cuando ejecuto la funcion que comprueba la validez del año de nacimiento
        boolean valido = Cliente.esValido(anoNacimiento);
        // Debe devolver true
        assertTrue(valido);
    }
    
    @Test
    public void un_cliente_con_ano_nacimiento_no_valido_inferior() {
        // Un cliente nacido en 1867 tiene un año de nacimiento no valido,
        // el año de nacimiento es menor que 1900
        int anoNacimiento = 1867;
        
        // Cuando ejecuto la funcion que comprueba la validez del año de nacimiento
        boolean valido = Cliente.esValido(anoNacimiento);
        // Debe devolver false
        assertFalse(valido);
    }
    
    @Test
    public void un_cliente_con_ano_nacimiento_no_valido_superior() {
        // Un cliente nacido en año actual + 1, por ejemplo 2025 + 1 = 2026
        // tiene un año de nacimiento no valido, es superior al año actual
        int anoNacimiento = Year.now().getValue() + 1;
        
        // Cuando ejecuto la funcion que comprueba la validez del año de nacimiento
        boolean valido = Cliente.esValido(anoNacimiento);
        // Debe devolver false
        assertFalse(valido);
    }
}
