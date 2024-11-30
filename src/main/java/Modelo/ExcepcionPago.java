package Modelo;

public class ExcepcionPago extends Exception {
    private String mensaje;

    // Constructor
    public ExcepcionPago(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método para obtener el mensaje de la excepción
    public String getMensaje() {
        return mensaje;
    }
}