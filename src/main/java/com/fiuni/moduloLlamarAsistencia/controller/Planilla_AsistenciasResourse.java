package com.fiuni.moduloLlamarAsistencia.controller;

import com.fiuni.moduloLlamarAsistencia.dto.planilla.Planilla_Asistencia_Materia_DTO;
import com.fiuni.moduloLlamarAsistencia.dto.planilla.Planilla_AsistenciasDTO;
import com.fiuni.moduloLlamarAsistencia.dto.planilla.Planilla_AsistenciasResult;
import com.fiuni.moduloLlamarAsistencia.service.Planilla_Asistencias.IPlanilla_AsistenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asistencia")
public class Planilla_AsistenciasResourse {
    @Autowired
    private IPlanilla_AsistenciasService planilla_AsistenciasService;
    @CrossOrigin(origins="*")
    @GetMapping("/{id}")
    public ResponseEntity<Planilla_Asistencia_Materia_DTO> getByListaMateriasId(@PathVariable(value="id") Integer idListaMateria){
        return planilla_AsistenciasService.getByIdListaMateria(idListaMateria);
    }

    @GetMapping("/simple/{id}")
    public ResponseEntity<Planilla_AsistenciasDTO> getById(@PathVariable(value="id") Integer planillaId){
        return planilla_AsistenciasService.getById(planillaId);
    }
    @GetMapping(path = "/page/{page_num}")
    public ResponseEntity<Planilla_AsistenciasResult> getPages(@PathVariable(value = "page_num")Integer pageNum) {
        return planilla_AsistenciasService.getAll(PageRequest.of(pageNum, 10));
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Planilla_AsistenciasDTO> save(@Validated @RequestBody Planilla_AsistenciasDTO planilla) {
        return planilla_AsistenciasService.save(planilla);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/actualizar")
    public ResponseEntity<Boolean> putDetallesActualizados(@RequestBody Planilla_AsistenciasDTO dto) {
        try {
            return planilla_AsistenciasService.updateDetalles(dto)
                    ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
                    : new ResponseEntity<>(HttpStatus.CONFLICT);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Planilla_AsistenciasDTO> putPlanilla(@PathVariable(value = "id") Integer id, @RequestBody Planilla_AsistenciasDTO dto) {
        return planilla_AsistenciasService.update(id, dto);
    }
    @CrossOrigin(origins="*")
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Boolean> deletePlanilla(@PathVariable(value = "id") Integer id) {
        return planilla_AsistenciasService.delete(id);
    }

   // @DeleteMapping("/fullDelete/{id}")
   // public ResponseEntity<Integer> fullDeletePlanilla(@PathVariable(value = "id") Integer id){
    //    return planillaAsistenciasService.fullDelete(id);
   // }
}