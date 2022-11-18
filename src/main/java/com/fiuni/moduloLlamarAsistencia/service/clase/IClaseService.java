package com.fiuni.moduloLlamarAsistencia.service.clase;

import com.fiuni.moduloLlamarAsistencia.dto.clase.ClaseDTO;
import com.fiuni.moduloLlamarAsistencia.dto.clase.ClaseResult;
import com.fiuni.moduloLlamarAsistencia.service.base.IBaseService;

public interface IClaseService extends IBaseService<ClaseDTO, ClaseResult> {

    public abstract ClaseDTO update(Integer id, ClaseDTO dto);

    public abstract Boolean delete(Integer id);
}