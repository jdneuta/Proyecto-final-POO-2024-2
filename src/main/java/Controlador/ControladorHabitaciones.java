package Controlador;

import Modelo.Habitacion;
import Modelo.HabitacionDoble;
import Modelo.HabitacionIndividual;
import Modelo.Suite;
import Vista.VistaAdministrador;
import java.util.List;

public class ControladorHabitaciones {
    private VistaAdministrador vista;

    public ControladorHabitaciones(VistaAdministrador vista) {
        this.vista = vista;
    }

    public void gestionarHabitaciones(List<Habitacion> habitaciones) {
        vista.mostrarMensaje("--- Gestión de Habitaciones ---");
        for (Habitacion habitacion : habitaciones) {
            vista.mostrarMensaje(habitacion.mostrarInformacion());
        }

        vista.mostrarMensaje("Opciones:");
        vista.mostrarMensaje("1. Agregar habitación");
        vista.mostrarMensaje("2. Modificar habitación");
        vista.mostrarMensaje("3. Eliminar habitación");
        vista.mostrarMensaje("4. Volver");

        int opcion = vista.leerNumero("Seleccione una opción");

        switch (opcion) {
            case 1:
                agregarHabitacion(habitaciones);
                break;
            case 2:
                modificarHabitacion(habitaciones);
                break;
            case 3:
                eliminarHabitacion(habitaciones);
                break;
            case 4:
                vista.mostrarMensaje("Volviendo al menú principal.");
                break;
            default:
                vista.mostrarMensaje("Opción no válida.");
        }
    }

    private void agregarHabitacion(List<Habitacion> habitaciones) {
        int id = vista.leerNumero("Ingrese el ID de la habitación");
        String tipo = vista.leerTexto("Ingrese el tipo de habitación (Individual, Doble, Suite)");
        String descripcion = vista.leerTexto("Ingrese la descripción de la habitación");

        switch (tipo.toLowerCase()) {
            case "individual":
                habitaciones.add(new HabitacionIndividual(id, descripcion));
                break;
            case "doble":
                habitaciones.add(new HabitacionDoble(id, descripcion));
                break;
            case "suite":
                habitaciones.add(new Suite(id, descripcion));
                break;
            default:
                vista.mostrarMensaje("Tipo de habitación no válido. Operación cancelada.");
                return;
        }

        vista.mostrarMensaje("Habitación agregada con éxito.");
    }

    private void modificarHabitacion(List<Habitacion> habitaciones) {
        int id = vista.leerNumero("Ingrese el ID de la habitación a modificar");
        Habitacion habitacion = buscarHabitacionPorId(habitaciones, id);

        if (habitacion != null) {
            String nuevaDescripcion = vista.leerTexto("Ingrese la nueva descripción (o presione Enter para mantener la actual)");
            if (!nuevaDescripcion.isEmpty()) {
                habitacion.setDescripcion(nuevaDescripcion);
            }
            vista.mostrarMensaje("Habitación modificada con éxito.");
        } else {
            vista.mostrarMensaje("Habitación no encontrada.");
        }
    }

    private void eliminarHabitacion(List<Habitacion> habitaciones) {
        int id = vista.leerNumero("Ingrese el ID de la habitación a eliminar");
        Habitacion habitacion = buscarHabitacionPorId(habitaciones, id);

        if (habitacion != null) {
            habitaciones.remove(habitacion);
            vista.mostrarMensaje("Habitación eliminada con éxito.");
        } else {
            vista.mostrarMensaje("Habitación no encontrada.");
        }
    }

    private Habitacion buscarHabitacionPorId(List<Habitacion> habitaciones, int id) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getId() == id) {
                return habitacion;
            }
        }
        return null;
    }
}
