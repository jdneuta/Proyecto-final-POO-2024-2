package Controlador;

import Modelo.Huesped;
import Modelo.Reserva;
import java.time.LocalDate;
import java.util.List;

public class ValidadorReservas {
    public static void validarFechasReserva(Huesped huesped, LocalDate fechaEntrada, LocalDate fechaSalida) throws Exception {
        List<Reserva> reservas = huesped.verHistorial();

        for (Reserva reserva : reservas) {
            if (fechaEntrada.isBefore(reserva.getFechaSalida()) && fechaSalida.isAfter(reserva.getFechaEntrada())) {
                throw new Exception("Las fechas de la reserva se solapan con una reserva existente.");
            }
        }
    }
}
