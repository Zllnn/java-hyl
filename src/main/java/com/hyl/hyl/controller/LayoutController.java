package com.hyl.hyl.controller;

import com.hyl.hyl.pojo.Result;
import com.hyl.hyl.service.LayoutService;
import com.hyl.hyl.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/layout")
public class LayoutController {
//    @Autowired
//    private LayoutService layoutService;

    @PostMapping("/avatar")
    public Result uploadAvatar(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error("上传的文件为空");
        }

        try {
            // 获取上传文件的原始文件名
            String originalFilename = file.getOriginalFilename();
            // 指定文件保存的目录
            String filePath = "D:\\Hyl\\avatars" + originalFilename;
            File dest = new File(filePath);
            // 将上传的文件保存到指定位置
            file.transferTo(dest);
            return Result.success("文件上传成功" ,filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("文件上传失败：" + e.getMessage());
        }
    }
}
