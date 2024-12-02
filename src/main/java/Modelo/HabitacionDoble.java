package Modelo;

public class HabitacionDoble extends Habitacion {
    private static final double PRECIO_NOCHE = 100.0;

    public HabitacionDoble(int id, String descripcion) {
        super(id, 2, descripcion); // Capacidad máxima: 2 personas
    }

    @Override
    public double getPrecioNoche() {
        return PRECIO_NOCHE;
    }

    @Override
    public String getTipo() {
        return "Doble";
    }

    @Override
    public String mostrarInformacion() {
        return "Habitación Doble - " + super.mostrarInformacion() +
                ", Precio por noche: $" + PRECIO_NOCHE;
    }
}
