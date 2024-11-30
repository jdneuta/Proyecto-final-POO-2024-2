package Controlador;

import Vista.VistaHuesped;

public class ControladorHuesped {
    private VistaHuesped vista;

    // Constructor que recibe una instancia de VistaHuesped
    public ControladorHuesped(VistaHuesped vista) {
        this.vista = vista;
    }

    // Método privado que devuelve una instancia de VistaHuesped
    private VistaHuesped vistaHuesped() {
        return vista;
    }

    // Método público para registrar un nuevo huésped
    public void registrarHuesped() {
        // Lógica para registrar un huésped
        vistaHuesped().registrar();
    }

    // Método público para modificar los datos de un huésped
    public void modificarHuesped() {
        // Lógica para modificar un huésped
        vistaHuesped().modificar();
    }
}