package com.hyl.hyl.service;

import org.springframework.web.multipart.MultipartFile;

public interface LayoutService {
    //上传头像
    void uploadAvatar(MultipartFile avatar);
}
