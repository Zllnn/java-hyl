package com.hyl.hyl.controller;

import com.hyl.hyl.pojo.PageBean;
import com.hyl.hyl.pojo.Result;
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
}
