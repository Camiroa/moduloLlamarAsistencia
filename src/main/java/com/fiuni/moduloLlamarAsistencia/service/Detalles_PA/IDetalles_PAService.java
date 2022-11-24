package com.fiuni.moduloLlamarAsistencia.service.Detalles_PA;


import com.fiuni.moduloLlamarAsistencia.dto.detalles.Detalles_PADTO;
import com.fiuni.moduloLlamarAsistencia.dto.detalles.Detalles_PAResult;
import com.fiuni.moduloLlamarAsistencia.service.base.IBaseService;
import com.library.domainLibrary.domain.detallePA.DetallePlanillaAsistenciaDomain;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IDetalles_PAService extends IBaseService<Detalles_PADTO, Detalles_PAResult> {


    //    @Override
    //    @Transactional
    //    public Boolean updatePuntajeAndEstado(PlanillaNotaUpdNotasAndEstadoDTO dto) {
    //        try{
    //            dto.getDetalles().forEach(d -> {
    //                //System.out.println("id: " + d.getId() + " puntaje: " + d.getPuntaje() + " estado: " + d.getEstado());
    //                detallesDao.updatePuntajeAndEstado(d.getPuntaje(), d.getEstado(), d.getId());
    //            });
    //            return true;
    //        }catch(Exception e) {
    //            System.out.println(e.getMessage());
    //            return false;
    //        }
    //    }
    public Boolean updateDetalles(Detalles_PADTO dto);

    public abstract ResponseEntity<Detalles_PADTO> update(Integer id, Detalles_PADTO dto);

    public abstract ResponseEntity<Boolean> delete(Integer id);

    //public abstract ResponseEntity<Integer> fullDelete(Integer id);
    public List<Detalles_PADTO> convertListToDTO(List<DetallePlanillaAsistenciaDomain> listaDetallesPADomain);

    public List<DetallePlanillaAsistenciaDomain> convertListToDomain(List<Detalles_PADTO> listaDetallesPADTO);


    ResponseEntity<Detalles_PADTO> getByIdP(Integer detalles);
}
