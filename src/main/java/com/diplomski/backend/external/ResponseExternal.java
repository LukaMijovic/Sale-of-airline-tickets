package com.diplomski.backend.external;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ResponseExternal <EDTO> {
    private Pagination pagination;
    private List<EDTO> data;
}
