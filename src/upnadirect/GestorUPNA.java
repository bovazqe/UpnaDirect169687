package upnadirect;

import java.util.ArrayList;
import java.util.List;

public class GestorUPNA {
    private final List<Aseguradora> aseguradoras;
    
    public GestorUPNA(List<Aseguradora> aseguradoras){
        this.aseguradoras = aseguradoras;
    }
    
    public Oferta obtenerMejorOferta(Cliente cliente, Bien bien){
        List<Oferta> ofertas = new ArrayList<>();
        
        for(Aseguradora aseguradora : aseguradoras){
            Oferta oferta = aseguradora.calcularOferta(cliente, bien);
            ofertas.add(oferta);
        }
        
        return seleccionarMejorOferta(ofertas);
    }
    
    private Oferta seleccionarMejorOferta(List<Oferta> ofertas){
        if(ofertas.isEmpty()){
            return null;
        }
        
        Oferta mejorOferta = ofertas.get(0);
        
        for(int i = 1; i < ofertas.size(); i++){
            Oferta ofertaActual = ofertas.get(i);
            
            if(ofertaActual.compareTo(mejorOferta) == -1){
                mejorOferta = ofertaActual;
            }
        }
        return mejorOferta;
    }
}
