
package upnadirect;

public interface IVistaOferta {
    int solicitarAnoNacimiento();
    int solicitarSalario();
    Bien.TipoBien solicitarTipo();
    int solicitarValor();
    void imprimirOferta(Oferta oferta);
    void mostrarMensaje(String mensaje);
}
