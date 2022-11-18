package com.fiuni.moduloLlamarAsistencia.dao.clase;

import com.library.domainLibrary.domain.clase.ClaseDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClaseDao extends CrudRepository<ClaseDomain, Integer> {
    public Page<ClaseDomain> findAll(Pageable pageable);
}