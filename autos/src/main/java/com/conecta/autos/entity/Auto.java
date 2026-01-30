package com.conecta.autos.entity;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"placa", "chasis"})
})
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Esto es para generar un ID automáticamente si lo necesitas
    private Long id;
    @Column(unique = true)  //valor unico
    private String placa;
    private String color;
    private String modelo;
    @Column(unique = true)
    private String chasis;


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
