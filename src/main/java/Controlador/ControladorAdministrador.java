package Controlador;

import Vista.VistaAdministrador;

public class ControladorAdministrador {
    private VistaAdministrador vista;

    // Constructor que recibe una instancia de VistaAdministrador
    public ControladorAdministrador(VistaAdministrador vista) {
        this.vista = vista;
    }

    // Método privado que devuelve una instancia de VistaAdministrador
    private VistaAdministrador vistaAdministrador() {
        return vista;
    }

    // Método público para registrar un nuevo administrador
    public void registrarAdministrador() {
        // Lógica para registrar un administrador
        vistaAdministrador().registrar();
    }

    // Método público para modificar los datos de un administrador
    public void modificarAdministrador() {
        // Lógica para modificar un administrador
        vistaAdministrador().modificar();
    }
}