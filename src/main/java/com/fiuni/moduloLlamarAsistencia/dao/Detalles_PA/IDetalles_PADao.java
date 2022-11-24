package com.fiuni.moduloLlamarAsistencia.dao.Detalles_PA;

import com.fiuni.moduloLlamarAsistencia.dto.detalles.Detalles_PADTO;
import com.library.domainLibrary.domain.detallePA.DetallePlanillaAsistenciaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IDetalles_PADao extends CrudRepository<DetallePlanillaAsistenciaDomain, Integer> {
    public Page<DetallePlanillaAsistenciaDomain> findAll(Pageable pageable);



    @Modifying//(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query(value = "UPDATE DetallePlanillaAsistenciaDomain SET asistencia = ?1, estado = ?2, justificativo = ?3 WHERE id = ?4")
    public Integer updateDetalle(char asistencia, Boolean estado, String justificativo, Integer id);
}