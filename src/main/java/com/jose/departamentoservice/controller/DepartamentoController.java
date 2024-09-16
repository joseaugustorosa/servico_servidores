package com.jose.departamentoservice.controller;

import com.jose.departamentoservice.model.Departamento;
import com.jose.departamentoservice.service.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService departamentoService;
    @GetMapping
    public ResponseEntity<List<Departamento>> getAll(@RequestParam(required = false) Optional<String> nome) {

        if (nome.isEmpty()) {
//            Log log = new Log();
//            log.setMensagem("Listando servidores!");
//            log.setData(LocalDate.from(LocalDateTime.now()));
//            logService.save(log);
            return ResponseEntity.ok(departamentoService.findAll());
        }else {
//            List<Servidor> servidores = servidorService.findById(nome.get());
//            if (servidores.isEmpty()) {
//
//                return ResponseEntity.noContent().build();
//            }else {
//                return ResponseEntity.ok(servidores);
//            }
            return  ResponseEntity.noContent().build();
        }

    }
    @PostMapping
    public  ResponseEntity<Departamento>  save(@RequestBody Departamento departamento){

        departamentoService.save(departamento);
//        Log log = new Log();
//        log.setMensagem("Novo servidor criado!");
//        log.setData(LocalDate.from(LocalDateTime.now()));
//        logService.save(log);
        return ResponseEntity.status(HttpStatus.CREATED).body(departamento);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Departamento> delete(@PathVariable Integer id){
        try {
            departamentoService.delete(id);
//            Log log = new Log();
//            log.setMensagem("Servidor deletado!");
//            log.setData(LocalDate.from(LocalDateTime.now()));
//            logService.save(log);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Departamento> update(@PathVariable Integer id, @RequestBody Departamento servidor){
        try {
            departamentoService.update(id, servidor);
//            Log log = new Log();
//            log.setMensagem("Servidor alterado!");
//            log.setData(LocalDate.from(LocalDateTime.now()));
//            logService.save(log);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(servidor);
        } catch (Exception e) {
//            Log log = new Log();
//            log.setMensagem("Nenhum servidor achado para edição!");
//            log.setData(LocalDate.from(LocalDateTime.now()));
//            logService.save(log);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
