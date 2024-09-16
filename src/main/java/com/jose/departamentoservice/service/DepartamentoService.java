package com.jose.departamentoservice.service;

import com.jose.departamentoservice.model.Departamento;
import com.jose.departamentoservice.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }
    public Optional<Departamento> findById(int id) {
        return departamentoRepository.findById(id);
    }
    public void save(Departamento servidor) {
        departamentoRepository.save(servidor);


    }
    public void delete(int id) {
        departamentoRepository.delete(departamentoRepository.findById(id).get());
    }
    public void update(int id, Departamento departamento) {
        departamentoRepository.save(departamento);
    }
}
