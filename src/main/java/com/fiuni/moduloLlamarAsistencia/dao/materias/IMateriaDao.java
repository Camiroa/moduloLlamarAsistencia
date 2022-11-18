package com.fiuni.moduloLlamarAsistencia.dao.materias;

import com.library.domainLibrary.domain.materia.MateriaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IMateriaDao extends CrudRepository<MateriaDomain, Integer> {
    public Page<MateriaDomain> findAll(Pageable pageable);


}
