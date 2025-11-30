package upnadirect;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class PresentadorOfertaTest {

    @Test
    public void presentador_envia_oferta_correcta_a_vista() {
        // Primero inicializo todo lo necesario, he introduzco unos valores
        // a la vista falsa 
        
        Aseguradora mafro = new Mafro();
        Aseguradora lineaIndirecta = new LineaIndirecta();
        Aseguradora adasles = new Adasles();
        
        List<Aseguradora> aseguradoras = new ArrayList<>();
        aseguradoras.add(mafro);
        aseguradoras.add(lineaIndirecta);
        aseguradoras.add(adasles);
        
        GestorUPNA modelo = new GestorUPNA(aseguradoras);
        VistaFalsa vistaFalsa = new VistaFalsa(2006, 15000, Bien.TipoBien.VEHICULO , 30000);
        PresentadorOferta presentador = new PresentadorOferta(modelo, vistaFalsa);
        // Ejecuto el flujo del programa
        presentador.procesarNuevaOferta();
        
        Oferta ofertaRecibida = vistaFalsa.ofertaRecibida;
        // Comprobamos si lo obtenido es lo requerido
        // Compruebo primero los datos por separado, Aseguradora, Importe y comision
        // Finalmente compruebo el formato de impresion por pantalla
        assertEquals("La aseguradora no es correcta", "LINEA INDIRECTA", ofertaRecibida.getAseguradora());
        assertEquals("El importe calculado es incorrecto.", 900.00,ofertaRecibida.getImporte(),0.001);
        assertEquals("La comisión calculada es incorrecta.",9,ofertaRecibida.getComision());
        
        String formatoImpresion = "LINEA INDIRECTA | 900 | 9";
        String textoObtenido = String.format("%s | %.0f | %d",ofertaRecibida.getAseguradora(),ofertaRecibida.getImporte(),ofertaRecibida.getComision());
    
        assertEquals("El formato de impresion no es correcto", formatoImpresion, textoObtenido);
    }
  
}
