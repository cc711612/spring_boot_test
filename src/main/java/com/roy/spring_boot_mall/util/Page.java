package com.roy.spring_boot_mall.util;

import lombok.Data;

import java.util.List;
@Data
public class Page<T> {
    private Integer limit;
    private Integer offset;
    private Integer total;
    private List<T> result;
}
