package com.fiuni.moduloLlamarAsistencia.dao.Lista_Alumnos;
import com.library.domainLibrary.domain.listaAlumno.ListaAlumnoDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ILista_AlumnosDao extends CrudRepository<ListaAlumnoDomain, Integer> {
    public Page<ListaAlumnoDomain> findAll(Pageable pageable);
    public List<ListaAlumnoDomain> findAllByIdClase(Integer id);
    @Query(value = "UPDATE ListaAlumnoDomain SET estado = 0 WHERE id = ?1")
    Boolean delete(Integer id);
}


