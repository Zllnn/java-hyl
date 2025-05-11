package com.hyl.hyl.controller;

import com.hyl.hyl.pojo.Result;
import com.hyl.hyl.service.LayoutService;
import com.hyl.hyl.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/layout")
public class LayoutController {
    private final ResourceUrlProvider mvcResourceUrlProvider;

    public LayoutController(ResourceUrlProvider mvcResourceUrlProvider) {
        this.mvcResourceUrlProvider = mvcResourceUrlProvider;
    }
//    @Autowired
//    private LayoutService layoutService;
//@Value("${file.upload-dir}") // 从配置文件读取路径
//private String uploadDir;

    @Resource
    private HttpServletRequest request;


    //头像上传功能
    @PostMapping("/avatar")
    public Result uploadAvatar(@RequestParam("file") MultipartFile file) {
        // 判断文件是否为空
        if (file.isEmpty()) {
            return Result.error("上传的文件为空");
        }
        //校验文件类型
        if (!file.getContentType().startsWith("image/")) {
            return Result.error("仅支持图片文件");
        }
        //生成唯一的文件名
        String fileName = UUID.randomUUID() + "_" + System.currentTimeMillis() +
                "." + FilenameUtils.getExtension(file.getOriginalFilename());

        try {
//            //确保上传目录存在
//            File dir = new File(uploadDir);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }

//            log.info(dir.getAbsolutePath());
//            File dest = new File(dir, fileName);
//            file.transferTo(dest);
            // 获取上传文件的原始文件名
//            String originalFilename = file.getOriginalFilename();
            // 指定文件保存的目录
            String filePath = "D:\\JavaLearning\\uploads\\" + fileName;
            File dest = new File(filePath);
            // 将上传的文件保存到指定位置
            file.transferTo(dest);

//            String fileUrl = "/uploads/" + fileName; // 假设 Nginx 配置了静态资源映射
//            log.info("文件上传成功，URL: {}", fileUrl);
//            return Result.success("上传成功", fileUrl);
//            log.info("文件上传成功，路径为：" + dir+fileName);
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            String httpUrl = basePath + "/upload/" + fileName; //upload为虚拟地址

            return Result.success("文件上传成功" ,httpUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("文件上传失败：" + e.getMessage());
        }
    }
}
