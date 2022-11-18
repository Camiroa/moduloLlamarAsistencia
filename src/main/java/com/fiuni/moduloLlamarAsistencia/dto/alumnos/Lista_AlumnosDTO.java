package com.fiuni.moduloLlamarAsistencia.dto.alumnos;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import com.fiuni.moduloLlamarAsistencia.dto.base.BaseDTO;

@XmlRootElement(name = "LISTA_ALUMNOS")
public class Lista_AlumnosDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;
    private Integer idClase;

    private Integer idAlumno;

    private Boolean estado;

    @XmlElement
    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    @XmlElement
    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
