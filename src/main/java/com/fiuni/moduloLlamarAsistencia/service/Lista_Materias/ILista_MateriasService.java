package com.fiuni.moduloLlamarAsistencia.service.Lista_Materias;

import com.fiuni.moduloLlamarAsistencia.dto.materias.Lista_MateriasDTO;
import com.fiuni.moduloLlamarAsistencia.dto.materias.Lista_MateriasResult;
import com.fiuni.moduloLlamarAsistencia.service.base.IBaseService;
import org.springframework.http.ResponseEntity;


public interface ILista_MateriasService extends IBaseService<Lista_MateriasDTO, Lista_MateriasResult> {

    public abstract ResponseEntity<Lista_MateriasDTO> update(Integer id, Lista_MateriasDTO dto);

    public abstract ResponseEntity<Boolean> delete(Integer id);
}

