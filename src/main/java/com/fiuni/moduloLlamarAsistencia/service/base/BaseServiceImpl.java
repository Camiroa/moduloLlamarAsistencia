package com.fiuni.moduloLlamarAsistencia.service.base;


import com.fiuni.moduloLlamarAsistencia.dto.base.BaseDTO;
import com.fiuni.moduloLlamarAsistencia.dto.base.BaseResult;
import com.library.domainLibrary.domain.base.BaseDomain;

public abstract class BaseServiceImpl<DTO extends BaseDTO, DOMAIN extends BaseDomain,  RESULT extends BaseResult<DTO>> implements IBaseService<DTO,   RESULT> {

    protected abstract DTO convertDomainToDto(DOMAIN domain);

    protected abstract DOMAIN convertDtoToDomain(DTO dto);

}
