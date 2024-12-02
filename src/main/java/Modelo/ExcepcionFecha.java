package Modelo;

public class ExcepcionFecha extends Exception {
    private String mensaje;

    public ExcepcionFecha(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
