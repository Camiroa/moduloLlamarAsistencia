package com.fiuni.moduloLlamarAsistencia.service.base;


import com.fiuni.moduloLlamarAsistencia.dto.base.*;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface IBaseService<DTO extends BaseDTO, R extends BaseResult<DTO>> {
    public ResponseEntity<DTO> save(DTO dto);

    public ResponseEntity<DTO> getById(Integer id);

    public ResponseEntity<R> getAll(Pageable pageable);

}
