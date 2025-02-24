package com.hyl.hyl.service;

import com.hyl.hyl.pojo.PageBean;

public interface ArticleService {
    PageBean getArticle(Long page, Long size);
}
