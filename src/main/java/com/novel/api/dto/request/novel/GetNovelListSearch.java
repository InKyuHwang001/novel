package com.novel.api.dto.request.novel;

import com.novel.api.domain.novel.Genre;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static java.lang.Math.min;

@Getter
@Setter
@Builder
public class GetNovelListSearch {


    private static final int MAX_PAGE = 999;
    private static final int MAX_SIZE = 2000;

    private String title;
    private String author;
    private Genre genre;

    @Builder.Default
    private Boolean subscribe = false;
    @Builder.Default
    private Integer page = 1;
    @Builder.Default
    private Integer size = 10;

    public long getOffset() {
        return (long) (page - 1) * min(size, MAX_SIZE);
    }

    public Pageable getPageable() {
        return PageRequest.of(page - 1, size);
    }
}
