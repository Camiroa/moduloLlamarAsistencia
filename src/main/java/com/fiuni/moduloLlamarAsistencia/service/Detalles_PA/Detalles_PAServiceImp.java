package com.fiuni.moduloLlamarAsistencia.service.Detalles_PA;


import com.fiuni.moduloLlamarAsistencia.dao.Detalles_PA.IDetalles_PADao;
import com.fiuni.moduloLlamarAsistencia.dto.detalles.Detalles_PADTO;
import com.fiuni.moduloLlamarAsistencia.dto.detalles.Detalles_PAResult;
import com.library.domainLibrary.domain.detallePA.DetallePlanillaAsistenciaDomain;
import com.fiuni.moduloLlamarAsistencia.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Detalles_PAServiceImp extends BaseServiceImpl<Detalles_PADTO, DetallePlanillaAsistenciaDomain, Detalles_PAResult>
implements IDetalles_PAService{

    @Autowired
    private IDetalles_PADao detalles_paDao;
    @Override
    protected Detalles_PADTO convertDomainToDto(DetallePlanillaAsistenciaDomain domain) {
        Detalles_PADTO dto = new Detalles_PADTO();
        dto.setId(domain.getId());
        dto.setEstado(domain.getEstado());
        dto.setAsistencia(domain.getAsistencia());
        dto.setJustificativo(domain.getJustificativo());
        dto.setIdListaAlumno(domain.getIdListaAlumno());
        dto.setIdPlanillaAsistencia(domain.getIdPlanillaAsistencia());

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

    @Override
    public ResponseEntity<Detalles_PADTO> update(Integer id, Detalles_PADTO dto) {
        if (dto.getEstado() != null && dto.getJustificativo() != null && dto.getAsistencia() != null && dto.getIdListaAlumno() != null
                && dto.getIdPlanillaAsistencia() != null) {
            Detalles_PADTO detalleActualizado = detalles_paDao.findById(id).map(detalleDomain -> {
                detalleDomain.setAsistencia(dto.getAsistencia());
                detalleDomain.setEstado(dto.getEstado());
                detalleDomain.setIdListaAlumno(dto.getIdListaAlumno());
                detalleDomain.setIdPlanillaAsistencia(dto.getIdPlanillaAsistencia());
                dto.setId(detalleDomain.getId());
                return save(dto);
            }).orElse(null).getBody();
            return detalleActualizado != null ? new ResponseEntity<Detalles_PADTO>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Detalles_PADTO>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Boolean> delete(Integer id) {
        Boolean response = detalles_paDao.findById(id).map(etapaDomain -> {
            Detalles_PADTO dto = convertDomainToDto(etapaDomain);
            if (dto.getEstado()) {
                dto.setEstado(false);
                save(dto);
                return true;
            } else {
                return false;
            }
        }).orElse(null);
        return new ResponseEntity<Boolean>(response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    @Override
    public List<Detalles_PADTO> convertListToDTO(List<DetallePlanillaAsistenciaDomain> listaDetallesPADomain){
        List<Detalles_PADTO> newList= new ArrayList<>();
        for (DetallePlanillaAsistenciaDomain dPAdomain: listaDetallesPADomain) {
            newList.add(convertDomainToDto(dPAdomain));
        }
        return newList;
    }
    @Override
    public List<DetallePlanillaAsistenciaDomain> convertListToDomain(List<Detalles_PADTO> listaDetallesPADTO){
        List<DetallePlanillaAsistenciaDomain> newList= new ArrayList<>();
        for (Detalles_PADTO dPADTO: listaDetallesPADTO) {
            newList.add(convertDtoToDomain(dPADTO));
        }
        return newList;
    }
}

