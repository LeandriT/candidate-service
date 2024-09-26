package com.seek.candidate_service.dto.abstracts;

import lombok.*;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageBaseDto<T> {
    private Integer size;
    private Integer totalElements;
    private Integer page;
    private Integer totalPages;
    @Builder.Default()
    private List<T> content = Collections.emptyList();
    private Boolean empty;
}