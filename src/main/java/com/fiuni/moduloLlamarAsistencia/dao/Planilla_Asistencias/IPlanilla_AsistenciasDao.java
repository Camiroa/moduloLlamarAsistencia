package com.fiuni.moduloLlamarAsistencia.dao.Planilla_Asistencias;

import com.fiuni.moduloLlamarAsistencia.dto.detalles.Detalles_PADTO;
import com.library.domainLibrary.domain.planillaAsistencia.PlanillaAsistenciaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface IPlanilla_AsistenciasDao extends CrudRepository<PlanillaAsistenciaDomain, Integer> {
    public Page<PlanillaAsistenciaDomain> findAll(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PlanillaAsistenciaDomain SET estado = 0 WHERE id = ?1")
    Integer delete(Integer id);


    @Modifying//(clearAutomatically = true, flushAutomatically = true)
    @Transactional(propagation= Propagation.SUPPORTS, readOnly = true)
    @Query(value = "UPDATE PlanillaAsistenciaDomain SET fecha = ?1, estado = ?2 WHERE id = ?3")
    public Integer updateAsistencia(LocalDate fecha, Boolean estado, Integer id);
    //@Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<PlanillaAsistenciaDomain> findAllByIdListaMateria(Integer idListaMateria);
    //Integer fullDelete(Integer id);
}
