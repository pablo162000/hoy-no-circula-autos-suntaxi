package com.conecta.autos.service;

import com.conecta.autos.dto.AutoDto;
import com.conecta.autos.dto.AutoResponse;
import com.conecta.autos.dto.CirculacionResponse;
import com.conecta.autos.entity.Auto;
import java.time.LocalDateTime;
import java.util.List;

public interface AutoService {
    AutoResponse registrarAuto(Auto auto);
    CirculacionResponse consultarAuto(String placa, LocalDateTime fechaHora);
    List<AutoDto> listarAutos();



}
