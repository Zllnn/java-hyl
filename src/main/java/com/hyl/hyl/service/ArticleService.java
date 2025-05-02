package com.hyl.hyl.service;

import com.hyl.hyl.pojo.PageBean;
import com.hyl.hyl.pojo.Classify;

public interface ArticleService {
    PageBean getArticle(Long page, Long size);
    Classify getArticleCount();
}
