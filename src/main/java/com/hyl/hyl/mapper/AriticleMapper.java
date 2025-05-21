package com.hyl.hyl.mapper;

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

    //查询趣事数量
    @Select("SELECT COUNT(articleGroup) FROM article where articleGroup='趣事'")
    Long getArticleCountFun ();

    //查询小说数量
    @Select("SELECT count(articleGroup) FROM article where articleGroup='小说'")
    Long getArticleCountStory();

    //增加文章
    @Select("INSERT INTO article(articleName,articleContent,articleGroup,articleAuthor,date) VALUES(#{articleName},#{articleContent},#{articleGroup},#{articleAuthor},#{date})")
    void addArticle(article article);

    //编辑文章
    @Select("UPDATE article SET articleName=#{articleName},articleContent=#{articleContent},articleGroup=#{articleGroup},date=#{date} WHERE id=#{id}")
    void editArticle(article article);

    //删除文章
    @Select("DELETE FROM article WHERE id=#{id}")
    void deleteArticle(Long id);


}
