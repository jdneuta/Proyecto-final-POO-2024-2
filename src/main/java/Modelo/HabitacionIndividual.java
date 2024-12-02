package Modelo;

public class HabitacionIndividual extends Habitacion {
    private static final double PRECIO_NOCHE = 50.0;

    public HabitacionIndividual(int id, String descripcion) {
        super(id, 1, descripcion); // Capacidad máxima: 1 persona
    }

    @Override
    public double getPrecioNoche() {
        return PRECIO_NOCHE;
    }

    @Override
    public String getTipo() {
        return "Individual";
    }

    @Override
    public String mostrarInformacion() {
        return "Habitación Individual - " + super.mostrarInformacion() +
                ", Precio por noche: $" + PRECIO_NOCHE;
    }
}
