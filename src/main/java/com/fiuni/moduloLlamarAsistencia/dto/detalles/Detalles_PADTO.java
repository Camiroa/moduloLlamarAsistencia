package com.fiuni.moduloLlamarAsistencia.dto.detalles;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.moduloLlamarAsistencia.dto.base.BaseDTO;


@XmlRootElement(name = "DETALLES_PA")
public class Detalles_PADTO extends BaseDTO {

    private Integer idPlanillaAsistencia;

    private Integer idListaAlumno;

    private Boolean asistencia;

    private String justificativo;

    private Boolean estado;



    @XmlElement
    public Integer getIdPlanillaAsistencia() {
        return idPlanillaAsistencia;
    }

    public void setIdPlanillaAsistencia(Integer idPlanillaAsistencia) {
        this.idPlanillaAsistencia = idPlanillaAsistencia;
    }

    @XmlElement
    public Integer getIdListaAlumno() {
        return idListaAlumno;
    }

    public void setIdListaAlumno(Integer idListaAlumno) {
        this.idListaAlumno = idListaAlumno;
    }

    @XmlElement
    public Boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Boolean asistencia) {
        this.asistencia = asistencia;
    }

    @XmlElement
    public String getJustificativo() {
        return justificativo;
    }

    public void setJustificativo(String justificativo) {
        this.justificativo = justificativo;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


}