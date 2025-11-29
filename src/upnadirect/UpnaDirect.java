package upnadirect;

import java.util.ArrayList;
import java.util.List;

public class UpnaDirect {

    public static void main(String[] args) {
        Aseguradora mafro = new Mafro();
        Aseguradora lineaIndirecta = new LineaIndirecta();
        Aseguradora adasles = new Adasles();
        
        List<Aseguradora> aseguradoras = new ArrayList<>();
        aseguradoras.add(mafro);
        aseguradoras.add(lineaIndirecta);
        aseguradoras.add(adasles);
        
        GestorUPNA modelo = new GestorUPNA(aseguradoras);
        PresentadorOferta presentador = new PresentadorOferta(modelo);
        
        VistaOferta vista = new VistaOferta(presentador);
        
        presentador.setVista(vista);
        
        System.out.println("UPNA DIRECT");
        presentador.procesarNuevaOferta();
    }
}
