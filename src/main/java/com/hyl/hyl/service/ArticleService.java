package com.hyl.hyl.service;

import com.hyl.hyl.pojo.PageBean;
import com.hyl.hyl.pojo.Classify;
import com.hyl.hyl.pojo.article;

public interface ArticleService {
    PageBean getArticle(Long page, Long size);
    Classify getArticleCount();
    void addArticle(article article);
    void editArticle(article article);
    void deleteArticle(Long id);
}
