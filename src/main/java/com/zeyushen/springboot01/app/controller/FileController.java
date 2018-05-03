package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.services.FileServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;

@Controller
@RequestMapping("/file")
public class FileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @Value("${file.dir}")
    private static String fileDir = "E:/Desktop/peoject/OrderingSys/file";

    @Autowired
    private FileServices fileService;


    @GetMapping("/img/{name}.{type}")
    public void valicode(@PathVariable("name") String name, @PathVariable("type") String type,
                         HttpServletResponse response) throws Exception {
        LOGGER.info("图片获取: {} . {}", name, type);
        LOGGER.info(fileDir + "/img/" + name + "." + type);
        //将图片输出给浏览器
        BufferedImage image = ImageIO.read(new File(fileDir + "/img/" + name + "." + type));
        response.setContentType("image/" + type);
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, type, os);
    }

}