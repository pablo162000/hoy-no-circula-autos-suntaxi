package com.conecta.autos.dto;

import java.time.LocalDateTime;

public class CirculacionResponse {
    private String placa;
    private LocalDateTime fechaHora;
    private boolean puedeCircular;
    private String motivo;

    public CirculacionResponse(String placa, LocalDateTime fechaHora, boolean puedeCircular, String motivo) {
        this.placa = placa;
        this.fechaHora = fechaHora;
        this.puedeCircular = puedeCircular;
        this.motivo = motivo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isPuedeCircular() {
        return puedeCircular;
    }

    public void setPuedeCircular(boolean puedeCircular) {
        this.puedeCircular = puedeCircular;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
