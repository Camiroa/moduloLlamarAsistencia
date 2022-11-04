package com.fiuni.moduloLlamarAsistencia.dto.planilla;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import com.fiuni.moduloLlamarAsistencia.dto.base.BaseDTO;
import com.fiuni.moduloLlamarAsistencia.dto.detalles.Detalles_PADTO;
import com.library.domainLibrary.domain.detallePA.DetallePlanillaAsistenciaDomain;

import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "PLANILLA_ASISTENCIAS")
public class Planilla_AsistenciasDTO extends BaseDTO {

    private Integer idListaMateria;

    private Boolean estado;

    private List<Detalles_PADTO> listaDetalles_PA;


    @XmlElement
    public Integer getIdListaMateria() {
        return idListaMateria;
    }

    public void setIdListaMateria(Integer idListaMateria) {
        this.idListaMateria = idListaMateria;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @XmlElement
    public List<DetallePlanillaAsistenciaDomain> getListaDetalles_PA(){
        List<DetallePlanillaAsistenciaDomain> listaDomain=new ArrayList<>();
        for (int i = 0; i < this.listaDetalles_PA.size(); i++) {
            DetallePlanillaAsistenciaDomain domain= new DetallePlanillaAsistenciaDomain();
            Detalles_PADTO dto= listaDetalles_PA.get(i);
            domain.setId(dto.getId());
            domain.setEstado(dto.getEstado());
            domain.setAsistencia(dto.getAsistencia());
            domain.setIdListaAlumno(dto.getIdListaAlumno());
            domain.setIdPlanillaAsistencia(dto.getIdPlanillaAsistencia());
            domain.setJustificativo(dto.getJustificativo());
            listaDomain.add(domain);
        }
        return listaDomain;
    }

    public void setListaDetalles_PA(List<DetallePlanillaAsistenciaDomain> listaDetalles){
        this.listaDetalles_PA.clear();
        for (int i = 0; i < listaDetalles.size(); i++) {
            DetallePlanillaAsistenciaDomain domain= listaDetalles.get(i);
            Detalles_PADTO dto= new Detalles_PADTO();
            dto.setId(domain.getId());
            dto.setEstado(domain.getEstado());
            dto.setAsistencia(domain.getAsistencia());
            dto.setIdListaAlumno(domain.getIdListaAlumno());
            dto.setIdPlanillaAsistencia(domain.getIdPlanillaAsistencia());
            dto.setJustificativo(domain.getJustificativo());
            this.listaDetalles_PA.add(dto);
        }
    }
}
