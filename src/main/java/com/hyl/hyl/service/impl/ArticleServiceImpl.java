package com.hyl.hyl.service.impl;

import com.hyl.hyl.mapper.AriticleMapper;
import com.hyl.hyl.pojo.PageBean;
import com.hyl.hyl.pojo.article;
import com.hyl.hyl.pojo.Classify;
import com.hyl.hyl.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private AriticleMapper articleMapper;
    @Override
    public PageBean getArticle(Long page, Long size) {
        //获取分页查询的文章
        Long temp = (page-1)*size;
        List<article> articles = articleMapper.getArticle(temp, size);
        //获取文章总数
        Long total = articleMapper.count();
        //创建PageBean对象
        PageBean pageBean = new PageBean(total,articles);
        return pageBean;
    }

    @Override
    public Classify getArticleCount () {
        Long funnyCount = articleMapper.getArticleCountFun();
        Long story = articleMapper.getArticleCountStory();
        return new Classify(funnyCount,story);
    }

    @Override
    public void addArticle(article article) {
//        String articleName = article.getArticleName();
//        String articleContent = article.getArticleContent();
//        String articleAuthor = article.getArticleAuthor();
        //获取当前时间
        Timestamp time = new Timestamp(System.currentTimeMillis());
        // 定义日期格式（例如：yyyy-MM-dd HH:mm:ss）
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 转换为字符串
        String date = sdf.format(time);
        article.setDate(date);
        articleMapper.addArticle(article);
    }

    @Override
    public void editArticle(article article) {
        articleMapper.editArticle(article);
    }

    @Override
    public void deleteArticle(Long id) {
        articleMapper.deleteArticle(id);
    }




}
