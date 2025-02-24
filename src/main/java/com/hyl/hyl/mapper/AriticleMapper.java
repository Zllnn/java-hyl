package com.hyl.hyl.mapper;

import com.hyl.hyl.pojo.PageBean;
import com.hyl.hyl.pojo.article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AriticleMapper {
    //计算文章总数
    @Select("SELECT COUNT(*) FROM article")
    Long count();

    //分页查询
    @Select("SELECT * FROM article LIMIT #{page},#{pageSize}")
    List<article> getArticle(Long page, Long pageSize);

}
