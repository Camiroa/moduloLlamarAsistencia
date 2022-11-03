package com.fiuni.moduloLlamarAsistencia.controller;

import com.fiuni.moduloLlamarAsistencia.dto.portfolio.materias.Lista_MateriasDTO;
import com.fiuni.moduloLlamarAsistencia.dto.portfolio.materias.Lista_MateriasResult;
import com.fiuni.moduloLlamarAsistencia.service.Lista_Materias.ILista_MateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/etapas")
public class Lista_MateriasResourse {

    @Autowired
    private ILista_MateriasService lista_materiasService;

    @GetMapping("/{id}")
    public ResponseEntity<Lista_MateriasDTO> getById(@PathVariable(value = "id") Integer cityId) {
        return lista_materiasService.getById(cityId);
    }

    @GetMapping(path = "/page/{page_num}")
    public ResponseEntity<Lista_MateriasResult> getClients(@PathVariable(value = "page_num")Integer pageNum) {
        return lista_materiasService.getAll(PageRequest.of(pageNum, 10));
    }

    @PostMapping
    public ResponseEntity<Lista_MateriasDTO> save(@Validated @RequestBody Lista_MateriasDTO etapa) {
        return lista_materiasService.save(etapa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lista_MateriasDTO> putEtapa(@PathVariable(value = "id") Integer id, @RequestBody Lista_MateriasDTO dto) {
        return lista_materiasService.update(id, dto);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Boolean> deleteEtapa(@PathVariable(value = "id") Integer id) {
        return lista_materiasService.delete(id);
    }
}
