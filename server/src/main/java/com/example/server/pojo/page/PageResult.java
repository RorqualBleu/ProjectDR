package com.example.server.pojo.page;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    private List<T> list;
    private long total;

    public PageResult(List<T> list, long total) {
        this.list = list;
        this.total = total;
    }
}
