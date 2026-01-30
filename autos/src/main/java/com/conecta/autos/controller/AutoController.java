package com.conecta.autos.controller;

import com.conecta.autos.dto.AutoResponse;
import com.conecta.autos.dto.CirculacionResponse;
import com.conecta.autos.entity.Auto;
import com.conecta.autos.repository.AutoRepository;
import com.conecta.autos.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
public class AutoController {

    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private AutoService autoService;

    // Crear
    @PostMapping("/registrar")
    public ResponseEntity<AutoResponse> registrarAuto(@RequestBody Auto auto) {
        AutoResponse response = autoService.registrarAuto(auto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/consultar")
    public ResponseEntity<CirculacionResponse> consultar(
            @RequestParam String placa,
            @RequestParam String fechaHora
    ) {
        CirculacionResponse response = autoService.consultarAuto(placa, fechaHora);
        return ResponseEntity.ok(response);
    }
}
