package com.conecta.autos.dto;

public class AutoResponse {
    private Long id;
    private String placa;
    private String chasis;
    private String mensaje;

    public AutoResponse(Long id, String placa, String chasis, String mensaje) {
        this.id = id;
        this.placa = placa;
        this.chasis = chasis;
        this.mensaje = mensaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
