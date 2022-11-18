package com.fiuni.moduloLlamarAsistencia.dto.personas;

import com.fiuni.moduloLlamarAsistencia.dto.base.BaseResult;

import java.util.List;

public class PersonaResult extends BaseResult<PersonaDTO> {
    public PersonaResult() {

    }

    public PersonaResult(List<PersonaDTO> list) {
        this.setList(list);
    }

    public List<PersonaDTO> getLista() {
        return this.getList();
    }
}
