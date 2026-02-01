package com.conecta.autos.repository;

import com.conecta.autos.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutoRepository extends JpaRepository<Auto, String> {

    Optional<Auto> findByPlaca(String placa);

    Optional<Auto> findByChasis(String placa);

}
