package com.fiuni.moduloLlamarAsistencia.dao.Lista_Alumnos;
import com.library.domainLibrary.domain.listaAlumno.ListaAlumnoDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ILista_AlumnosDao extends CrudRepository<ListaAlumnoDomain, Integer> {
    public Page<ListaAlumnoDomain> findAll(Pageable pageable);

    Boolean delete(Integer id);
}


