package com.fiuni.moduloLlamarAsistencia.controller;

import com.fiuni.moduloLlamarAsistencia.dto.materias.Lista_MateriasDTO;
import com.fiuni.moduloLlamarAsistencia.dto.materias.Lista_MateriasResult;
import com.fiuni.moduloLlamarAsistencia.service.Lista_Materias.ILista_MateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listas/materias")
public class Lista_MateriasResourse {

    @Autowired
    private ILista_MateriasService lista_materiasService;

    @GetMapping("/{id}")
    public ResponseEntity<Lista_MateriasDTO> getById(@PathVariable(value = "id") Integer idList) {
        return lista_materiasService.getById(idList);
    }

    @GetMapping(path = "/page/{page_num}")
    public ResponseEntity<Lista_MateriasResult> getPage(@PathVariable(value = "page_num")Integer pageNum) {
        return lista_materiasService.getAll(PageRequest.of(pageNum, 10));
    }

    @PostMapping
    public ResponseEntity<Lista_MateriasDTO> save(@Validated @RequestBody Lista_MateriasDTO listaMats) {
        return lista_materiasService.save(listaMats);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lista_MateriasDTO> putListaMaterias(@PathVariable(value = "id") Integer id, @RequestBody Lista_MateriasDTO dto) {
        return lista_materiasService.update(id, dto);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Boolean> deleteLista(@PathVariable(value = "id") Integer id) {
        return lista_materiasService.delete(id);
    }
}
