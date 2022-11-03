package com.fiuni.moduloLlamarAsistencia.service.Detalles_PA;


import com.fiuni.moduloLlamarAsistencia.dto.portfolio.planilla.Detalles_PADTO;
import com.fiuni.moduloLlamarAsistencia.dto.portfolio.planilla.Detalles_PAResult;
import com.fiuni.moduloLlamarAsistencia.service.base.IBaseService;
import org.springframework.http.ResponseEntity;

public interface IDetalles_PAService extends IBaseService<Detalles_PADTO, Detalles_PAResult> {

    public abstract ResponseEntity<Detalles_PADTO> update(Integer id, Detalles_PADTO dto);

    public abstract ResponseEntity<Boolean> delete(Integer id);

    //public abstract ResponseEntity<Integer> fullDelete(Integer id);
}
