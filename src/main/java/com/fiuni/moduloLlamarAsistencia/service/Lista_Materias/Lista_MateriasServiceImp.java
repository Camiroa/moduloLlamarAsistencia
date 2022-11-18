package com.fiuni.moduloLlamarAsistencia.service.Lista_Materias;
import com.fiuni.moduloLlamarAsistencia.service.base.BaseServiceImpl;
import com.fiuni.moduloLlamarAsistencia.dao.Lista_Materias.ILista_MateriasDao;
import com.fiuni.moduloLlamarAsistencia.dto.materias.Lista_MateriasDTO;
import com.fiuni.moduloLlamarAsistencia.dto.materias.Lista_MateriasResult;
import com.library.domainLibrary.domain.listaMateria.ListaMateriaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Lista_MateriasServiceImp extends BaseServiceImpl<Lista_MateriasDTO, ListaMateriaDomain, Lista_MateriasResult> implements ILista_MateriasService {
    @Autowired
    private ILista_MateriasDao listaMateriaDao;


    @Override
    protected Lista_MateriasDTO convertDomainToDto(ListaMateriaDomain domain) {
        Lista_MateriasDTO dto = new Lista_MateriasDTO();

        dto.setId(domain.getId());
        dto.setEstado(domain.getEstado());
        dto.setIdMateria(domain.getIdMateria());
        dto.setIdClase(domain.getIdClase());
        dto.setIdProfesor(domain.getIdProfesor());

        return dto;
    }

    @Override
    protected ListaMateriaDomain convertDtoToDomain(Lista_MateriasDTO dto) {
        ListaMateriaDomain domain = new ListaMateriaDomain();
        domain.setId(dto.getId());
        domain.setEstado(dto.getEstado());
        domain.setIdMateria(dto.getIdMateria());
        domain.setIdProfesor(dto.getIdProfesor());
        domain.setIdClase(dto.getIdClase());
        return domain;
    }

    @Override
    public ResponseEntity<Lista_MateriasDTO> save(Lista_MateriasDTO dto) {
        Lista_MateriasDTO response = convertDomainToDto(listaMateriaDao.save(convertDtoToDomain(dto)));
        return response != null ? new ResponseEntity<>(response, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity<Lista_MateriasDTO> getById(Integer id) {
        Lista_MateriasDTO response = convertDomainToDto(listaMateriaDao.findById(id).orElse(null));

        return response != null ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @javax.transaction.Transactional
    public ResponseEntity<Lista_MateriasResult> getAll(Pageable pageable) {
        Lista_MateriasResult response = new Lista_MateriasResult(listaMateriaDao.findAll(pageable).map(p -> {return convertDomainToDto(p);}).toList());

        return response != null ? new ResponseEntity<Lista_MateriasResult>(response, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public ResponseEntity<Lista_MateriasDTO> update(Integer id, Lista_MateriasDTO dto) {
        if (dto.getEstado() != null && dto.getIdMateria() != null && dto.getIdClase() != null && dto.getIdProfesor() != null) {
            Lista_MateriasDTO response = listaMateriaDao.findById(id).map(domain -> {
                domain.setEstado(dto.getEstado());
                domain.setIdMateria(dto.getIdMateria());
                domain.setIdClase(dto.getIdClase());
                domain.setIdProfesor(dto.getIdProfesor());
                dto.setId(domain.getId());
                return save(dto);
            }).orElse(null).getBody();
            return response != null ? new ResponseEntity<Lista_MateriasDTO>(HttpStatus.NO_CONTENT) : new ResponseEntity<Lista_MateriasDTO>(HttpStatus.CONFLICT);

        }
        return new ResponseEntity<Lista_MateriasDTO>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Boolean> delete(Integer id) {
        Boolean response = listaMateriaDao.delete(id);
        return new ResponseEntity<Boolean>(response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
