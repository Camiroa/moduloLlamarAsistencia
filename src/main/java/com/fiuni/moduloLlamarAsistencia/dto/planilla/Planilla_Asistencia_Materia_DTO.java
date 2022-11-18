package com.fiuni.moduloLlamarAsistencia.dto.planilla;

import com.fiuni.moduloLlamarAsistencia.dto.base.BaseDTO;
import com.fiuni.moduloLlamarAsistencia.dto.personas.PersonaDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


@XmlRootElement(name = "PLANILLA_ASISTENCIAS")
public class Planilla_Asistencia_Materia_DTO extends BaseDTO {

    private String nombreMateria;
    private Integer idClase;

    private Integer idListaMateria;
    private List<Planilla_AsistenciasDTO> listaFechas;

    private List<PersonaDTO> alumnos;

    @XmlElement
    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }


    @XmlElement
    public Integer getIdListaMateria() {
        return idListaMateria;
    }

    public void setIdListaMateria(Integer idListaMateria) {
        this.idListaMateria = idListaMateria;
    }


    @XmlElement
    public List<Planilla_AsistenciasDTO> getListaFechas() {
        return listaFechas;
    }

    public void setListaFechas(List<Planilla_AsistenciasDTO> listaFechas) {
        this.listaFechas = listaFechas;
    }


    @XmlElement
    public List<PersonaDTO> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<PersonaDTO> alumnos) {
        this.alumnos = alumnos;
    }

    @XmlElement
    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }
}

