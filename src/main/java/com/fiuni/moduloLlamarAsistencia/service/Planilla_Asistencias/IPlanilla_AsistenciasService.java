package com.fiuni.moduloLlamarAsistencia.service.Planilla_Asistencias;

import com.fiuni.moduloLlamarAsistencia.dto.portfolio.planilla.Planilla_AsistenciasDTO;
import com.fiuni.moduloLlamarAsistencia.dto.portfolio.planilla.Planilla_AsistenciasResult;
import com.fiuni.moduloLlamarAsistencia.service.base.IBaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

public interface IPlanilla_AsistenciasService extends IBaseService<Planilla_AsistenciasDTO, Planilla_AsistenciasResult> {

    public abstract ResponseEntity<Planilla_AsistenciasDTO> update(Integer id, Planilla_AsistenciasDTO dto);

    public abstract ResponseEntity<Boolean> delete(Integer id);

    //public abstract ResponseEntity<Integer> fullDelete(Integer id);
}
