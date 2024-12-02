package Modelo;

public class Suite extends Habitacion {
    private static final double PRECIO_BASE = 200.0;
    private static final double TARIFA_ADICIONAL = 50.0;

    public Suite(int id, String descripcion) {
        super(id, 4, descripcion);
    }

    @Override
    public double calcularPrecio(int noches) {
        return (PRECIO_BASE + TARIFA_ADICIONAL) * noches;
    }

    @Override
    public String mostrarInformacion() {
        return "Suite - " + super.mostrarInformacion() +
                ", Precio base por noche: $" + PRECIO_BASE +
                ", Tarifa adicional: $" + TARIFA_ADICIONAL;
    }
}
