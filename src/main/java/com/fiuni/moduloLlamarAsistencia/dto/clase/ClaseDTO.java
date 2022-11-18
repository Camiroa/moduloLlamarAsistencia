package com.fiuni.moduloLlamarAsistencia.dto.clase;

import com.fiuni.moduloLlamarAsistencia.dto.base.BaseDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CLASES")
public class ClaseDTO extends BaseDTO {

    private Integer idColegio;

    private Integer idCiclo;

    private String nombre;

    private String turno;

    private Integer anho;

    private Boolean estado;

    //private List<PersonaDTO> listaAlumnos;

    @XmlElement
    public Integer getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(Integer idColegio) {
        this.idColegio = idColegio;
    }

    @XmlElement
    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @XmlElement
    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

//    @XmlElement
//    public List<PersonaDTO> getListaAlumnos() {
//        return listaAlumnos;
//    }
//
//    public void setListaAlumnos(List<PersonaDTO> listaAlumnos) {
//        this.listaAlumnos = listaAlumnos;
//    }
}
