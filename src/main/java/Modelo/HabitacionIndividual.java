package Modelo;

public class HabitacionIndividual extends Habitacion {
    private static final double PRECIO_BASE = 50.0;

    public HabitacionIndividual(int id, String descripcion) {
        super(id, 1, descripcion);
    }

    @Override
    public double calcularPrecio(int noches) {
        return PRECIO_BASE * noches;
    }

    @Override
    public String mostrarInformacion() {
        return "Habitación Individual - " + super.mostrarInformacion() +
                ", Precio por noche: $" + PRECIO_BASE;
    }
}
