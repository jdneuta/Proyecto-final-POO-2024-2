package Modelo;

public class Suite extends Habitacion {
    private static final double PRECIO_NOCHE = 200.0;

    public Suite(int id, String descripcion) {
        super(id, 4, descripcion); // Capacidad máxima: 4 personas
    }

    @Override
    public double getPrecioNoche() {
        return PRECIO_NOCHE;
    }

    @Override
    public String getTipo() {
        return "Suite";
    }

    @Override
    public String mostrarInformacion() {
        return "Suite - " + super.mostrarInformacion() +
                ", Precio por noche: $" + PRECIO_NOCHE;
    }
}
