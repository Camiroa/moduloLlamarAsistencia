package com.fiuni.moduloLlamarAsistencia.dao.Planilla_Asistencias;

import com.library.domainLibrary.domain.planillaAsistencia.PlanillaAsistenciaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IPlanilla_AsistenciasDao extends CrudRepository<PlanillaAsistenciaDomain, Integer> {
    public Page<PlanillaAsistenciaDomain> findAll(Pageable pageable);

    @Query(value = "UPDATE PlanillaAsistenciaDomain SET estado = 0 WHERE id = ?1")
    Boolean delete(Integer id);


    public List<PlanillaAsistenciaDomain> findAllByIdListaMateria(Integer idListaMateria);
    //Integer fullDelete(Integer id);
}
