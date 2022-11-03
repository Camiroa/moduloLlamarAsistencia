package com.fiuni.moduloLlamarAsistencia.controller;

import com.fiuni.moduloLlamarAsistencia.dto.portfolio.personas.Lista_AlumnosDTO;
import com.fiuni.moduloLlamarAsistencia.dto.portfolio.personas.Lista_AlumnosResult;
import com.fiuni.moduloLlamarAsistencia.service.Lista_Alumnos.ILista_AlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluaciones")
public class Lista_AlumnosResourse {
    @Autowired(required = true)
    private ILista_AlumnosService lista_alumnosService;

    @GetMapping("/{id}")
    public ResponseEntity<Lista_AlumnosDTO> getById(@PathVariable(value = "id") Integer listaId) {
        return lista_alumnosService.getById(listaId);
    }

    @GetMapping(path = "/page/{page_num}")
    public ResponseEntity<Lista_AlumnosResult> getClients(@PathVariable(value = "page_num")Integer pageNum) {
        return lista_alumnosService.getAll(PageRequest.of(pageNum, 10));
    }

    @PostMapping
    public ResponseEntity<Lista_AlumnosDTO> save(@Validated @RequestBody Lista_AlumnosDTO evaluacion) {
        return lista_alumnosService.save(evaluacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lista_AlumnosDTO> putEtapa(@PathVariable(value = "id") Integer id, @RequestBody Lista_AlumnosDTO dto) {
        return lista_alumnosService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> putEtapa(@PathVariable(value = "id") Integer id) {
        return lista_alumnosService.delete(id);
    }

}
