package com.fiuni.moduloLlamarAsistencia.controller;

import com.fiuni.moduloLlamarAsistencia.dto.planilla.Planilla_AsistenciasDTO;
import com.fiuni.moduloLlamarAsistencia.dto.planilla.Planilla_AsistenciasResult;
import com.fiuni.moduloLlamarAsistencia.service.Planilla_Asistencias.IPlanilla_AsistenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asistencia")
public class Planilla_AsistenciasResourse {
    @Autowired
    private IPlanilla_AsistenciasService planilla_AsistenciasService;

    @GetMapping("/{id}")
    public ResponseEntity<Planilla_AsistenciasDTO> getById(@PathVariable(value="id") Integer planillaId){
        return planilla_AsistenciasService.getById(planillaId);
    }

    @GetMapping(path = "/page/{page_num}")
    public ResponseEntity<Planilla_AsistenciasResult> getPages(@PathVariable(value = "page_num")Integer pageNum) {
        return planilla_AsistenciasService.getAll(PageRequest.of(pageNum, 10));
    }


    @PostMapping
    public ResponseEntity<Planilla_AsistenciasDTO> save(@Validated @RequestBody Planilla_AsistenciasDTO planilla) {
        return planilla_AsistenciasService.save(planilla);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Planilla_AsistenciasDTO> putPlanilla(@PathVariable(value = "id") Integer id, @RequestBody Planilla_AsistenciasDTO dto) {
        return planilla_AsistenciasService.update(id, dto);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Boolean> deletePlanilla(@PathVariable(value = "id") Integer id) {
        return planilla_AsistenciasService.delete(id);
    }

   // @DeleteMapping("/fullDelete/{id}")
   // public ResponseEntity<Integer> fullDeletePlanilla(@PathVariable(value = "id") Integer id){
    //    return planillaAsistenciasService.fullDelete(id);
   // }
}