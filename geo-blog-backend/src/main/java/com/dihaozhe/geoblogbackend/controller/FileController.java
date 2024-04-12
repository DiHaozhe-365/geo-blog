package com.dihaozhe.geoblogbackend.controller;

import com.dihaozhe.common.response.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api")
@Tag(name = "File", description = "文件相关接口")
public class FileController {

    @Value("${img.root}")
    private String imgRoot;

    @PostMapping("/img/upload")
    @Operation(summary = "上传图片")
    @ApiOperationSupport(author = "邸浩哲")
    public Result<String> uploadImg(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.failure(400, "上传图片为空");
        }
        try {
            // 获取上传文件的原始文件名
            String originalFileName = file.getOriginalFilename();
            // 构建上传目标路径
            String targetFilePath = imgRoot + File.separator + originalFileName;
            // 保存文件
            file.transferTo(new File(targetFilePath));
            return Result.success(originalFileName);
        } catch (IOException e) {
            return Result.failure(500, "上传图片失败");
        }
    }

    @GetMapping("/img/download")
    @Operation(summary = "下载图片")
    @ApiOperationSupport(author = "邸浩哲")
    public ResponseEntity<FileSystemResource> downloadImg(String img) {
        String filePath = imgRoot + "/" + img;
        log.info("请求的图片是：" + filePath);
        File file = new File(filePath);
        // 检查文件是否存在
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }
        // 使用 FileSystemResource 包装文件并返回 ResponseEntity
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(new FileSystemResource(file));
    }
}
