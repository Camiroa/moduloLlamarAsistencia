package com.fiuni.moduloLlamarAsistencia.dto.clase;

import com.fiuni.moduloLlamarAsistencia.dto.base.BaseResult;

import java.util.List;

public class ClaseResult extends BaseResult<ClaseDTO> {
    public ClaseResult(){

    }
    public ClaseResult(List<ClaseDTO> list){
        this.setList(list);
    }

    public List<ClaseDTO> getLista(){
        return this.getList();
    }
}
