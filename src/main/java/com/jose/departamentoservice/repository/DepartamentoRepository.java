package com.jose.departamentoservice.repository;

import com.jose.departamentoservice.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
}
