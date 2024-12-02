package Controlador;

import Modelo.Servicio;
import Vista.VistaAdministrador;
import java.util.List;

public class ControladorServicios {
    private VistaAdministrador vista;

    public ControladorServicios(VistaAdministrador vista) {
        this.vista = vista;
    }

    public void gestionarServicios(List<Servicio> servicios) {
        vista.mostrarMensaje("--- Gestión de Servicios ---");
        for (Servicio servicio : servicios) {
            vista.mostrarMensaje("Servicio: " + servicio.getNombreServicio() +
                    ", Descripción: " + servicio.getDescripcion() +
                    ", Precio adicional: $" + servicio.getCostoAdicional() +
                    ", Disponibles: " + servicio.getCantidadDisponible());
        }

        vista.mostrarMensaje("Opciones:");
        vista.mostrarMensaje("1. Agregar servicio");
        vista.mostrarMensaje("2. Modificar servicio");
        vista.mostrarMensaje("3. Eliminar servicio");
        vista.mostrarMensaje("4. Volver");

        int opcion = vista.leerNumero("Seleccione una opción");

        switch (opcion) {
            case 1:
                agregarServicio(servicios);
                break;
            case 2:
                modificarServicio(servicios);
                break;
            case 3:
                eliminarServicio(servicios);
                break;
            case 4:
                vista.mostrarMensaje("Volviendo al menú principal.");
                break;
            default:
                vista.mostrarMensaje("Opción no válida.");
        }
    }

    private void agregarServicio(List<Servicio> servicios) {
        String nombre = vista.leerTexto("Ingrese el nombre del servicio");
        String descripcion = vista.leerTexto("Ingrese la descripción del servicio");
        double costo = vista.leerNumero("Ingrese el costo adicional del servicio");
        int cantidad = vista.leerNumero("Ingrese la cantidad disponible del servicio");

        servicios.add(new Servicio(nombre, descripcion, costo, cantidad));
        vista.mostrarMensaje("Servicio agregado con éxito.");
    }

    private void modificarServicio(List<Servicio> servicios) {
        String nombre = vista.leerTexto("Ingrese el nombre del servicio a modificar");
        Servicio servicio = buscarServicioPorNombre(servicios, nombre);

        if (servicio != null) {
            String nuevaDescripcion = vista.leerTexto("Ingrese la nueva descripción (o presione Enter para mantener la actual)");
            if (!nuevaDescripcion.isEmpty()) {
                servicio.setDescripcion(nuevaDescripcion);
            }
            vista.mostrarMensaje("Servicio modificado con éxito.");
        } else {
            vista.mostrarMensaje("Servicio no encontrado.");
        }
    }

    private void eliminarServicio(List<Servicio> servicios) {
        String nombre = vista.leerTexto("Ingrese el nombre del servicio a eliminar");
        Servicio servicio = buscarServicioPorNombre(servicios, nombre);

        if (servicio != null) {
            servicios.remove(servicio);
            vista.mostrarMensaje("Servicio eliminado con éxito.");
        } else {
            vista.mostrarMensaje("Servicio no encontrado.");
        }
    }

    private Servicio buscarServicioPorNombre(List<Servicio> servicios, String nombre) {
        for (Servicio servicio : servicios) {
            if (servicio.getNombreServicio().equalsIgnoreCase(nombre)) {
                return servicio;
            }
        }
        return null;
    }
}
