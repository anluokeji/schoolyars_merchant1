package com.example.schoolyars_merchant.controller;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Slf4j
@RestController
public class FileController {
    @Value("${tree.file.localPath}")
    private String localPath;
    @Value("${tree.file.baseDomain}")
    private String baseDomain;

    /**
     * @author zf
     * 通用文件上传
     *
     * @param type    路径
     * @param request
     * @return
     */
    @PostMapping("/local/upload")
    public String upload(
            @RequestParam("type") String type,
            HttpServletRequest request
    ) {
        List<String> urls = new ArrayList<>();
        try {
            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            Iterator<String> iterator = req.getFileNames();
            while (iterator.hasNext()) {
                MultipartFile file = req.getFile(iterator.next());

                assert file != null;
                // 获取文件名
                String fileName = file.getOriginalFilename();
                final String rltFileName = getRltFileName(type, fileName);
                final String saveFileName = getSaveFileName(rltFileName);
                final String httpUrl = getHttpUrl(rltFileName);
                byte[] bytes = IoUtil.readBytes(file.getInputStream());
                FileUtil.writeBytes(bytes, saveFileName);
                urls.add(httpUrl);
//                log.info(" 文件:{}上传成功, local:{}  net:{}", fileName, saveFileName, httpUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ("上传失败");
        }
        return (CollUtil.join(urls, ","));
    }

    /**
     * 获取存储相对路径
     * @author zf
     * @param type
     * @param oriFileName
     * @return
     */
    private String getRltFileName(String type, String oriFileName) {
        String suffix = FileUtil.getSuffix(oriFileName);
        return new SimpleDateFormat("yyyyMM").format(new Date()) + "/" + type + "/" + IdUtil.fastSimpleUUID() + "." + suffix;
    }

    private String getSaveFileName(String rltPath) {
        String path = localPath + rltPath;
        final File parentFile = new File(path).getParentFile();
        if (!parentFile.exists()) {
            boolean f = parentFile.mkdirs();
        }
        return path;
    }

    private String getHttpUrl(String rltPath) {
        return baseDomain + rltPath;
    }


}
