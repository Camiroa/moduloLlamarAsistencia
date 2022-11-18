package com.fiuni.moduloLlamarAsistencia.dto.planilla;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import com.fiuni.moduloLlamarAsistencia.dto.base.BaseDTO;
import com.fiuni.moduloLlamarAsistencia.dto.detalles.Detalles_PADTO;
import com.library.domainLibrary.domain.detallePA.DetallePlanillaAsistenciaDomain;

import java.time.LocalDate;
import java.util.List;


@XmlRootElement(name = "PLANILLA_ASISTENCIAS")
public class Planilla_AsistenciasDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Integer idListaMateria;

    private Boolean estado;

    private LocalDate fecha;

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
    public void setFecha(LocalDate date) {
        this.fecha = date;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @XmlElement
    public List<Detalles_PADTO> getListaDetalles_PA(){ return this.listaDetalles_PA;}

    public void setListaDetalles_PA(List<Detalles_PADTO> listaDetalles_PA) {
        this.listaDetalles_PA = listaDetalles_PA;
    }
}
