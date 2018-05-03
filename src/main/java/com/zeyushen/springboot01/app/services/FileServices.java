package com.zeyushen.springboot01.app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.NoSuchFileException;
import java.util.Date;
import java.util.Random;

/**
 * @author 董文强
 * @Time 2018/5/3 9:37
 */
@Service
public class FileServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileServices.class);

    @Value("${fileForTarget}")
    private  String fileDir ;//= "E:/Desktop/peoject/OrderingSys/file";

    private Random random = new Random(System.currentTimeMillis());
    /**初始化*/
    @PostConstruct
    public void init() throws NoSuchFileException {
        File dir = new File(fileDir);
        if (!dir.exists()) {
            fileDir = "E:/Desktop/peoject/OrderingSys/file";
           dir = new File(fileDir);
            if (!dir.exists()) {
                throw new NoSuchFileException("文件路径" + "不存在");
            }
        }
        LOGGER.info("设置文件路径： {}",fileDir);
    }

    /**
     * 保存图片，返回图片url
     */
    public String upload(MultipartFile file) {
        if (file == null) {
            return null;
        }
        String name;//= System.currentTimeMillis() + random.nextLong()+file.getOriginalFilename();
        try {
            name = System.currentTimeMillis() + random.nextLong() + file.getOriginalFilename();
            name = "/photo/" + name;
            LOGGER.info("文件上传： {}", name);
            FileCopyUtils.copy(file.getBytes(), new File(fileDir + name));
        } catch (IOException ioe) {
            LOGGER.error(ioe.getMessage());
            return null;
        }

        return "/file"+name;
    }

    /**
     * 获取图片到response
     */
    public void getFileToResponse(String url, String type, HttpServletResponse response)  {
        LOGGER.info("文件输出路径： {}",fileDir);
        //LOGGER.info(fileDir + "/img/" + name + "." + type);
        //将图片输出给浏览器
        try {
            BufferedImage image = ImageIO.read(new File(fileDir + url));
            response.setContentType("image/" + type);

            OutputStream os = response.getOutputStream();
            ImageIO.write(image, type, os);
        } catch (Exception e) {
            LOGGER.error("{} {}",fileDir , url);
            try {
                OutputStream os = response.getOutputStream();
                ImageIO.write(errorImg(), "JPEG", os);
            }catch (Exception e1){
                LOGGER.error(e1.getMessage());
            }

        }
    }
    /**
     * 获取图片
     */
    public BufferedImage getFile(String url){
        LOGGER.info("文件输出路径： {}",fileDir);
        //LOGGER.info(fileDir + "/img/" + name + "." + type);
        //将图片输出给浏览器
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(fileDir + url));

        } catch (Exception e) {
            return errorImg();
        }
        return image;
    }


    /**
     * 生成验证码图片文件
     */
    public String verCode(BufferedImage bufimg) {
        int width = 80;
        int height = 40;
        int lines = 10;
        String code = "";
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = img.getGraphics();

        //设置背景色
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);//画背景
        //填充指定的矩形。使用图形上下文的当前颜色填充该矩形

        //设置字体
        g.setFont(new Font("黑体", Font.BOLD, 18));

        //随机数字
        Date d = new Date();
        //System.out.println(d.getTime());
        Random r = new Random(d.getTime());
        for (int i = 0; i < 4; i++) {
            int a = r.nextInt(10);//取10以内的整数[0，9]
            code += a;
            int y = 10 + r.nextInt(20); //10~30范围内的一个整数，作为y坐标
            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            g.setColor(c);
            g.drawString("" + a, 5 + i * width / 4, y);
        }
        //干扰线
        for (int i = 0; i < lines; i++) {
            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            g.setColor(c);
            g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
        }

        g.dispose();//类似于流中的close()带动flush()---把数据刷到img对象当中
        //ImageIO.write(img, "JPG", new FileOutputStream("img/b.jpg"));
        //return img;
        return code;
    }

    /**
     * 生成错误图片
     */
    public BufferedImage errorImg() {
        int width = 125;
        int height = 40;
        String code = "";
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = img.getGraphics();

        //设置背景色
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);//画背景
        //填充指定的矩形。使用图形上下文的当前颜色填充该矩形

        //设置字体
        g.setFont(new Font("黑体", Font.BOLD, 18));

        int y = 25; //10~30范围内的一个整数，作为y坐标
        Color c = new Color(14, 14, 115);
        g.setColor(c);
        g.drawString("图片找不到啦", 5, y);

        g.dispose();//类似于流中的close()带动flush()---把数据刷到img对象当中
        //ImageIO.write(img, "JPG", new FileOutputStream("img/b.jpg"));
        //return img;
        return img;
    }
}
