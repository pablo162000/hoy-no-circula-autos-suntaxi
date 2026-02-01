package com.conecta.autos.dto;

public class AutoDto {

    private Long id;
    private String placa;
    private String color;
    private String modelo;
    private String chasis;

    public AutoDto(Long id, String placa, String color, String modelo, String chasis) {
        this.id = id;
        this.placa = placa;
        this.color = color;
        this.modelo = modelo;
        this.chasis = chasis;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }
}
