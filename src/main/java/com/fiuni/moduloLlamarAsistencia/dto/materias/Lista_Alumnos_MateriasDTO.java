package com.fiuni.moduloLlamarAsistencia.dto.materias;

import com.fiuni.moduloLlamarAsistencia.dto.personas.PersonaDTO;
import com.fiuni.moduloLlamarAsistencia.dto.base.BaseDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "LISTA_MATERIAS")
public class Lista_Alumnos_MateriasDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Integer idClase;

    private Integer idMateria;

    private Integer idProfesor;

    private Boolean estado;

    private List<PersonaDTO> listaPersonasPorClase;



    @XmlElement
    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    @XmlElement
    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    @XmlElement
    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @XmlElement
    public List<PersonaDTO> getListaPersonas() {
        return listaPersonasPorClase;
    }

    public void setListaPersonas(List<PersonaDTO> listaPersonas) {
        this.listaPersonasPorClase = listaPersonas;
    }
}