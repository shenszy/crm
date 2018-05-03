package com.zeyushen.springboot01.app.util;

import org.springframework.beans.factory.annotation.Value;

import java.io.*;

public class FileUtil {
    @Value("${fileForTarget}")
    public static String pathForTarget="G:/code/IdeaProjects/fileForTarget";

    public static String uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(pathForTarget+filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
        return filePath+fileName;
    }
}
