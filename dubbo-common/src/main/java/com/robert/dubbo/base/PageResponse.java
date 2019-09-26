package com.robert.dubbo.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;
import java.util.function.Function;
import org.springframework.data.domain.Page;

import static java.util.stream.Collectors.toList;

/**
 * @author changyuwei
 * @date 2019-09-11
 */
@Data
public class PageResponse<T> extends BaseBean{

    private static final long serialVersionUID = 5722229848963417628L;

    private Integer rows;
    private Long total = 0L;
    private Integer page = 1;
    private List<T> list = null;

    public PageResponse() {
    }

    public PageResponse(Integer rows) {
        this.rows = rows;
    }

    public PageResponse(Integer rows, Long total, Integer page, List<T> list) {
        this.rows = rows;
        this.total = total;
        this.page = page;
        this.list = list;
    }

    public PageResponse(PageQuery query, Long total, List<T> list) {
        this.rows = query.getRows();
        this.total = total;
        this.page = query.getPage();
        this.list = list;
    }

    public PageResponse(PageInfo<T> page) {
        this.rows = page.getSize();
        this.total = page.getTotal();
        this.page = page.getPageNum();
        if (page.getList() != null) {
            this.list = page.getList();
        }
    }

    public <S> PageResponse(PageInfo<S> page, Function<S, T> mapper) {
        this.rows = page.getPageSize();
        this.total = page.getTotal();
        this.page = page.getPageNum();
        if (page.getList() != null) {
            this.list = page.getList().stream().map(mapper).collect(toList());
        }
    }

    public PageResponse(Page<T> page) {
        this.rows = page.getSize();
        this.total = page.getTotalElements();
        this.page = page.getNumber();
        if (page.getContent() != null) {
            this.list = page.getContent();
        }
    }

    public <S> PageResponse(Page<S> page, Function<S, T> mapper) {
        this.rows = page.getSize();
        this.total = page.getTotalElements();
        this.page = page.getNumber();
        if (page.getContent() != null) {
            this.list = page.getContent().stream().map(mapper).collect(toList());
        }
    }

    public <R> PageResponse<R> convert(Function<T, R> mapper) {
        PageResponse<R> pageResponse = new PageResponse<>();
        pageResponse.setRows(this.rows);
        pageResponse.setTotal(this.total);
        pageResponse.setPage(this.page);
        if (this.list != null) {
            pageResponse.setList(this.list.stream().map(mapper).collect(toList()));
        }
        return pageResponse;
    }

    public <R> PageResponse<R> convertList(Function<List<T>, List<R>> mapper) {
        PageResponse<R> pageResponse = new PageResponse<>();
        pageResponse.setRows(this.rows);
        pageResponse.setTotal(this.total);
        pageResponse.setPage(this.page);
        if (this.list != null) {
            pageResponse.setList(mapper.apply(this.list));
        }
        return pageResponse;
    }

    @JsonIgnore
    public Long getTotalPage() {
        return total == 0 ? 0 : (total / rows) + 1;
    }
}
