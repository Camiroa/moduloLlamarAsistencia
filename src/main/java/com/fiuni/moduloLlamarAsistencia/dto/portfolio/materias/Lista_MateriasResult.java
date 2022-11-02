package com.fiuni.moduloLlamarAsistencia.dto.portfolio.materias;


import com.fiuni.moduloLlamarAsistencia.dto.base.BaseResult;

import java.util.List;

public class Lista_MateriasResult extends BaseResult<Lista_MateriasDTO> {
    public Lista_MateriasResult(){

    }
    public Lista_MateriasResult(List<Lista_MateriasDTO> list){
        this.setList(list);
    }

    public List<Lista_MateriasDTO> getLista(){
        return this.getList();
    }
}

