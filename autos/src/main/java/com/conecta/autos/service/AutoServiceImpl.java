package com.conecta.autos.service;

import com.conecta.autos.dto.AutoDto;
import com.conecta.autos.dto.AutoResponse;
import com.conecta.autos.dto.CirculacionResponse;
import com.conecta.autos.exception.*;
import com.conecta.autos.entity.Auto;
import com.conecta.autos.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoRepository autoRepository;

    @Override
    public CirculacionResponse consultarAuto(String placa, LocalDateTime fechaConsulta) {

        validarPlaca(placa);

        Auto auto = autoRepository.findByPlaca(placa)
                .orElseThrow(() ->
                        new AutoNotFoundException(
                                "El auto con placa " + placa + " no fue encontrado"
                        )
                );

        if (fechaConsulta.isBefore(LocalDateTime.now())) {
            throw new InvalidFechaException("La fecha no puede ser anterior a la fecha actual");
        }

        char ultimoCaracter = placa.charAt(placa.length() - 1);
        if (!Character.isDigit(ultimoCaracter)) {
            throw new InvalidPlacaException("La placa no termina en un número válido");
        }

        int ultimoNumeroPlaca = Character.getNumericValue(ultimoCaracter);
        int dia = fechaConsulta.getDayOfWeek().getValue();

        if (dia > 5) {
            return new CirculacionResponse(
                    placa,
                    fechaConsulta,
                    true,
                    "Libre circulación (fin de semana)"
            );
        }

        boolean tienePicoYPlaca = !puedeCircularPorPicoYPlaca(dia, ultimoNumeroPlaca);

        if (tienePicoYPlaca && estaEnRestriccionHorario(fechaConsulta)) {
            return new CirculacionResponse(
                    placa,
                    fechaConsulta,
                    false,
                    "Restricción de Pico y Placa por horario"
            );
        }

        return new CirculacionResponse(
                placa,
                fechaConsulta,
                true,
                "Libre circulación"
        );
    }

    @Override
    public List<AutoDto> listarAutos() {
        return autoRepository.findAll()
                .stream()
                .map(auto -> new AutoDto(
                        auto.getId(),
                        auto.getPlaca(),
                        auto.getColor(),
                        auto.getModelo(),
                        auto.getChasis()
                ))
                .toList();
    }

    // verificar si el auto puede circular según la restricción de Pico y Placa
    private boolean puedeCircularPorPicoYPlaca(int diaDeLaSemana, int ultimoNumeroPlaca) {
        boolean puedeCircular = true;  // Inicializamos en true

        switch (diaDeLaSemana) {
            case 1:  // Lunes
                if (ultimoNumeroPlaca == 1 || ultimoNumeroPlaca == 2) {
                    puedeCircular = false;
                }
                break;
            case 2:  // Martes
                if (ultimoNumeroPlaca == 3 || ultimoNumeroPlaca == 4) {
                    puedeCircular = false;
                }
                break;
            case 3:  // Miércoles
                if (ultimoNumeroPlaca == 5 || ultimoNumeroPlaca == 6) {
                    puedeCircular = false;
                }
                break;
            case 4:  // Jueves
                if (ultimoNumeroPlaca == 7 || ultimoNumeroPlaca == 8) {
                    puedeCircular = false;
                }
                break;
            case 5:  // Viernes
                if (ultimoNumeroPlaca == 9 || ultimoNumeroPlaca == 0) {
                    puedeCircular = false;
                }
                break;
            default:  // Sábados, domingos y feriados
                puedeCircular = true;  // Libre circulación
                break;
        }
        return puedeCircular;
    }

    // verificar si la hora está dentro de los horarios de restricción
    private boolean estaEnRestriccionHorario(LocalDateTime fechaConsulta) {
        int hora = fechaConsulta.getHour();
        int minuto = fechaConsulta.getMinute();

        // Restricción de mañana: de 06:00 a 09:30
        boolean restriccionManana = (hora >= 6 && hora < 9) || (hora == 9 && minuto <= 30);
        // Restricción de tarde: de 16:00 a 20:00
        boolean restriccionTarde = (hora >= 16 && hora < 20);

        return restriccionManana || restriccionTarde;
    }

    @Override
    public AutoResponse registrarAuto(Auto auto) {  // Verificar si la placa y chasis ya existe en la base de datos
        validarPlaca(auto.getPlaca());

        if (autoRepository.findByPlaca(auto.getPlaca()).isPresent()) {
            throw new AutoConflictException("El auto con placa " + auto.getPlaca() + " ya está registrado.");
        }

        if (autoRepository.findByChasis(auto.getChasis()).isPresent()) {
            throw new AutoConflictException("El auto con chasis " + auto.getChasis() + " ya está registrado.");
        }

        Auto autoGuardado = autoRepository.save(auto);

        return new AutoResponse(
                autoGuardado.getId(),
                autoGuardado.getPlaca(),
                autoGuardado.getChasis(),
                "Auto registrado exitosamente"
        );
    }

    private void validarPlaca(String placa) {
        String regex = "^[A-Z]{3}-?\\d{4}$";

        if (!placa.matches(regex)) {
            throw new InvalidPlacaException(
                    "Formato de placa inválido. Use ABC-1234 o ABC1234"
            );
        }
    }
}
