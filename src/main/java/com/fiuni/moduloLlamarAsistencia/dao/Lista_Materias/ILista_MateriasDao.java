package com.fiuni.moduloLlamarAsistencia.dao.Lista_Materias;
import com.library.domainLibrary.domain.listaMateria.ListaMateriaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface ILista_MateriasDao extends CrudRepository<ListaMateriaDomain, Integer> {
    public Page<ListaMateriaDomain> findAll(Pageable pageable);

    @Query(value = "UPDATE ListaMateriaDomain SET estado = 0 WHERE id = ?1")
    public Boolean delete(Integer id);

}

