package com.hyl.hyl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//用于文章分页查找的bean
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;
    private List<article> rows;
}
