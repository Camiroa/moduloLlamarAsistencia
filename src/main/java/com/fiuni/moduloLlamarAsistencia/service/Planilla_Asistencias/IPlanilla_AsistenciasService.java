package com.fiuni.moduloLlamarAsistencia.service.Planilla_Asistencias;

import com.fiuni.moduloLlamarAsistencia.dto.planilla.Planilla_Asistencia_Materia_DTO;
import com.fiuni.moduloLlamarAsistencia.dto.planilla.Planilla_AsistenciasDTO;
import com.fiuni.moduloLlamarAsistencia.dto.planilla.Planilla_AsistenciasResult;
import com.fiuni.moduloLlamarAsistencia.service.base.IBaseService;
import org.springframework.http.ResponseEntity;


public interface IPlanilla_AsistenciasService extends IBaseService<Planilla_AsistenciasDTO, Planilla_AsistenciasResult> {


    public Boolean updateDetalles(Planilla_AsistenciasDTO dto);

    public abstract ResponseEntity<Planilla_AsistenciasDTO> update(Integer id, Planilla_AsistenciasDTO dto);

    public abstract ResponseEntity<Boolean> delete(Integer id);
    public ResponseEntity<Planilla_Asistencia_Materia_DTO> getByIdListaMateria(Integer id);

}
