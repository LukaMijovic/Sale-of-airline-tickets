package com.diplomski.backend.external.service_external;

import com.diplomski.backend.external.Pagination;
import com.diplomski.backend.repository.PaginationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaginationService {
    @Autowired
    private PaginationRepository paginationRepository;

    public void savePagination(Pagination pagination){
        paginationRepository.save(pagination);
    }
}
