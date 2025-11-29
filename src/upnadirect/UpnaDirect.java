package upnadirect;

import java.util.ArrayList;
import java.util.List;

public final class UpnaDirect {
    
    // Para corregir Code Smell creo un constructor vaicio
    // esto hace q no se puedan crear instrancias de esta clase
    private UpnaDirect(){ 
    }

    public static void main(String[] args) {
        Aseguradora mafro = new Mafro();
        Aseguradora lineaIndirecta = new LineaIndirecta();
        Aseguradora adasles = new Adasles();
        
        List<Aseguradora> aseguradoras = new ArrayList<>();
        aseguradoras.add(mafro);
        aseguradoras.add(lineaIndirecta);
        aseguradoras.add(adasles);
        
        GestorUPNA modelo = new GestorUPNA(aseguradoras);
        VistaOferta vista = new VistaOferta();
        PresentadorOferta presentador = new PresentadorOferta(modelo, vista);
        
        System.out.println("UPNA DIRECT");
        presentador.procesarNuevaOferta();
    }
}
