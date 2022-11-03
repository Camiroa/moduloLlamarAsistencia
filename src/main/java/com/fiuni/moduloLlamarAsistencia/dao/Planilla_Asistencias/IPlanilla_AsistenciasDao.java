package com.fiuni.moduloLlamarAsistencia.dao.Planilla_Asistencias;

import com.library.domainLibrary.domain.planillaAsistencia.PlanillaAsistenciaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPlanilla_AsistenciasDao extends CrudRepository<PlanillaAsistenciaDomain, Integer> {
    public Page<PlanillaAsistenciaDomain> findAll(Pageable pageable);


    Boolean delete(Integer id);

    //Integer fullDelete(Integer id);
}
