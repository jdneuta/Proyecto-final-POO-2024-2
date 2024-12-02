package Modelo;

public class HabitacionDoble extends Habitacion {
    private static final double PRECIO_BASE = 100.0;

    public HabitacionDoble(int id, String descripcion) {
        super(id, 2, descripcion);
    }

    @Override
    public double calcularPrecio(int noches) {
        return PRECIO_BASE * noches;
    }

    @Override
    public String mostrarInformacion() {
        return "Habitación Doble - " + super.mostrarInformacion() +
                ", Precio por noche: $" + PRECIO_BASE;
    }
}
