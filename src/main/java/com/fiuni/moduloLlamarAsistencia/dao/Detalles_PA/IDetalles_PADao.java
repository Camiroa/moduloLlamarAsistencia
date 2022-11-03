package com.fiuni.moduloLlamarAsistencia.dao.Detalles_PA;

import com.library.domainLibrary.domain.detallePA.DetallePlanillaAsistenciaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface IDetalles_PADao extends CrudRepository<DetallePlanillaAsistenciaDomain, Integer> {
    public Page<DetallePlanillaAsistenciaDomain> findAll(Pageable pageable);

}
