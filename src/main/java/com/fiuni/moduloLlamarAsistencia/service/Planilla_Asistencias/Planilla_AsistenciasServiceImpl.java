package com.fiuni.moduloLlamarAsistencia.service.Planilla_Asistencias;

import com.fiuni.moduloLlamarAsistencia.dao.Lista_Materias.ILista_MateriasDao;
import com.fiuni.moduloLlamarAsistencia.dao.Planilla_Asistencias.IPlanilla_AsistenciasDao;
import com.fiuni.moduloLlamarAsistencia.dao.materias.IMateriaDao;
import com.fiuni.moduloLlamarAsistencia.dto.detalles.Detalles_PADTO;
import com.fiuni.moduloLlamarAsistencia.dto.planilla.Planilla_Asistencia_Materia_DTO;
import com.fiuni.moduloLlamarAsistencia.dto.planilla.Planilla_AsistenciasDTO;
import com.fiuni.moduloLlamarAsistencia.dto.planilla.Planilla_AsistenciasResult;
import com.fiuni.moduloLlamarAsistencia.service.Detalles_PA.IDetalles_PAService;
import com.fiuni.moduloLlamarAsistencia.service.Lista_Alumnos.ILista_AlumnosService;
import com.fiuni.moduloLlamarAsistencia.service.base.BaseServiceImpl;
import com.library.domainLibrary.domain.persona.PersonaDomain;
import com.library.domainLibrary.domain.planillaAsistencia.PlanillaAsistenciaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class Planilla_AsistenciasServiceImpl extends BaseServiceImpl<Planilla_AsistenciasDTO, PlanillaAsistenciaDomain, Planilla_AsistenciasResult> implements IPlanilla_AsistenciasService{

    @Autowired
    private IPlanilla_AsistenciasDao planilla_asistenciasDao;
    @Autowired
    private IDetalles_PAService detalles_paService;
    @Autowired
    private ILista_MateriasDao lista_materias_dao;
    @Autowired
    private IMateriaDao materia_dao;
    @Autowired
    private ILista_AlumnosService lista_alumnosService;
    @Transactional
    @Override
    public Boolean updateDetalles( Planilla_AsistenciasDTO dto) {
        if(dto.getEstado()!=null && dto.getIdListaMateria()!= null){
            try{
                Integer response = planilla_asistenciasDao.updateAsistencia(dto.getFecha(), dto.getEstado(), dto.getId());
                dto.getListaDetalles_PA().forEach(detalle->{
                    detalles_paService.updateDetalles(detalle);
                });
                return true;
            }catch(Exception e) {
            System.out.println(e.getMessage());
                return false;
            }
        }
        return false;
    }

    @Override
    public ResponseEntity<Planilla_AsistenciasDTO> update(Integer id, Planilla_AsistenciasDTO dto) {
        if(dto.getEstado()!=null && dto.getIdListaMateria()!= null){
            Planilla_AsistenciasDTO response = planilla_asistenciasDao.findById(id).map(domain ->{
                domain.setEstado(dto.getEstado());
                domain.setFecha(dto.getFecha());
                dto.setId(domain.getId());
                domain.setIdListaMateria(dto.getIdListaMateria());
                return save(dto);
            }).orElse(null).getBody();
            return response != null?new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Planilla_AsistenciasDTO>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Boolean> delete(Integer id) {
        Integer response = planilla_asistenciasDao.delete(id);
        return new ResponseEntity<>(response!= null ? HttpStatus.OK: HttpStatus.NOT_FOUND);
    }
   // @Override
   // @Transactional
   // public ResponseEntity<Integer> fullDelete(Integer id) {
    //    Integer response = planilla_asistenciasDao.fullDelete(id);
    //    return new ResponseEntity<Integer>(response, response > 0 ? HttpStatus.OK : HttpStatus.METHOD_NOT_ALLOWED);//ResponseEntity.etapaDao.deleteAbsolut(id);
    //}
    @Override
    protected Planilla_AsistenciasDTO convertDomainToDto(PlanillaAsistenciaDomain domain) {
        Planilla_AsistenciasDTO dto = new Planilla_AsistenciasDTO();
        PersonaDomain personaDomain;

        dto.setId(domain.getId());
        dto.setEstado(domain.getEstado());
        dto.setIdListaMateria(domain.getIdListaMateria());
        dto.setFecha(domain.getFecha());
        dto.setListaDetalles_PA(detalles_paService.convertListToDTO(domain.getDetallesPlanillaAsistencias()));
        return dto;
    }

    @Override
    @Transactional
    protected PlanillaAsistenciaDomain convertDtoToDomain(Planilla_AsistenciasDTO dto) {
        System.out.println(dto.getId());
        PlanillaAsistenciaDomain domain = new PlanillaAsistenciaDomain();
        //domain.setId(dto.getId());
        domain.setEstado(dto.getEstado());
        domain.setIdListaMateria(dto.getIdListaMateria());
        domain.setFecha(dto.getFecha());
        System.out.println("Aca primero----------------------------------------------");
        System.out.println(dto.getListaDetalles_PA().get(0).getId());
        domain.setDetallesPlanillaAsistencias(detalles_paService.convertListToDomain(dto.getListaDetalles_PA()));
        return domain;
    }


    @Override
    @Transactional
    public ResponseEntity<Planilla_AsistenciasDTO> save(Planilla_AsistenciasDTO dto) {
        System.out.println(dto.getId());
        Planilla_AsistenciasDTO response= convertDomainToDto(planilla_asistenciasDao.save(convertDtoToDomain(dto)));
        List<Detalles_PADTO> nuevosDetalles=response.getListaDetalles_PA();
        for (Detalles_PADTO detalle: nuevosDetalles) {
            detalle.setIdPlanillaAsistencia(response.getId());
            detalles_paService.save(detalle);
        }
        return response!=null ? new ResponseEntity<>(response,HttpStatus.CREATED): new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity<Planilla_AsistenciasDTO> getById(Integer id) {
        Planilla_AsistenciasDTO response=convertDomainToDto(planilla_asistenciasDao.findById(id).orElse(null));
        return response != null ? new ResponseEntity<>(response, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public ResponseEntity<Planilla_AsistenciasResult> getAll(Pageable pageable) {
        Planilla_AsistenciasResult response = new Planilla_AsistenciasResult(planilla_asistenciasDao.findAll(pageable)
                .map(p -> {return convertDomainToDto(p);}).toList());

        return response != null ? new ResponseEntity<>(response, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }
    @Override
    public ResponseEntity<Planilla_Asistencia_Materia_DTO> getByIdListaMateria(Integer id) {
        Planilla_Asistencia_Materia_DTO response = new Planilla_Asistencia_Materia_DTO();
        List <PlanillaAsistenciaDomain> listaFechas= planilla_asistenciasDao.findAllByIdListaMateria(id);
        List<Planilla_AsistenciasDTO> listaDTO = new ArrayList();

        for (int i = 0; i < listaFechas.size(); i++) {

            PlanillaAsistenciaDomain fecha = listaFechas.get(i);
            if(fecha.getEstado()){
                listaDTO.add(convertDomainToDto(fecha));
            }
        }
        response.setIdClase(lista_materias_dao.findById(id).get().getIdClase());
        //response.setAlumnos(lista_alumnosService.getAlumnos(materia_dao.findById(response.getIdClase()).get().getId()));
        response.setId(id);
        response.setNombreMateria(materia_dao.findById(lista_materias_dao.findById(id).get().getIdMateria()).get().getNombre());
        response.setIdListaMateria(id);
        response.setListaFechas(listaDTO);

        return response != null ? new ResponseEntity<>(response, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}