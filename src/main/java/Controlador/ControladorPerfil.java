package Controlador;

import Modelo.Huesped;
import Vista.VistaHuesped;

public class ControladorPerfil {
    private VistaHuesped vista;

    public ControladorPerfil(VistaHuesped vista) {
        this.vista = vista;
    }

    public void modificarPerfil(Huesped huesped) {
        vista.mostrarMensaje("Modificando perfil del huésped...");

        // Pedir el nuevo nombre
        String nuevoNombre = vista.leerTexto("Ingrese el nuevo nombre (o presione Enter para mantener el actual)");
        if (!nuevoNombre.isEmpty()) {
            huesped.setNombre(nuevoNombre);
        }

        // Pedir el nuevo correo
        String nuevoCorreo = vista.leerTexto("Ingrese el nuevo correo (o presione Enter para mantener el actual)");
        if (!nuevoCorreo.isEmpty()) {
            huesped.setCorreo(nuevoCorreo);
        }

        // Pedir el nuevo teléfono
        String nuevoTelefono = vista.leerTexto("Ingrese el nuevo teléfono (o presione Enter para mantener el actual)");
        if (!nuevoTelefono.isEmpty()) {
            huesped.setTelefono(nuevoTelefono);
        }

        vista.mostrarMensaje("Perfil actualizado con éxito.");
    }
}
