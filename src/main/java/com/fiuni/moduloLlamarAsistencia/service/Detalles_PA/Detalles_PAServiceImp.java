package com.fiuni.moduloLlamarAsistencia.service.Detalles_PA;


import com.fiuni.moduloLlamarAsistencia.dao.Detalles_PA.IDetalles_PADao;
import com.fiuni.moduloLlamarAsistencia.dto.portfolio.planilla.Detalles_PADTO;
import com.fiuni.moduloLlamarAsistencia.dto.portfolio.planilla.Detalles_PAResult;
import com.library.domainLibrary.domain.detallePA.DetallePlanillaAsistenciaDomain;
import com.fiuni.moduloLlamarAsistencia.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

public class Detalles_PAServiceImp extends BaseServiceImpl<Detalles_PADTO, DetallePlanillaAsistenciaDomain, Detalles_PAResult> {

    @Autowired
    private IDetalles_PADao detalles_paDao;
    @Override
    protected Detalles_PADTO convertDomainToDto(DetallePlanillaAsistenciaDomain domain) {
        Detalles_PADTO dto = new Detalles_PADTO();

        dto.setId(domain.getId());
        dto.setEstado(domain.getEstado());
        dto.setAsistencia(domain.getAsistencia());
        dto.setIdListaAlumno(domain.getIdListaAlumno());
        dto.setIdPlanillaAsistencia(domain.getIdPlanillaAsistencia());
        dto.setJustificativo(domain.getJustificativo());
        return dto;
    }

    @Override
    protected DetallePlanillaAsistenciaDomain convertDtoToDomain(Detalles_PADTO dto) {
        DetallePlanillaAsistenciaDomain domain = new DetallePlanillaAsistenciaDomain ();

        domain.setId(dto.getId());
        domain.setEstado(dto.getEstado());
        domain.setAsistencia(dto.getAsistencia());
        domain.setIdListaAlumno(dto.getIdListaAlumno());
        domain.setIdPlanillaAsistencia(dto.getIdPlanillaAsistencia());
        domain.setJustificativo(dto.getJustificativo());
        return domain;
    }

    @Override
    public ResponseEntity<Detalles_PADTO> save(Detalles_PADTO dto) {
        Detalles_PADTO response= convertDomainToDto(detalles_paDao.save(convertDtoToDomain(dto)));
        return response!=null? new ResponseEntity<>(HttpStatus.CREATED): new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity<Detalles_PADTO> getById(Integer id) {
        Detalles_PADTO response= convertDomainToDto(detalles_paDao.findById(id).orElse(null));
        return response != null ? new ResponseEntity<>(response, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Detalles_PAResult> getAll(Pageable pageable) {
        Detalles_PAResult response= new Detalles_PAResult(detalles_paDao.findAll(pageable).map(p->convertDomainToDto(p)).toList());
        return response != null ? new ResponseEntity<>(response, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   // @Override
    //@Transactional
 //   public ResponseEntity<Integer> fullDelete(Integer id) {
  //      Integer response = detalles_paDao.deleteAbsolut(id);
 //       return new ResponseEntity<Integer>(response, response > 0 ? HttpStatus.OK : HttpStatus.METHOD_NOT_ALLOWED);//ResponseEntity.etapaDao.deleteAbsolut(id);
 //   }

}

