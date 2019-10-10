package com.robert.dubbo.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author changyuwei
 * @date 2019-09-11
 */
public class PageQuery {

    public static final String ASC = "asc";

    public static final String DESC = "desc";

    private Integer page = 1;

    private Integer rows = 10;

    private String[][] sortFields;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String[][] getSortFields() {
        return sortFields;
    }

    public void setSortFields(String[][] sortFields) {
        this.sortFields = sortFields;
    }

//    @JsonIgnore
//    public Pageable getPageable() {
//        List<Sort.Order> orders = Lists.newArrayList();
//        if (sortFields != null && sortFields.length > 0) {
//            for (int i = 0; i < sortFields.length; i++) {
//                orders.add(new Sort.Order(_getDirection(i), sortFields[i][0]));
//            }
//        }
//        if (CollectionUtils.isEmpty(orders)) {
//            return new PageRequest(page - 1, rows);
//        } else {
//            return new PageRequest(page - 1, rows, new Sort(orders));
//        }
//    }
//
//    @JsonIgnore
//    public Sort getSort() {
//        List<Sort.Order> orders = Lists.newArrayList();
//        if (sortFields != null && sortFields.length > 0) {
//            for (int i = 0; i < sortFields.length; i++) {
//                orders.add(new Sort.Order(_getDirection(i), sortFields[i][0]));
//            }
//        }
//        if (CollectionUtils.isEmpty(orders)) {
//            return null;
//        } else {
//            return new Sort(orders);
//        }
//    }

    @JsonIgnore
    public String getOrder$By() {
        String orderBy = "";
        if (sortFields != null && sortFields.length > 0) {
            for (int i = 0; i < sortFields.length; i++) {
                orderBy += sortFields[i][0] + " " + sortFields[i][1] + ",";
            }
        }
        if (StringUtils.isNotEmpty(orderBy)) {
            return StringUtils.substringBeforeLast(orderBy, ",");
        } else {
            return orderBy;
        }
    }

    @JsonIgnore
    public String[] getSort(String sort) {
        List<String> list = Lists.newArrayList();
        if (sortFields != null && sortFields.length > 0) {
            for (int i = 0; i < sortFields.length; i++) {
                if (StringUtils.equalsIgnoreCase(sort, sortFields[i][1])) {
                    list.add(sortFields[i][0]);
                }
            }
        }
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.toArray(new String[]{});
        }
    }

//    private Sort.Direction _getDirection(int i) {
//        if (StringUtils.equalsIgnoreCase(PageQuery.DESC, sortFields[i][1])) {
//            return Sort.Direction.DESC;
//        } else {
//            return Sort.Direction.ASC;
//        }
//    }
}
