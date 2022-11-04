package com.fiuni.moduloLlamarAsistencia.service.Lista_Alumnos;

import com.fiuni.moduloLlamarAsistencia.dto.alumnos.Lista_AlumnosDTO;
import com.fiuni.moduloLlamarAsistencia.dto.alumnos.Lista_AlumnosResult;
import com.fiuni.moduloLlamarAsistencia.service.base.IBaseService;
import org.springframework.http.ResponseEntity;


public interface ILista_AlumnosService extends IBaseService<Lista_AlumnosDTO, Lista_AlumnosResult> {

    public abstract ResponseEntity<Lista_AlumnosDTO> update(Integer id, Lista_AlumnosDTO dto);

    public abstract ResponseEntity<Boolean> delete(Integer id);
}

