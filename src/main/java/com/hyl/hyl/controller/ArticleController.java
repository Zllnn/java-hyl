package com.hyl.hyl.controller;

import com.hyl.hyl.pojo.Classify;
import com.hyl.hyl.pojo.PageBean;
import com.hyl.hyl.pojo.Result;
import com.hyl.hyl.pojo.article;
import com.hyl.hyl.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//日志记录
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/Articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    //获取分页文章列表
    @GetMapping
    public Result getArticle(@RequestParam(value = "page", defaultValue = "1") Long page, @RequestParam(value = "size", defaultValue = "10") Long size) {
        PageBean pageBean = articleService.getArticle(page, size);
        return Result.success(pageBean);
    }

    @GetMapping("/Count")
    public Result getArticleCount () {
        Classify classify = articleService.getArticleCount();
        return Result.success(classify);
    }

    //添加文章
    @PostMapping("/upload")
    public Result addArticle(@RequestBody article article) {
    articleService.addArticle(article);
    return Result.success("文章添加成功",1);
    }

    //编辑文章
    @PutMapping("/edit")
    public Result editArticle(@RequestBody article article) {
        articleService.editArticle(article);
        return Result.success("文章编辑成功",1);
    }

    //删除文章
    @DeleteMapping("/delete/{id}")
    public Result deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        return Result.success("文章删除成功",1);
    }

}
