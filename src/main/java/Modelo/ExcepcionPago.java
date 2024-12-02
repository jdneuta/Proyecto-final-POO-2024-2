package Modelo;

public class ExcepcionPago extends Exception {
    private String mensaje;

    public ExcepcionPago(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
