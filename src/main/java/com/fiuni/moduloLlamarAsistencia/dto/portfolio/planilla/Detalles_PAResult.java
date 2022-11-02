package com.fiuni.moduloLlamarAsistencia.dto.portfolio.planilla;

import com.fiuni.moduloLlamarAsistencia.dto.base.BaseResult;

import java.util.List;

public class Detalles_PAResult extends BaseResult<Detalles_PADTO> {
    public Detalles_PAResult() {

    }

    public Detalles_PAResult(List<Detalles_PADTO> list) {
        this.setList(list);
    }

    public List<Detalles_PADTO> getLista() {
        return this.getList();
    }
}

