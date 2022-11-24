package com.fiuni.moduloLlamarAsistencia.service.Lista_Alumnos;

import com.fiuni.moduloLlamarAsistencia.dao.Lista_Alumnos.ILista_AlumnosDao;
import com.fiuni.moduloLlamarAsistencia.dao.persona.IPersonaDao;
import com.fiuni.moduloLlamarAsistencia.dto.alumnos.Lista_AlumnosResult;
import com.fiuni.moduloLlamarAsistencia.dto.personas.PersonaDTO;
import com.fiuni.moduloLlamarAsistencia.dto.personas.PersonaResult;
import com.library.domainLibrary.domain.listaAlumno.ListaAlumnoDomain;
import com.fiuni.moduloLlamarAsistencia.dto.alumnos.Lista_AlumnosDTO;
import com.fiuni.moduloLlamarAsistencia.service.base.BaseServiceImpl;
import com.library.domainLibrary.domain.persona.PersonaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class Lista_AlumnosServiceImp extends BaseServiceImpl<Lista_AlumnosDTO, ListaAlumnoDomain, Lista_AlumnosResult> implements ILista_AlumnosService {

    @Autowired
    private ILista_AlumnosDao lista_alumnosDao;
    @Autowired
    private IPersonaDao personaDao;
    @Override
    @Transactional
    public ResponseEntity<Lista_AlumnosDTO> update(Integer id, Lista_AlumnosDTO dto) {
        if (dto.getEstado() != null && dto.getIdClase() != null && dto.getIdAlumno() != null) {
            Lista_AlumnosDTO response = lista_alumnosDao.findById(id).map(domain -> {
                domain.setEstado(dto.getEstado());
                domain.setIdClase(dto.getIdClase());
                domain.setIdAlumno(dto.getIdAlumno());
                dto.setId(domain.getId());
                return save(dto);
            }).orElse(null).getBody();
            return response != null ? new ResponseEntity<Lista_AlumnosDTO>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.CONFLICT);

        }
        return new ResponseEntity<Lista_AlumnosDTO>(HttpStatus.BAD_REQUEST);
    }
    @Override
    public ResponseEntity<Boolean> delete(Integer id) {
        Boolean response = lista_alumnosDao.delete(id);
        return new ResponseEntity<Boolean>(response !=null? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @Override
    protected Lista_AlumnosDTO convertDomainToDto(ListaAlumnoDomain domain) {
        Lista_AlumnosDTO dto = new Lista_AlumnosDTO();

        dto.setId(domain.getId());
        dto.setEstado(domain.getEstado());
        dto.setIdAlumno(domain.getIdAlumno());
        dto.setIdClase(domain.getIdClase());

        return dto;
    }

    @Override
    protected ListaAlumnoDomain convertDtoToDomain(Lista_AlumnosDTO dto) {
        ListaAlumnoDomain domain = new ListaAlumnoDomain();
        domain.setId(dto.getId());
        domain.setEstado(dto.getEstado());
        domain.setIdAlumno(dto.getIdAlumno());
        domain.setIdClase(dto.getIdClase());
        return domain;
    }

    @Override
    public ResponseEntity<Lista_AlumnosDTO> save(Lista_AlumnosDTO dto) {
        Lista_AlumnosDTO response= convertDomainToDto(lista_alumnosDao.save(convertDtoToDomain(dto)));
        return response!=null ? new ResponseEntity<>(response,HttpStatus.CREATED): new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity<Lista_AlumnosDTO> getById(Integer id) {
        Lista_AlumnosDTO response = convertDomainToDto(lista_alumnosDao.findById(id).orElse(null));
        return response != null ? new ResponseEntity<Lista_AlumnosDTO>(response, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public ResponseEntity<Lista_AlumnosResult> getAll(Pageable pageable) {
        Lista_AlumnosResult response = new Lista_AlumnosResult(lista_alumnosDao.findAll(pageable)
                .map(p -> {return convertDomainToDto(p);}).toList());
        return response != null ? new ResponseEntity<Lista_AlumnosResult>(response, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Override
    public ResponseEntity<PersonaResult> getListAlumnos(Integer idClase) {
        PersonaResult response= new PersonaResult(getAlumnos(idClase));
        return response != null ? new ResponseEntity<PersonaResult>(response, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Override
    public List<PersonaDTO> getAlumnos(Integer idClase) {
        List<PersonaDTO> response=new ArrayList<>();
        List<ListaAlumnoDomain> personasDeLaClaseId= lista_alumnosDao.findAllByIdClase(idClase);
        for (int i = 0; i < personasDeLaClaseId.size(); i++) {
            PersonaDomain alumno = personaDao.findById(personasDeLaClaseId.get(i).getIdAlumno()).get();
            PersonaDTO alumnoDTO= new PersonaDTO();
            alumnoDTO.setCi(alumno.getCi());
            alumnoDTO.setNombre(alumno.getNombre());
            alumnoDTO.setDireccion(alumno.getDireccion());
            alumnoDTO.setEmail(alumno.getEmail());
            alumnoDTO.setGenero(alumno.getGenero());
            alumnoDTO.setId(personasDeLaClaseId.get(i).getId());
            response.add(alumnoDTO);
        }
        return response;
    }
    //    public ResponseEntity<Planilla_Asistencia_Materia_DTO> getByIdListaMateria(Integer id) {
//        Planilla_Asistencia_Materia_DTO response = new Planilla_Asistencia_Materia_DTO();
//        List<PlanillaAsistenciaDomain> listaFechas= planilla_asistenciasDao.findAllByIdListaMateria(id);
//        List<Planilla_AsistenciasDTO> listaDTO = new ArrayList();
//        for (int i = 0; i < listaFechas.size(); i++) {
//            PlanillaAsistenciaDomain fecha = listaFechas.get(i);
//            listaDTO.add(convertDomainToDto(fecha));
//        }
//        response.setId(id);
//        response.setNombreMateria(materia_dao.findById(lista_materias_dao.findById(id).get().getIdMateria()).get().getNombre());
//        response.setIdListaMateria(id);
//        response.setListaFechas(listaDTO);
//        return response != null ? new ResponseEntity<>(response, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}