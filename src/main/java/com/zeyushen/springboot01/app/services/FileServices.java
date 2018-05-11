package com.zeyushen.springboot01.app.services;

import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.Date;
import java.util.Random;

@Service
public class FileServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileServices.class);

    @Value("${fileForTarget}")
    private  String fileDir ;//= "E:/Desktop/peoject/OrderingSys/file";
    @Value("${previewPath}")
    private String previewPath;

    private Random random = new Random(System.currentTimeMillis());
    /**初始化*/
    @PostConstruct
    public void init() throws NoSuchFileException {
        File dir = new File(fileDir);
        if (!dir.exists()) {
            fileDir = "E:/Desktop/peoject/file";
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
    public String upload(MultipartFile file,String filePath) {
        String fileName;
        if (file == null) {
            return null;
        }
        if(filePath==null||filePath.isEmpty()){
            filePath="/photo/";
        }
        try {
            fileName = System.currentTimeMillis() + random.nextLong() + file.getOriginalFilename();
            fileName = filePath + fileName;
            LOGGER.info("文件上传： {}", fileName);
            FileCopyUtils.copy(file.getBytes(), new File(fileDir + fileName));
        } catch (IOException ioe) {
            LOGGER.error("文件上传异常");
            LOGGER.error(ioe.getMessage());
            return null;
        }

        return "/file"+fileName;
    }

    /**
     * 获取图片到response
     */
    public void getFileToResponse(String url, String type, HttpServletResponse response)  {
       // LOGGER.info("文件输出路径： {}",fileDir);
        //LOGGER.info(fileDir + "/img/" + name + "." + type);
        //将图片输出给浏览器
        try {
            BufferedImage image = ImageIO.read(new File(fileDir + url));
            response.setContentType("image/" + type);

            OutputStream os = response.getOutputStream();
            ImageIO.write(image, type, os);
        } catch (Exception e) {
            LOGGER.error("文件读取异常，返回默认图片。  {}{}",fileDir , url);
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
     *   word文件预览
     */
    public String preview(String filePath){
        int suffix=filePath.lastIndexOf(".docx");//后缀
        filePath=filePath.replaceFirst("/file/template","/template");
        filePath=filePath.replaceFirst("/file/pact","/pact");
        String htmlFile= previewPath+ "/preview.html";
        LOGGER.info("html文件路径:"+htmlFile);
        File fileForDocx=new File(fileDir+filePath);
        //文档中图片
        File imageFolderFile = new File(filePath.substring(0,suffix));
        if(filePath==null||filePath.isEmpty()){
            return "文件不存在!";
        }else {
            try {
                //读取文档内容   docx文档
                XWPFDocument docx = new XWPFDocument(new FileInputStream(fileForDocx));
                //加载html页面时图片路径
                XHTMLOptions options = XHTMLOptions.create().URIResolver( new BasicURIResolver("./"));
                //图片保存文件夹路径
                options.setExtractor(new FileImageExtractor(imageFolderFile));

                FileOutputStream outputStream=new FileOutputStream(htmlFile);
                OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream,"utf-8");
                XHTMLConverter xhtmlConverter=(XHTMLConverter) XHTMLConverter.getInstance();
                xhtmlConverter.convert(docx,outputStreamWriter,options);
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "/preview.html";
        }
    }

    /**
     *  文件下载
     * @param filePath 包含文件名的文件路径（相对路径）
     */
    public void downloadFile(HttpServletRequest request,HttpServletResponse response,String filePath,String fileName){
        if(filePath!=null||!filePath.isEmpty()){
            File file=new File(filePath);
            if(file.exists()){
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition","attachment;fileName=" + fileName);//设置文件名
                byte[] buffer=new byte[1024];
                FileInputStream inputStream=null;
                BufferedInputStream bufferedInputStream=null;
                try {
                    inputStream=new FileInputStream(file);
                    bufferedInputStream=new BufferedInputStream(inputStream);
                    OutputStream outputStream=response.getOutputStream();
                    int i=bufferedInputStream.read(buffer);
                    while(i!=-1){
                        outputStream.write(buffer,0,i);
                        i=bufferedInputStream.read(buffer);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(inputStream!=null||!inputStream.equals("")){
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            if(bufferedInputStream!=null||!bufferedInputStream.equals("")){
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
        return;
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
