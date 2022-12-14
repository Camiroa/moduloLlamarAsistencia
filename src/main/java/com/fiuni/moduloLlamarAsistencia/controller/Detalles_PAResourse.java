package com.fiuni.moduloLlamarAsistencia.controller;

import com.fiuni.moduloLlamarAsistencia.dto.detalles.Detalles_PADTO;
import com.fiuni.moduloLlamarAsistencia.dto.detalles.Detalles_PAResult;
import com.fiuni.moduloLlamarAsistencia.service.Detalles_PA.IDetalles_PAService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/asistencia/detalle")
public class Detalles_PAResourse {
    @Autowired(required = true)
    private IDetalles_PAService detalles_paService;

    @GetMapping("/{id}")
    public ResponseEntity<Detalles_PADTO> getById(@PathVariable(value="id") Integer detallea){
        return detalles_paService.getById(detallea);
    }

    @GetMapping(path = "/page/{page_num}")
    public ResponseEntity<Detalles_PAResult> getPages(@PathVariable(value = "page_num")Integer pageNum) {
        return detalles_paService.getAll(PageRequest.of(pageNum, 10));
    }


    @PostMapping
    public ResponseEntity<Detalles_PADTO> save(@Validated @RequestBody Detalles_PADTO deta) {
        return detalles_paService.save(deta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Detalles_PADTO> putDetalle(@PathVariable(value = "id") Integer id, @RequestBody Detalles_PADTO dto) {
        return detalles_paService.update(id, dto);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Boolean> deleteDetalle(@PathVariable(value = "id") Integer id) {
        return detalles_paService.delete(id);
    }

}



