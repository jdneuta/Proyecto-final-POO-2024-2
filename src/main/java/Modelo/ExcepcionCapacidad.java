package Modelo;

public class ExcepcionCapacidad extends Exception {
    private String mensaje;

    public ExcepcionCapacidad(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
