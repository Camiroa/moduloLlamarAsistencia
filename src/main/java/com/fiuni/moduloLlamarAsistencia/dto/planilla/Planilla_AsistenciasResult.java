package com.fiuni.moduloLlamarAsistencia.dto.planilla;

import com.fiuni.moduloLlamarAsistencia.dto.base.BaseResult;

import java.util.List;

public class Planilla_AsistenciasResult extends BaseResult<Planilla_AsistenciasDTO> {
    public Planilla_AsistenciasResult() {

    }

    public Planilla_AsistenciasResult(List<Planilla_AsistenciasDTO> list) {
        this.setList(list);
    }

    public List<Planilla_AsistenciasDTO> getLista() {
        return this.getList();
    }
}

