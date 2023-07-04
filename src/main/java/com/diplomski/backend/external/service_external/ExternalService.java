package com.diplomski.backend.external.service_external;

import com.diplomski.backend.external.Pagination;
import com.diplomski.backend.external.ResponseExternal;
import com.diplomski.backend.external.util.ExternalMapper;
import lombok.Data;

import java.util.List;

@Data
public abstract class ExternalService<E,EDTO> {
    protected PaginationService paginationService;
    protected ExternalMapper<E,EDTO> mapper;
    private List<E> convert(List<EDTO> list){
        return mapper.convertToEntities(list);
    }
    abstract void saveObjects(List<E> list);
    public void saveExternalCall(ResponseExternal<EDTO> responseExternal,ExternalMapper externalMapper){
        setMapper(externalMapper);
        List<E> entities=convert(responseExternal.getData());
        paginationService.savePagination(responseExternal.getPagination());
        saveObjects(entities);
    }
}
