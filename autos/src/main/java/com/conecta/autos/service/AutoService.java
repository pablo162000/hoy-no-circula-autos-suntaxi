package com.conecta.autos.service;

import com.conecta.autos.dto.AutoResponse;
import com.conecta.autos.dto.CirculacionResponse;
import com.conecta.autos.entity.Auto;

public interface AutoService {
    AutoResponse registrarAuto(Auto auto);
    CirculacionResponse consultarAuto(String placa, String fechaHora);



}
