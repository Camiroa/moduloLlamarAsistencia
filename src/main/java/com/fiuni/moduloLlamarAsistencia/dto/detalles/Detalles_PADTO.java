package com.fiuni.moduloLlamarAsistencia.dto.detalles;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.moduloLlamarAsistencia.dto.base.BaseDTO;


@XmlRootElement(name = "DETALLES_PA")
public class Detalles_PADTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Integer idPlanillaAsistencia;

    private Integer idListaAlumno;

    private char asistencia;

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
    public char getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(char asistencia) {
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