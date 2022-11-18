package com.fiuni.moduloLlamarAsistencia.service.Lista_Alumnos;

import com.fiuni.moduloLlamarAsistencia.dto.alumnos.Lista_AlumnosDTO;
import com.fiuni.moduloLlamarAsistencia.dto.alumnos.Lista_AlumnosResult;
import com.fiuni.moduloLlamarAsistencia.dto.personas.PersonaDTO;
import com.fiuni.moduloLlamarAsistencia.dto.personas.PersonaResult;
import com.fiuni.moduloLlamarAsistencia.service.base.IBaseService;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ILista_AlumnosService extends IBaseService<Lista_AlumnosDTO, Lista_AlumnosResult> {

    public abstract ResponseEntity<Lista_AlumnosDTO> update(Integer id, Lista_AlumnosDTO dto);

    public abstract ResponseEntity<Boolean> delete(Integer id);

    ResponseEntity<PersonaResult> getListAlumnos(Integer idClase);

    List<PersonaDTO> getAlumnos(Integer idClase);
}

