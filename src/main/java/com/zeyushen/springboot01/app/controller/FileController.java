package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.services.FileServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@Controller
@RequestMapping("/file")
public class FileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @Value("${fileForTarget}")
    private  String fileDir ;

    @Autowired
    private FileServices fileService;


    @GetMapping("/photo/{name}.{type}")
    public void getFile(@PathVariable("name") String name, @PathVariable("type") String type,
                         HttpServletResponse response) {
        //将图片输出给浏览器
       fileService.getFileToResponse("/photo/"+name+"."+type,type,response);
    }

    //下载
    @RequestMapping("/download")
    public void downloadFile(HttpServletResponse response,String filePath,String fileName) {
        try {
            response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Connection", "close");
            response.setHeader("Content-Type", "application/octet-stream");
            OutputStream outputStream = response.getOutputStream();
            filePath=fileDir+filePath;
            filePath=filePath.replace("/file/template","/template");
            FileInputStream fileInputStream = new FileInputStream(filePath);
            FileCopyUtils.copy(fileInputStream,outputStream);
        }catch (Exception e){
            return;
        }
    }



}
