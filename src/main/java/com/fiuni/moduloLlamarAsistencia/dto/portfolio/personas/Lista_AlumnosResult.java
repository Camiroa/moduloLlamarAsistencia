package com.fiuni.moduloLlamarAsistencia.dto.portfolio.personas;

import com.fiuni.moduloLlamarAsistencia.dto.base.BaseResult;

import java.util.List;

public class Lista_AlumnosResult extends BaseResult<Lista_AlumnosDTO> {
    public Lista_AlumnosResult(){

    }
    public Lista_AlumnosResult(List<Lista_AlumnosDTO> list){
        this.setList(list);
    }

    public List<Lista_AlumnosDTO> getLista(){
        return this.getList();
    }
}

