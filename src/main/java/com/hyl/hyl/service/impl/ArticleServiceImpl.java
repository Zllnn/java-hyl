package com.hyl.hyl.service.impl;

import com.hyl.hyl.mapper.AriticleMapper;
import com.hyl.hyl.pojo.PageBean;
import com.hyl.hyl.pojo.article;
import com.hyl.hyl.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
