package com.fiuni.moduloLlamarAsistencia.service.Planilla_Asistencias;

import com.fiuni.moduloLlamarAsistencia.dao.Planilla_Asistencias.IPlanilla_AsistenciasDao;
import com.fiuni.moduloLlamarAsistencia.dto.planilla.Planilla_AsistenciasDTO;
import com.fiuni.moduloLlamarAsistencia.dto.planilla.Planilla_AsistenciasResult;
import com.fiuni.moduloLlamarAsistencia.service.base.BaseServiceImpl;
import com.library.domainLibrary.domain.planillaAsistencia.PlanillaAsistenciaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Planilla_AsistenciasServiceImpl extends BaseServiceImpl<Planilla_AsistenciasDTO, PlanillaAsistenciaDomain, Planilla_AsistenciasResult> implements IPlanilla_AsistenciasService{

    @Autowired
    private IPlanilla_AsistenciasDao planilla_asistenciasDao;
    @Override
    public ResponseEntity<Planilla_AsistenciasDTO> update(Integer id, Planilla_AsistenciasDTO dto) {
        if(dto.getEstado()!=null && dto.getIdListaMateria()!= null){
            Planilla_AsistenciasDTO response = planilla_asistenciasDao.findById(id).map(domain ->{
                domain.setEstado(dto.getEstado());
                domain.setIdListaMateria(dto.getIdListaMateria());
                domain.setId(domain.getId());
                return save(dto);
            }).orElse(null).getBody();
            return response != null?new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Planilla_AsistenciasDTO>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Boolean> delete(Integer id) {
        Boolean response = planilla_asistenciasDao.delete(id);
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

        dto.setId(domain.getId());
        dto.setEstado(domain.getEstado());
        dto.setIdListaMateria(domain.getIdListaMateria());
        dto.setListaDetalles_PA(domain.getDetallesPlanillaAsistencias());
        return dto;
    }

    @Override
    protected PlanillaAsistenciaDomain convertDtoToDomain(Planilla_AsistenciasDTO dto) {
        PlanillaAsistenciaDomain domain = new PlanillaAsistenciaDomain();
        domain.setId(dto.getId());
        domain.setEstado(dto.getEstado());
        domain.setIdListaMateria(dto.getIdListaMateria());
        domain.setDetallesPlanillaAsistencias(dto.getListaDetalles_PA());
        return domain;
    }

    @Override
    public ResponseEntity<Planilla_AsistenciasDTO> save(Planilla_AsistenciasDTO dto) {
        Planilla_AsistenciasDTO response= convertDomainToDto(planilla_asistenciasDao.save(convertDtoToDomain(dto)));
        return response!=null ? new ResponseEntity<>(response,HttpStatus.CREATED): new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity<Planilla_AsistenciasDTO> getById(Integer id) {
        Planilla_AsistenciasDTO response=convertDomainToDto(planilla_asistenciasDao.findById(id).orElse(null));
        return response != null ? new ResponseEntity<>(response, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Planilla_AsistenciasResult> getAll(Pageable pageable) {
        Planilla_AsistenciasResult response = new Planilla_AsistenciasResult(planilla_asistenciasDao.findAll(pageable).map(p -> convertDomainToDto(p)).toList());

        return response != null ? new ResponseEntity<>(response, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}