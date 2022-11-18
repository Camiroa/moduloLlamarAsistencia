package com.fiuni.moduloLlamarAsistencia.dao.persona;

import com.library.domainLibrary.domain.persona.PersonaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonaDao extends CrudRepository<PersonaDomain, Integer> {
    public Page<PersonaDomain> findAll(Pageable pageable);

}
